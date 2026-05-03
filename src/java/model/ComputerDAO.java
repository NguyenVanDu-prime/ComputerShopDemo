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
import utils.DBUtils;

public class ComputerDAO {

    public ArrayList<ComputerDTO> getAllComputer() throws SQLException {
        ComputerDTO computerDTO = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        ArrayList<ComputerDTO> computerList = new ArrayList<>();

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT Name, Ram, Price FROM Computers");

                rs = ptm.executeQuery(); // list -> 
                // khi khong ket qua -> khong hien gi -> co phai = 0 không ?

                while (rs.next()) { // co ket qua la true                  
                    int price = rs.getInt("Price");
                    String name = rs.getString("Name");
                    String ram = rs.getString("Ram");
                    computerDTO = new ComputerDTO(name, ram, price);
                    computerList.add(computerDTO);
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

        return computerList;
    }

    public boolean addComputer(ComputerDTO computer)
            throws SQLException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement("INSERT INTO Computers(Id, Name, Description, Ram, Price) VALUES (?,?,?,?,?)");

            ptm.setString(1, computer.getId());
            ptm.setString(2, computer.getName());
            ptm.setString(3, computer.getDescription());
            ptm.setString(4, computer.getRam());
            ptm.setInt(5, computer.getPrice());

            int rows = ptm.executeUpdate();
            if (rows > 0) {
                result = true;
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

}
