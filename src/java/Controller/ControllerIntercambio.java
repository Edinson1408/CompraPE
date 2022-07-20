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
import Model.Intercambio;
import Model.MyIntercambio;
import ModelDAO.IntercambioDAO;
import com.google.gson.Gson;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
/**
 *
 * @author edins
 */
@MultipartConfig
public class ControllerIntercambio extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String Intercambiar="view/intercambiar.jsp";
    String myIntercambio="view/myIntercambio.jsp";
    
    
    // Subir directorio de almacenamiento de archivos
    private static final String UPLOAD_DIRECTORY = "upload";

    // Cargar configuración
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

    //private String pathFiles = "D:\\PROYECTO\\CompraPE\\web\\src\\files\\";
    private String pathFiles = "C:\\Users\\edins\\OneDrive\\Escritorio\\Web_Integracion\\CompraPE\\web\\src\\files";

    private File uploads = new File(pathFiles);
    
    
      private Gson gson = new Gson();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerIntercambio</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerIntercambio at " + request.getContextPath() + "</h1>");
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
        
        //iniciando los dao y la estructuras de objetos
        
        IntercambioDAO daoi =new IntercambioDAO();
        Intercambio inter;
        MyIntercambio myInter;
        
        
            String acceso="";
        String action=request.getParameter("accion");
        if (action.equalsIgnoreCase("PruebaJson")){
            
            String id=request.getParameter("codigo");
            
                    int cod=Integer.parseInt(id);
                    acceso=Intercambiar;
                    ArticuloDAO dao=new ArticuloDAO();
                    Articulo a;
                    ArrayList<Articulo>lista;
                    //Listamos uno 

                    a =new Articulo();
                    a =dao.list(cod);
          
                   
                String employeeJsonString = this.gson.toJson(a);
                PrintWriter out = response.getWriter();
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.print(employeeJsonString);
                out.flush(); 
                 
          
        }
       
        //processRequest(request, response);
        
        
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
          ArticuloDAO daoArticulo=new ArticuloDAO();
          IntercambioDAO daoIntercambio = new IntercambioDAO();
            String action=request.getParameter("accion");
            if(action.equalsIgnoreCase("agregarMensaje")){                 
                 //debemos agregar el intercambio

                 /*Agrgacion de imagen */
                 Part part = request.getPart("fileImagen");
                 
                    String id=request.getParameter("Id_articulo");
                    
                    int cod=Integer.parseInt(id);
                    acceso=Intercambiar;
                    ArticuloDAO dao=new ArticuloDAO();
                    Articulo a;
                    ArrayList<Articulo>lista;
                    //Listamos uno 

                    a =new Articulo();
                    a =dao.list(cod);
                     
                    Intercambio i;
                    i= new Intercambio();
                    IntercambioDAO idao=new IntercambioDAO();
                    
                    int usuario =a.getIdUsuario();
                    HttpSession sesion=request.getSession(); 
                    //convertir a int
                    int IdUserLog=Integer.parseInt(sesion.getAttribute("SIdUsuario").toString());
                    String userLogeado=null;
                    sesion.setAttribute("userLogeado",null);

                    if(usuario==IdUserLog){
                        /*userLogeado="SI";
                        request.setAttribute("User",userLogeado);
                        sesion.setAttribute("userLogeado","SI");      */
                        sesion.setAttribute("userLogeado","SI");

                    }
                    
                    
                    //insertamos el mensaje
                    String Mensaje=request.getParameter("Mensaje");
                    String EstadoArticulo=request.getParameter("EstadoArticulo");
                    String Id_articulo =request.getParameter("Id_articulo");
                    int  IdUsuario=Integer.parseInt(request.getParameter("IdUsuario"));
                    
                    /*recupera imagen*/
                    String Imagen = saveFile(part, uploads);
                    System.out.println("imagen :"+ Imagen );
                    i = new Intercambio(0, Mensaje, "",Id_articulo, EstadoArticulo,  IdUsuario,Imagen);
                    idao.add(i);
                        
               
                    IntercambioDAO daoi =new IntercambioDAO();
                    Intercambio inter;
                    ArrayList<Intercambio>lista2;   
                    inter = new Intercambio();
                    lista2=daoi.ListarMensajes(cod);
            
            //validamos los si el usuario es el que ingresa
            request.setAttribute("listaMensaje",lista2);
                    request.setAttribute("UserSession",sesion.getAttribute("SIdUsuario").toString());
                    //validamos los si el usuario es el que ingresa
                    request.setAttribute("art",a);
                    RequestDispatcher vista=request.getRequestDispatcher(acceso);
                    vista.forward(request, response);
              }
             
               
               
                if (action.equalsIgnoreCase("PruebaJson")){

                    String idIntercambio=request.getParameter("idIntercambio");
                    int idIntercambio_=Integer.parseInt(idIntercambio);
                    
                    String idArticulo=request.getParameter("idArticulo");
                    int idArticulo_=Integer.parseInt(idArticulo);
                    Articulo a;
                    boolean estado=daoArticulo.updateEstado(idArticulo_);
                   daoIntercambio.updateEstado(idIntercambio_);
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

     private String saveFile(Part part, File pathUploads) {
        Random rnd = new Random();
        String pathAbsolute = "";

        try {
            Path path = Paths.get(part.getSubmittedFileName());
            String fileNameFull = path.getFileName().toString();

            String fileNameReplace = fileNameFull.replace(" ", "");
            String fileName = "img_" + rnd.nextInt() + "_" + fileNameReplace;
            InputStream input = part.getInputStream();
            if (input != null) {
                File file = new File(pathUploads, fileName);
                pathAbsolute = fileName;
                Files.copy(input, file.toPath());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return pathAbsolute;
    }
}
