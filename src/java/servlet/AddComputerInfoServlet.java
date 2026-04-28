
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ComputerDTO;

/**
 *
 * @author admin
 */
@WebServlet(name = "AddComputerInfoServlet", urlPatterns = {"/AddComputerInfoServlet"})
public class AddComputerInfoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ArrayList<ComputerDTO> computerList = new ArrayList<>();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            int sum = 0;
            ComputerDTO computer = new ComputerDTO();
            computer.setName(request.getParameter("nb1"));
            computer.setRam(request.getParameter("nb2"));
            int price = Integer.parseInt(request.getParameter("nb3"));
            computer.setPrice(price);
            computerList.add(computer);
            if(computerList.size() <= 1){
                System.out.println("List is empty");
            }
            else{
                System.out.println("addSucess");    
            }
            request.setAttribute("List_Of_Computer", computerList);
            System.out.println(computerList);
            for(ComputerDTO a : computerList){
                sum += a.getPrice();
            }
            System.out.println(sum);
            request.setAttribute("TongTien", sum);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            request.getRequestDispatcher("index3.jsp").forward(request, response);
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
