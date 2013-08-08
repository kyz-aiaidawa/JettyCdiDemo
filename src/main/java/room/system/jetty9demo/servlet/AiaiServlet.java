/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package room.system.jetty9demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import room.system.jetty9demo.cdi.CdiSessionBean;

/**
 *
 * @author lisa
 */
@WebServlet(name = "AiaiServlet", urlPatterns = {"/AiaiServlet"})
public class AiaiServlet extends HttpServlet {

    private CdiSessionBean cdi;

    @Inject
    void init(CdiSessionBean cdi) {
        //注入ポイン　CdiSessionBeanのコンストラクタ、 @PostConstructの順に実行される。
        // new は使わない。
        this.cdi = cdi;
      
    }

    @Override
    public void init() throws ServletException {
        try {
            super.init(); //To change body of generated methods, choose Tools | Templates.
            InitialContext ctx = new InitialContext();
             
            NamingEnumeration<NameClassPair> list = ctx.list("");
            while (list.hasMore()) {
                System.out.println("name is " + list.next().getName());
            }
        } catch (NamingException ex) {
            Logger.getLogger(AiaiServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AiaiServlet</title>");            
            out.println("</head>");
            out.println("<body>");
             
            
            out.println("<h1>AiaiServlet is CDI Inject Servlet  " + "</h1>");
             if(cdi != null){
               cdi.addName("Injected.");
               out.print("<h2>");
               out.print(cdi.getName());
               out.println("</h2>");
           }
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
