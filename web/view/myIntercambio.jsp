    <%-- 
    Document   : myIntercambio
    Created on : 14-jul-2022, 11:06:47
    Author     : edins
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </head>
    <jsp:include page="menu.jsp"></jsp:include>
    <body>
         <div class="container" id="Contenido">
             
             <br>
             <br>
            <!--<h1>Lista de articulos</h1>-->
            
            <img src="../src/files/img_-891183057_logo_reporte.png" alt=""/>
            
            <div class="row row-cols-1 row-cols-md-4 g-4">
 
                   <c:choose> 
                                <c:when test="${empty listaMensaje}">
                                    <p>No tiene notificaciones</p>
                                </c:when> 
                                    <c:otherwise> 
                                         <c:forEach  var="x" items="${listaMensaje}">
                                                <div class="col">
                                                  <div class="card h-100">
                                                    <img src="src/files/${x.getImagen()}" class="card-img-top" alt="...">
                                                    
                                                    <div class="card-body">
                                                        <h5 class="card-title">${x.getTituloArticulo()}</h5>

                                                      
                                                           <c:choose>
                                                            <c:when test="${x.getEstado()==1}">
                                                                <p>Pendiente de confirmacion</p>
                                                            <button href="#" class="btn btmCompra" onclick="confirmarEstado(${x.getId_interArticulo()},${x.getIdArticulo()});">Confirmar</button>
                                                            <button href="#" class="btn btmintercambiar">ver detalle</button>
                                                            </c:when>    
                                                            <c:when test="${x.getEstado()==2}">
                                                                <p>Se realizo el intercambio</p>
                                                            <button href="#" class="btn btmintercambiar" >Detalles</button>
                                                            </c:when>    
                                                            <c:otherwise>
                                                            </c:otherwise>
                                                        </c:choose>
                                                      
                                                      
                                                    </div>
                                                  </div>
                                                </div>
                                        </c:forEach>
                                    </c:otherwise> 
                            </c:choose>
              
              
           
            </div>
            
           
        </div>
        <br>
    </body>
    
    <!-- Footer -->
  
  <jsp:include page="footer.jsp"></jsp:include>
  <!-- Footer -->
  
  <script>
    function confirmarEstado(idIntercambio,idArticulo){
        
              swal({
                title: "Confirmar Intercambio",
                text: "Solo se debe confirmar cuando tenga el producto a intercambiar",
                icon: "warning",
                buttons: true,
                dangerMode: true,
                })
                .then((willDelete) => {
                  if (willDelete) {
                   /* swal("Poof! Your imaginary file has been deleted!", {
                      icon: "success",
                    });*/
                    terminarIntercambio(idIntercambio,idArticulo)
                  } else {
                    //swal("Your imaginary file is safe!");
                  }
                });
        
    }
    
    function terminarIntercambio(idIntercambio,idArticulo){
                $.post("/CompraPE/CMyIntercambio",
                        {
                          idArticulo:idArticulo,
                          accion :"PruebaJson",
                          idIntercambio:idIntercambio
                        },
                        function(data, status){
                          //alert("Data: " + data + "\nStatus: " + status);
                          if(data){
                              location.reload();
                          }
                          
                 });
    }
    
    
    
    
  </script>
</html>
