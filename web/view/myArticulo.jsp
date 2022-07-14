<%-- 
    Document   : myArticulo
    Created on : 30-jun-2022, 10:24:52
    Author     : edins
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Model.Articulo"%>
<%@page import="java.util.List"%>
<%@page import="ModelDAO.ArticuloDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
      <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <link href="src/css/MyStyle.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    
    </head>
    <jsp:include page="menu.jsp"></jsp:include>
    
        
        <body>
         <div class="container" id="Contenido">
            <h1>Mis Articulos</h1>
            <div class="row row-cols-1 row-cols-md-4 g-4">
                 <%
                        HttpSession sesion=request.getSession(); 
                        String Idusuario=sesion.getAttribute("SIdUsuario").toString();
                        int id = Integer.parseInt(Idusuario);
                        ArticuloDAO dao = new ArticuloDAO();
                        List<Articulo>list=dao.ListaArtUsuarui(id);
                        Iterator<Articulo>iter=list.iterator();
                        Articulo art=null;
                        while(iter.hasNext()){
                            art=iter.next();
                        int estado=Integer.parseInt(art.getEstado().toString());
                            
            %>
            
              <div class="col">
                <div class="card h-100">
                  <img src="src/img/teclado01.jpg" class="card-img-top" alt="...">
                  <div class="card-body">
                      <h5 class="card-title"><%= art.getTituloArticulo()%></h5>
                    
                    <h6><span class="badge bg-secondary">Audifonos</span>
                      <span class="badge bg-secondary">conectores</span>
                      <span class="badge bg-secondary">Cartas</span></h6>
                    <a href="Controller?accion=intercambiar&codigo=<%= art.getIdArticulo()%>" class="btn btmCompra">Mensajes</a>
                    
                    <%
                        if(estado==1){
                      
                        }else {
                    %>
                    <a href="ControllerArticulo?accion=editarArticulo&codigo=<%= art.getIdArticulo()%>" class="btn btn-warning"><i class="fa-solid fa-pen-to-square"></i></a>
                    <a href="ControllerArticulo?accion=eliminarArticulo&codigo=<%= art.getIdArticulo()%>" class="btn btn-danger"><i class="fa-solid fa-trash-can"></i></a>
                    <%
                        }
                    %>
                    
                  </div>
                </div>
              </div>
              
            <%
            }
            %>
            </div>
            
           
        </div>
            
       

  <!-- Footer -->
  
  <jsp:include page="footer.jsp"></jsp:include>
  <!-- Footer -->

        
<!-- End of .container -->
    </body>
        
        
    
    
</html>
