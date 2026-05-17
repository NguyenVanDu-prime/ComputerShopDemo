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
                ptm = conn.prepareStatement("SELECT * FROM Computers");

                rs = ptm.executeQuery(); // list -> 
                // khi khong ket qua -> khong hien gi -> co phai = 0 không ?

                while (rs.next()) { // co ket qua la true 
                    String id = rs.getString("id");
                    int price = rs.getInt("Price");
                    String description = rs.getNString("Description");
                    String name = rs.getString("Name");
                    String ram = rs.getString("Ram");
                    computerDTO = new ComputerDTO(id, name, description, ram, price);
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

    public ArrayList<ComputerDTO> getComputerByLetter(String letter) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        ComputerDTO computer = null;
        ArrayList<ComputerDTO> listOfComputer = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("Select * from Computers WHERE Name LIKE ?");
                ptm.setNString(1, "%" + letter + "%");

                rs = ptm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("Id");
                    String name = rs.getString("Name");
                    String description = rs.getString("Description");
                    String Ram = rs.getString("Ram");
                    int price = rs.getInt("Price");
                    computer = new ComputerDTO(id, name, description, Ram, price);
                    listOfComputer.add(computer);
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
        return listOfComputer;
    }

    public boolean deleteComputer(String id) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        boolean result = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("DELETE FROM Computers WHERE Id=?");
                ptm.setString(1, id);

                int row = ptm.executeUpdate();
                if (row > 0) {
                    result = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                ptm.close();
            }
        }
        return result;
    }

    public ComputerDTO getComputerById(String id) throws SQLException{
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        ComputerDTO computer = null;
        try {
            conn = DBUtils.getConnection();
            if(conn != null){
                ptm = conn.prepareStatement("SELECT * FROM Computers Where Id = ?");
                ptm.setString(1, id);
                
                rs = ptm.executeQuery();
                if(rs.next()){
                    String Id = rs.getString("Id");
                    String Name = rs.getString("Name");
                    String Description = rs.getString("Ram");
                    int Price = Integer.parseInt(rs.getString("Price"));
                    computer = new ComputerDTO(Id, Name, Description, Name, Price);    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
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
        return computer;
    }
}
