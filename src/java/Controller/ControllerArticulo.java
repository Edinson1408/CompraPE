/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Articulo;
import ModelDAO.ArticuloDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author edins
 */
public class ControllerArticulo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        
    String AddArticulo="view/addArticulo.jsp";
    String editArticulo="view/editArticulo.jsp";
    String myArticulo="view/myArticulo.jsp";
    String login="view/login.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerArticulo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerArticulo at " + request.getContextPath() + "</h1>");
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
            String acceso="";
            String action=request.getParameter("accion");
            Articulo a;
            ArticuloDAO artDao  = new ArticuloDAO();
                    
        
              if (action.equalsIgnoreCase("addArticulo")){
                  
                    acceso=AddArticulo;
                    
                    request.setAttribute("idUser",request.getParameter("idUser")); 
 
               }   
              if (action.equalsIgnoreCase("myArticulo")) {
                    
                    //verificar si tiene session abierta si no le pediresmos iniciar session
                    HttpSession sesion=request.getSession(); 
                    if(sesion.getAttribute("SIdUsuario")==null){
                            acceso=login;    
                    }else{
                        request.setAttribute("IdUsuario",request.getParameter("IdUsuario"));       
                            acceso=myArticulo;    
                    }
                    
               }
              
              if(action.equalsIgnoreCase("eliminarArticulo")){
                  int Codigo=Integer.parseInt(request.getParameter("codigo"));
            
                  artDao.delete(Codigo);
                  
                  acceso=myArticulo;
              }
              
              if (action.equalsIgnoreCase("editarArticulo")){
                  
                  int Codigo=Integer.parseInt(request.getParameter("codigo"));
                  ArticuloDAO dao=new ArticuloDAO();
                  ArrayList<Articulo>Lista;
                  a =new Articulo();
                  a=dao.list(Codigo);
                  acceso=editArticulo;
                  request.setAttribute("art", a);
                  
              }
            
            //processRequest(request, response);
            RequestDispatcher vista=request.getRequestDispatcher(acceso);
            vista.forward(request, response);
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
            String acceso="";
            String action=request.getParameter("accion");
            
            ArticuloDAO dao=new ArticuloDAO();
            Articulo a;
     
            
            if (action.equalsIgnoreCase("publicarArticulo")) {
                //vamos a crear los articulos
                        //String Id_articulo =request.getParameter("Id_articulo");
                        String NomArticulo  = request.getParameter("NomArticulo");
                        String IdCategoria =request.getParameter("IdCategoria");
                        String FechaCreacionArt ="";
                        String DistritoArticulo =request.getParameter("DistritoArticulo");
                        String PreferenciaArticulo =request.getParameter("PreferenciaArticulo");
                        String TituloArticulo =request.getParameter("TituloArticulo");
                        String EstadoArticulo =request.getParameter("EstadoArticulo");
                        String DescripcionArticulo =request.getParameter("DescripcionArticulo");
                        //String Imagen =request.getParameter("IdUsuario")+request.getParameter("Imagen");
                        String Imagen =request.getParameter("IdUsuario")+"imagen.jpg";
                        int IdUsuario = Integer.parseInt(request.getParameter("IdUsuario"));
                       int id=0;
                         System.out.println("Accion "+ request.getParameter("IdUsuario") );
                        a=new Articulo(id, NomArticulo, FechaCreacionArt, DistritoArticulo, PreferenciaArticulo, TituloArticulo, EstadoArticulo, DescripcionArticulo, Imagen, IdCategoria, IdUsuario);
                        dao.add(a);
                        //te enviara a la pagina de tus artuculos
                        request.setAttribute("IdUsuario",request.getParameter("IdUsuario"));       
                        acceso=myArticulo;
            }
            
            if (action.equalsIgnoreCase("updateArticulo")){
                
                request.setAttribute("IdUsuario",request.getParameter("IdUsuario"));       
                acceso=myArticulo;
            }
            
            RequestDispatcher vista=request.getRequestDispatcher(acceso);
            vista.forward(request, response);
            //processRequest(request, response);
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
