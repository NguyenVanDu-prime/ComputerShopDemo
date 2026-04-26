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

                while(rs.next()) { // co ket qua la true                  
                    int price = rs.getInt("Price");
                    String name = rs.getString("name");
                    String ram = rs.getString("Ram");
                    computerDTO = new ComputerDTO(name,ram,price);
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
    
}
