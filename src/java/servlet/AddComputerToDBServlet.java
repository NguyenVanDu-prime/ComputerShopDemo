/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ComputerDAO;
import model.ComputerDTO;

/**
 *
 * @author admin
 */
@WebServlet(name = "AddComputerToDBServlet", urlPatterns = {"/AddComputerToDBServlet"})
public class AddComputerToDBServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            ComputerDTO computer = new ComputerDTO();
            ComputerDAO computerDAO = new ComputerDAO();
            computer.setId(request.getParameter("nb1"));
            computer.setName(request.getParameter("nb2"));
            computer.setDescription(request.getParameter("nb3"));
            computer.setRam(request.getParameter("nb4"));
            computer.setPrice(Integer.parseInt(request.getParameter("nb5")));
            //nếu dòng này bị lỗi nhảy xuống catch liền
            boolean result = computerDAO.addComputer(computer);
            if (result == true) {
                System.out.println("add new Computer DB successfully");
                response.sendRedirect("success.html");
            } else {
                System.err.println("Adding computers failed");
                response.sendRedirect("fail.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Adding computers failed");
            response.sendRedirect("fail.html");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
