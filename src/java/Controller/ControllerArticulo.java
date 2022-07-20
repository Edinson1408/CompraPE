/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Articulo;
import ModelDAO.ArticuloDAO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author edins
 */
@MultipartConfig
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
    String AddArticulo = "view/addArticulo.jsp";
    String editArticulo = "view/editArticulo.jsp";
    String myArticulo = "view/myArticulo.jsp";
    String login = "view/login.jsp";

    // Subir directorio de almacenamiento de archivos
    private static final String UPLOAD_DIRECTORY = "upload";

    // Cargar configuración
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

    //private String pathFiles = "D:\\PROYECTO\\CompraPE\\web\\src\\files\\";
    private String pathFiles = "C:\\Users\\edins\\OneDrive\\Escritorio\\Web_Integracion\\CompraPE\\web\\src\\files";

    private File uploads = new File(pathFiles);
    
    public class UploadServlet extends HttpServlet {
        // ...
    }

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
        String acceso = "";
        String action = request.getParameter("accion");
        Articulo a;
        ArticuloDAO artDao = new ArticuloDAO();

        if (action.equalsIgnoreCase("addArticulo")) {

            acceso = AddArticulo;

            request.setAttribute("idUser", request.getParameter("idUser"));

        }
        if (action.equalsIgnoreCase("myArticulo")) {

            //verificar si tiene session abierta si no le pediresmos iniciar session
            HttpSession sesion = request.getSession();
            if (sesion.getAttribute("SIdUsuario") == null) {
                acceso = login;
            } else {
                request.setAttribute("IdUsuario", request.getParameter("IdUsuario"));
                acceso = myArticulo;
            }

        }

        if (action.equalsIgnoreCase("eliminarArticulo")) {
            int Codigo = Integer.parseInt(request.getParameter("codigo"));

            artDao.delete(Codigo);

            acceso = myArticulo;
        }

        if (action.equalsIgnoreCase("editarArticulo")) {

            int Codigo = Integer.parseInt(request.getParameter("codigo"));
            ArticuloDAO dao = new ArticuloDAO();
            ArrayList<Articulo> Lista;
            a = new Articulo();
            a = dao.list(Codigo);
            acceso = editArticulo;
            request.setAttribute("art", a);

        }

        //processRequest(request, response);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
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

        String acceso = "";
        String action = request.getParameter("accion");

        ArticuloDAO dao = new ArticuloDAO();
        Articulo a;

      

        if (action.equalsIgnoreCase("publicarArticulo")) {

            Part part = request.getPart("fileImagen");
            //vamos a crear los articulos
            //String Id_articulo =request.getParameter("Id_articulo");
            String NomArticulo = request.getParameter("NomArticulo");
            String IdCategoria = request.getParameter("IdCategoria");
            String FechaCreacionArt = "";
            String DistritoArticulo = request.getParameter("DistritoArticulo");
            String PreferenciaArticulo = request.getParameter("PreferenciaArticulo");
            String TituloArticulo = request.getParameter("TituloArticulo");
            String EstadoArticulo = request.getParameter("EstadoArticulo");
            String DescripcionArticulo = request.getParameter("DescripcionArticulo");
            //String Imagen =request.getParameter("IdUsuario")+request.getParameter("Imagen");
            //String Imagen = request.getParameter("IdUsuario") + "imagen.jpg";
            String Imagen = saveFile(part, uploads);
            int IdUsuario = Integer.parseInt(request.getParameter("IdUsuario"));
            int id = 0;

            System.out.println(
                    "Accion " + request.getParameter("IdUsuario"));
            a = new Articulo(id, NomArticulo, FechaCreacionArt, DistritoArticulo, PreferenciaArticulo, TituloArticulo, EstadoArticulo, DescripcionArticulo, Imagen, IdCategoria, IdUsuario,"");

            dao.add(a);
            //te enviara a la pagina de tus artuculos

            request.setAttribute(
                    "IdUsuario", request.getParameter("IdUsuario"));
            acceso = myArticulo;
        }

        if (action.equalsIgnoreCase("updateArticulo")) {

            int IdArticulo = Integer.parseInt(request.getParameter("IdArticulo"));

            String NomArticulo = request.getParameter("NomArticulo");
            String IdCategoria = request.getParameter("IdCategoria");
            String DistritoArticulo = request.getParameter("DistritoArticulo");
            String TituloArticulo = request.getParameter("TituloArticulo");
            String EstadoArticulo = request.getParameter("EstadoArticulo");
            String DescripcionArticulo = request.getParameter("DescripcionArticulo");
            //String Imagen = request.getParameter("Imagen");
            //String Imagen =request.getParameter("IdUsuario")+request.getParameter("Imagen");
            String Imagen = request.getParameter("IdUsuario") + "imagen.jpg";

            int IdUsuario = Integer.parseInt(request.getParameter("IdUsuario"));

            //String id=request.getParameter("idUser");
            //int cod = Integer.parseInt(id);
            a = new Articulo(IdArticulo, NomArticulo, DescripcionArticulo, DistritoArticulo, DescripcionArticulo, TituloArticulo, EstadoArticulo, DescripcionArticulo, Imagen, IdCategoria, IdUsuario,"");
            //u=new Usuario(cod,Nombres,  Apellidos,  UserName,  Email,  PasswordHash,  Celular,  Distrito,  FechaNacimiento,  Sexo) ;
            //ud.edit(u);
            dao.edit(a);

            request.setAttribute("IdUsuario", request.getParameter("IdUsuario"));
            acceso = myArticulo;
        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso);
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
