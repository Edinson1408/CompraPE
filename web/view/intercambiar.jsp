

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
 HttpSession sesion=request.getSession(); 
%>  


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <link href="src/css/MyStyle.css" rel="stylesheet" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <!-- <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>            -->
    </head>
    <jsp:include page="menu.jsp"></jsp:include>
 
     <body>
        <div class="container">
            <h1>Detalle de Intercambio</h1>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-inner">
                          <div class="carousel-item active">
                              <img src="src/img/${art.getImagen()}" class="d-block w-100" alt="...">
                          </div>
                          <div class="carousel-item">
                            <img src="src/img/${art.getImagen()}" class="d-block w-100" alt="...">
                          </div>
                          <div class="carousel-item">
                            <img src="src/img/${art.getImagen()}" class="d-block w-100" alt="...">
                          </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                          <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                          <span class="carousel-control-next-icon" aria-hidden="true"></span>
                          <span class="visually-hidden">Next</span>
                        </button>
                      </div>
                    <hr>
                    <br>
                    
                   <!-- <div class="list-group">
                        <div class="list-group-item list-group-item-action" aria-current="true">
                            <div class="d-flex w-100 justify-content-between">
                                <h5 class="mb-1">Name user </h5>
                                <small>3 days ago</small>
                            </div>
                        <div class="row">
                            <div class="col-md-3">
                            <img src="src/img/teclado01.jpg" class="img-fluid rounded-start" alt="...">
                            </div>
                            <div class="col-md-9">
                                <p class="mb-1">Mensaje del usaurio XD.</p>
                                <small>Boton de aceptar</small>
                            </div>
                        </div>
                        </div>      
                    </div>-->
                    
                    
                    
                    
                    <!--<div class="card">
                        <h5 class="card-header">name user</h5>
                        <div class="card-body">
                         <div class="row">   
                           <div class="col-md-3">
                            <img src="src/img/teclado01.jpg" class="img-fluid rounded-start" alt="...">
                            </div>
                          <div class="col-md-9">
                          <h5 class="card-title">Special title treatment</h5>
                          <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                          <a href="#" class="btn btn-primary">Go somewhere</a>
                          </div>
                         </div> 
                        </div>
                    </div>-->
                    <h3 clas="tituloInter">Mensajes</h3>
                    <br>
                     <c:choose> 
                                <c:when test="${empty listaMensaje}">
                                    <p>No tiene notificaciones</p>
                                </c:when> 
                                    <c:otherwise> 
                                         <c:forEach  var="x" items="${listaMensaje}">
                                           
                                           <div class="col-md-12 col-sm-12 col-xs-12">
                                                <div class="row">
                                                    <div class="col-md-3 col-sm-3 col-xs-3">
                                                        <!--<img class='img-fluid' src="src/img/teclado01.jpg"  alt="...">-->
                                                        
                                                        <i class="fa-solid fa-user  fa-8x img-fluid"></i>
                                                    </div>
                                                    <div class="col-md-9 col-sm-9 col-xs-9">
                                                    <h5 class="card-title">${x.getUsername()}</h5>
                                                     <small>${x.getFecha()}</small>
                                                    <p class="card-text">${x.getMensaje()}</p>
                                                    
                                                        <!--<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal">Open modal</button>-->
                                                        
                                                        <i onclick="verimagen('${x.getImg()}')" class="fa-solid fa-image fa-2xl" data-bs-toggle="modal" data-bs-target="#myModal"></i>
                                                        
                                                        <c:choose>
                                                            <c:when test="${art.getIdUsuario()==UserSession}">
                                                                <button  class="btn btn-primary" onclick="AceptarInterCambio(${x.getId_interArticulo()},${x.getId_articulo()})">Aceptar</button>
                                                                
                                                            </c:when>    
                                                            <c:otherwise>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        
                                                        
                                                    
                                                    </div>
                                                </div>
                                          </div>
                                          <br>
                                        </c:forEach>
                                    </c:otherwise> 
                            </c:choose>
                     <hr>
                </div>
                <div class="col-md-6">
                    <h2 class="tituloInter">${art.getTituloArticulo()}</h2>

                    <div class="col-md-12">
                        <!--<span>Marca</span>
                        <h3>S/.100</h3>-->
                    </div>
                    <hr>
                    <div class="Card">
                        <p><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-calendar-check-fill" viewBox="0 0 16 16">
                            <path d="M4 .5a.5.5 0 0 0-1 0V1H2a2 2 0 0 0-2 2v1h16V3a2 2 0 0 0-2-2h-1V.5a.5.5 0 0 0-1 0V1H4V.5zM16 14V5H0v9a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2zm-5.146-5.146-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 0 1 .708-.708L7.5 10.793l2.646-2.647a.5.5 0 0 1 .708.708z"/>
                          </svg>  Sin Envio</p>
                        <p><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-credit-card-2-back-fill" viewBox="0 0 16 16">
                            <path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v5H0V4zm11.5 1a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h2a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-2zM0 11v1a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2v-1H0z"/>
                          </svg>Intercambio</p>
                    </div>
                    <hr>
                    <div class="col-md-12 bd-callout-danger">
                       <h3>Vendedor</h3>
                       <p>Oscar Gracias ....</p>
                       <p>Lima  / Lima / ${art.getDistritoArticulo()} </p>
                    </div>
                    <hr>
                    <div class="col-md-12">
                       <%  
                           String esPropietario;
                             if (sesion.getAttribute("userLogeado")==null){
                                esPropietario="NO";
                             }else{
                                 esPropietario="SI";
                             }
                        %>
                        
                       <% 
                      
                       
                        if(esPropietario.equalsIgnoreCase("NO")) {
                       
                        %>
               
                            <button class="btn btmCompra container-fluid"
                                data-bs-toggle="modal" data-bs-target="#staticBackdrop"
                                > <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-credit-card-2-front" viewBox="0 0 16 16">
                                <path d="M14 3a1 1 0 0 1 1 1v8a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V4a1 1 0 0 1 1-1h12zM2 2a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V4a2 2 0 0 0-2-2H2z"/>
                                <path d="M2 5.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1-.5-.5v-1zm0 3a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 0 1h-1a.5.5 0 0 1-.5-.5zm3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 0 1h-1a.5.5 0 0 1-.5-.5zm3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 0 1h-1a.5.5 0 0 1-.5-.5zm3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 0 1h-1a.5.5 0 0 1-.5-.5z"/>
                            </svg> Intercambiar </button>
                          
                       <% } else{   %>
                            <button class="btn btmCompra container-fluid"> <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-credit-card-2-front" viewBox="0 0 16 16">
                                <path d="M14 3a1 1 0 0 1 1 1v8a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V4a1 1 0 0 1 1-1h12zM2 2a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V4a2 2 0 0 0-2-2H2z"/>
                                <path d="M2 5.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1-.5-.5v-1zm0 3a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 0 1h-1a.5.5 0 0 1-.5-.5zm3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 0 1h-1a.5.5 0 0 1-.5-.5zm3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 0 1h-1a.5.5 0 0 1-.5-.5zm3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 0 1h-1a.5.5 0 0 1-.5-.5z"/>
                            </svg> Propietario </button>
                       <% } %>
                    </div>
                    
                </div>
                
            </div>
           
        </div>
    
        <!-- Button trigger modal -->
        <!-- Modal -->
      <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="staticBackdropLabel">Intercambio de productos</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form  action="ControllerIntercambio" id="myForm" method="post" enctype="multipart/form-data">
                    <div class="mb-3">
                      <label for="exampleInputEmail1" class="form-label">Mensaje</label>
                      <textarea  type="text"  rows="4"   maxlength="100" class="form-control" id="Mensaje" name="Mensaje" aria-describedby="emailHelp"></textarea>
                      <div id="emailHelp" class="form-text">Mensaje al usuario.</div>
                    </div>
                    <div class="mb-3">
                      <label for="exampleInputPassword1" class="form-label">Estado del producto</label>
                      <select id="EstadoArticulo" class="form-select" name="EstadoArticulo">
                        <option value="Nuevo">Nuevo</option>
                        <option value="Seminuevo" >Seminuevo</option>
                        <option value="Repuesto" >Repuesto</option>
                      </select>
                    </div>
                    <input type="hidden"  name="Id_articulo" value=${art.getIdArticulo()}>
                    <input type="hidden"  name="IdUsuario" value=<%=sesion.getAttribute("SIdUsuario")%>>
                    <input type='hidden' name="accion" value="agregarMensaje">
                    
                    
                      <div class="mb-3">
                        <label for="formFile" class="form-label">Cargar Imagen</label>
                         <input class="form-control" type="file" id="Imagen" name="fileImagen"  >
                        <!--<input class="form-control" type="file" id="formFile">-->
                      </div>
                    <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <input type="submit" class="btn btn-primary" value="Enviar">
                    </div>
                  </form>
            </div>
            
          </div>
        </div>
      </div>
        
                    
                    
   <!--modal para ver la imagen-->
   
   <div class="modal" id="myModal">
    <div class="modal-dialog modal-dialog-centered modal-dialog modal-lg">
      <div class="modal-content">
        <!-- Modal body -->
        <div class="modal-body" id="CuerpoFoto">
          Modal body..
        </div>

        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
        </div>

      </div>
    </div>
</div>
   
                    
  </body>

  <script>
      /*MODAL MENSAJE */
      
      var myModalMensaje = document.getElementById('staticBackdropMensaje')
      myModalMensaje.addEventListener('shown.bs.modal', function () {
            //myInput.focus()
        })
      
    var myModal = document.getElementById('exampleModalToggle2')
    var myInput = document.getElementById('myInput')

    myModal.addEventListener('shown.bs.modal', function () {
    myInput.focus()
        })
        
     
 
        function AceptarInterCambio(idIntercambio,idArticulo){
            console.log(idIntercambio,idArticulo);
            $.post("/CompraPE/ControllerIntercambio",
                {
                  idArticulo:idArticulo,
                  accion :"PruebaJson",
                  idIntercambio:idIntercambio
                },
                function(data, status){
                  //alert("Data: " + data + "\nStatus: " + status);
                  location.reload();
                });
                
        }
 
    function  verimagen(img){
          document.getElementById('CuerpoFoto').innerHTML="<img class='img-fluid' src='src/files/"+img+"' alt=''/>"
          
         
     }
  </script>
</html>

