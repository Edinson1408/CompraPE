/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Usuario;
import ModelDAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
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
public class ControllerUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String addUser="view/addUser.jsp";
    String login="view/login.jsp";
    String principal="index.jsp";
    String edituser="view/editUser.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerUsuario at " + request.getContextPath() + "</h1>");
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
        Usuario u;
        UsuarioDAO ud=new UsuarioDAO();
        
        
        if (action.equalsIgnoreCase("addUser")){
            acceso=addUser;
 
        }
        if(action.equalsIgnoreCase("editUser")){
            acceso=edituser;
            //traemos los datos del usuario de list
                String id=request.getParameter("idUser");
                int cod = Integer.parseInt(id);
                UsuarioDAO dao=new UsuarioDAO();
                ArrayList<Usuario>Lista;
                u = new Usuario();
                u= dao.list(cod);
                
                request.setAttribute("User", u);
        }
        if (action.equalsIgnoreCase("cerrarSession")) {
            acceso=principal;
            request.getSession().invalidate();
        }
        System.out.println("Accion"+action );
        
        
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
                //processRequest(request, response);
                String acceso="";
                String action=request.getParameter("accion");
                Usuario u;
                UsuarioDAO ud=new UsuarioDAO();
                
        if(action.equalsIgnoreCase("agregarUsuario")){
                        acceso=login;
                        System.out.println("Accion :"+action );
                        String Nombres = request.getParameter("Nombres");
                        String Apellidos = request.getParameter("Apellidos");
                        String UserName = request.getParameter("UserName");
                        String Email = request.getParameter("Email");
                        String PasswordHash = request.getParameter("PassWord");
                        String Celular = request.getParameter("Celular");
                        String Distrito = request.getParameter("Distrito");
                        String FechaNacimiento = request.getParameter("FechaNacimiento");
                        String Sexo = request.getParameter("Sexo");
                       int id=0;
                        u=new Usuario(id, Nombres,  Apellidos,  UserName,  Email,  PasswordHash,  Celular,  Distrito,  FechaNacimiento,  Sexo) ;
                        ud.add(u);
                        
                        request.setAttribute("Usuario","Se creo usuario correctamente!");        
        }
       
        if(action.equalsIgnoreCase("inicioSession")){
            
            //datos del la session
            String user=request.getParameter("txtuser");
            String pass=request.getParameter("txtpass");
            UsuarioDAO dao=new UsuarioDAO();
            ArrayList<Usuario>lista;
            
            u= new Usuario();
            u=dao.login(user, pass);
            if(Objects.isNull(u)){
                acceso=login;
                request.setAttribute("Usuario","usuario o Contraseña incorrecto");        
            }
            else{
                  acceso=principal;
                  
                  HttpSession sesion=request.getSession(); 
                  sesion.setAttribute("SObjUsuario",u);
                  sesion.setAttribute("SIdUsuario",u.getId());
                  sesion.setAttribute("SIUserName",u.getUserName());
                  
                  
            }
            //Objects.isNull(getUserObject)
            
        }
        
        if(action.equalsIgnoreCase("actualizarUsuario")){
                        String Nombres = request.getParameter("Nombres");
                        String Apellidos = request.getParameter("Apellidos");
                        String UserName = request.getParameter("UserName");
                        String Email = request.getParameter("Email");
                        String PasswordHash = request.getParameter("PassWord");
                        String Celular = request.getParameter("Celular");
                        String Distrito = request.getParameter("Distrito");
                        String FechaNacimiento = request.getParameter("FechaNacimiento");
                        String Sexo = request.getParameter("Sexo");
                        
                        String id=request.getParameter("idUser");
                        int cod = Integer.parseInt(id);
                        
                        u=new Usuario(cod,Nombres,  Apellidos,  UserName,  Email,  PasswordHash,  Celular,  Distrito,  FechaNacimiento,  Sexo) ;
                        ud.edit(u);
                        acceso=login;
        }
       
        
        
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
                 
                
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
