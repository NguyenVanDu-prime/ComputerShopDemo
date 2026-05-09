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
import java.util.HashSet;
import java.util.List;
import org.apache.catalina.Role;
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

    public AccountDTO getAccount(String userName, String password) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        AccountDTO account = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("Select Name, Password, Role from Account Where Name = ? AND Password = ?");
                ptm.setString(1, userName);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String Name = rs.getNString("Name");
                    String Password = rs.getNString("Password");
                    String Role = rs.getNString("Role");
                    account = new AccountDTO(Name, Password, Role);
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
        return account;
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

    public HashSet<String> getAllRole() throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        HashSet<String> listOfRole = new HashSet<>();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("Select Role from Account");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String role = rs.getNString("Role");
                    listOfRole.add(role);
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
        return listOfRole;
    }

    public boolean registerAccount(AccountDTO account) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        boolean result = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("INSERT INTO Account (Name, Password, Role)\n"
                        + "VALUES \n"
                        + "(?,?,?)");
                ptm.setString(1, account.getName());
                ptm.setString(2, account.getPassword());
                ptm.setString(3, account.getRole());

                int rows = ptm.executeUpdate();
                if (rows > 0) {
                    return true;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public ArrayList<AccountDTO> getAccountsByFirstLetter(String username) throws SQLException{
        Connection conn = null;
        PreparedStatement ptm = null;
        AccountDTO account = null;
        ArrayList<AccountDTO> listOfAccount = new ArrayList<>();
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn != null){
                ptm = conn.prepareStatement("SELECT * FROM Account WHERE Name LIKE ?");
                ptm.setString(1,"%" + username + "%");
                rs = ptm.executeQuery();
                while(rs.next()){
                    String name = rs.getNString("Name");
                    String password = rs.getNString("Password");
                    String role = rs.getNString("Role");
                    account = new AccountDTO(name, password, role);
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
