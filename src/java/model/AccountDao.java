/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

public class AccountDao {

    public boolean checkLogin(String userName, String password) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("Select Name, Password, Role from Account Where Name = ? AND Password = ?");
                ptm.setString(1, userName);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

    public List<AccountDTO> getAllAccount() throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        ArrayList<AccountDTO> listOfAccount = new ArrayList<>();

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT * FROM Account");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String name = rs.getString("Name");
                    String password = rs.getString("password");
                    String role = rs.getString("Role");
                    AccountDTO account = new AccountDTO(name, password, role);
                    listOfAccount.add(account);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return listOfAccount;
    }
}
