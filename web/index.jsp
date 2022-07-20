<%-- 
    Document   : index.jsp
    Created on : 15-jun-2022, 22:58:59
    Author     : edins
--%>
<%
 HttpSession sesion=request.getSession(); 
%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ModelDAO.ArticuloDAO"%>
<%@page import="Model.Articulo"%>
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    </head>
    
    <jsp:include page="view/menu.jsp"></jsp:include>
    
    
    <body>
         <div class="container" id="Contenido">
             
             <br>
             <br>
            <!--<h1>Lista de articulos</h1>-->
            <div class="row row-cols-1 row-cols-md-4 g-4">
                 <%
                     
                 int UserSession1=0;
                 if(sesion.getAttribute("SIdUsuario")==null) 
                 {
                      UserSession1=0;
                 }else{
                     UserSession1=Integer.parseInt(sesion.getAttribute("SIdUsuario").toString());
                 }
                
   
                ArticuloDAO dao = new ArticuloDAO();
                List<Articulo>list=dao.listar();
                Iterator<Articulo>iter=list.iterator();
                Articulo art=null;
                while(iter.hasNext()){
                    art=iter.next();
                
                
                   
            %>
            
              <div class="col">
                <div class="card h-100">
                  <!--<img src="src/img/teclado01.jpg" class="card-img-top" alt="...">-->
                  <img src="src/files/<%= art.getImagen()%>" class="card-img-top" alt="...">
                  <div class="card-body">
                      <h5 class="card-title"><%= art.getTituloArticulo()%></h5>
                    
                    <h6><span class="badge bg-secondary">Audifonos</span>
                      <span class="badge bg-secondary">conectores</span>
                      <span class="badge bg-secondary">Cartas</span></h6>
                    <% 
                        if(art.getIdUsuario()==UserSession1)
                        {
                            %>
                            <a href="Controller?accion=intercambiar&codigo=<%= art.getIdArticulo()%>" class="btn btmCompra">Mensajes</a>
                       <% 
                         }
                       
                        else {
                            %>
                     
                    <!---<a href="#" class="btn btmintercambiar">Intercambiar</a>-->
                    <a href="Controller?accion=intercambiar&codigo=<%= art.getIdArticulo()%>" class="btn btmCompra">Intercambiar</a>
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
                  
<!-- End of .container -->
    </body>
    
    <!-- Footer -->
  
  <jsp:include page="view/footer.jsp"></jsp:include>
  <!-- Footer -->
    
    <script>
        function ajax1(){
            fetch('/CompraPE/Controller?accion=intercambiar')
    .then(function(response) {
        // When the page is loaded convert it to text
        return response.text()
    })
    .then(function(html) {
        // Initialize the DOM parser
        var parser = new DOMParser();

        // Parse the text
        var doc = parser.parseFromString(html, "text/html");

        // You can now even select part of that html as you would in the regular DOM 
        // Example:
      //var docArticle = doc.querySelector('article').innerHTML;

        console.log(doc);
        console.log(html);
        document.getElementById("Contenido").innerHTML = html;
    })
    .catch(function(err) {  
        console.log('Failed to fetch page: ', err);  
    });
            
       /*     
         fetch('/CompraPE/Controller?accion=intercambiar')
    .then(function (response) {
      //console.log(response.body);
        console.log("entro aqui")
        console.log(response);
        console.log(response.text());
        document.getElementById("Contenido").innerHTML = response.text();
        
    })
    .then(function (body) {
      //console.log(body);
        console.log("No entro aqui")
    });*/
        }
    </script>
</html>
