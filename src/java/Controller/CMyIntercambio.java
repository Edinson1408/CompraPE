/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ModelDAO.MyIntercambioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.MyIntercambio;
import java.util.ArrayList;
import com.google.gson.Gson;
import ModelDAO.ArticuloDAO;
/**
 *
 * @author edins
 */
public class CMyIntercambio extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Gson gson = new Gson();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CMyIntercambio</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CMyIntercambio at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
            //processRequest(request, response);
            String acceso="";
                String action=request.getParameter("accion");
                System.out.println("Accion : " + action );
                
             if (action.equalsIgnoreCase("MyIntercambios")){
                acceso="view/myIntercambio.jsp";
                System.out.println("Accion : MyIntercambios" );
                 
                    int IdUsuario=Integer.parseInt(request.getParameter("idUser"));
                 MyIntercambioDAO daoi =new MyIntercambioDAO();
                 MyIntercambioDAO inter;
                 ArrayList<MyIntercambio>lista2;   
                 lista2=daoi.ListaMisIntervambios(IdUsuario);
                 request.setAttribute("listaMensaje",lista2);
                /*
                 IntercambioDAO daoi =new IntercambioDAO();
                    Intercambio inter;
                    ArrayList<Intercambio>lista2;   
                    inter = new Intercambio();
                    lista2=daoi.ListarMensajes(cod);
            
            //validamos los si el usuario es el que ingresa
            request.setAttribute("listaMensaje",lista2);
                */
                RequestDispatcher vista=request.getRequestDispatcher(acceso);
                vista.forward(request, response);
                  }
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
                //processRequest(request, response);
                ArticuloDAO daoArticulo=new ArticuloDAO();
                 String action=request.getParameter("accion");
                  if (action.equalsIgnoreCase("PruebaJson")){

                    String idIntercambio=request.getParameter("idIntercambio");
                    int idIntercambio_=Integer.parseInt(idIntercambio);
                    
                    String idArticulo=request.getParameter("idArticulo");
                    int idArticulo_=Integer.parseInt(idArticulo);
                    //Articulo a;
                    
                    boolean estado=daoArticulo.updateEstadoTerminado(idIntercambio_, idArticulo_);
                   //daoIntercambio.updateEstado(idIntercambio_);
                    /*        int cod=Integer.parseInt(id);
                            acceso=Intercambiar;
                            ArticuloDAO dao=new ArticuloDAO();
                            Articulo a;
                            ArrayList<Articulo>lista;
                            //Listamos uno 

                            a =new Articulo();
                            a =dao.list(cod);
                        */

                        String employeeJsonString = this.gson.toJson(estado);
                        PrintWriter out = response.getWriter();
                        response.setContentType("application/json");
                        response.setCharacterEncoding("UTF-8");
                        out.print(employeeJsonString);
                        out.flush(); 
                        
                 
          
                    }
                
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
