/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.server;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.contact.Contact;
import model.contact.ContactList;
import model.sql.JDBCConnection;


/**
 *
 * @author Eric
 */
@WebServlet(name = "AddContact", urlPatterns = {"/AddContact"})
public class AddContact extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");

        JDBCConnection connection = JDBCConnection.getInstance();

        ContactList contactList = connection.getSortedContactList();

        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Contact Table</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Contacts</h1>");
            out.println("<br/>");
            if (firstName != null && lastName != null) {
                if (firstName.length() > 25 || lastName.length() > 25) {
                    out.println("Name is too long");
                } else if (firstName.length() < 3 || lastName.length() < 3) {
                    out.println("Name is too short.");
                } else {
                    out.println(firstName + " " + lastName + " has been added to the database.");
                    Contact c = new Contact(firstName, lastName);
                    connection.addContact(c);
                    contactList = connection.getSortedContactList();
                }
            }
            out.println("<br/>");
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<th>First Name</th>");
            out.println("<th>Last Name</th>");
            out.println("</tr>");
            for (int i = 0; i < contactList.size(); i++) {
                out.println("<tr>");
                out.println("<td>" + contactList.get(i).getFirstName() + "</td>");
                out.println("<td>" + contactList.get(i).getLastName() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
