<%
 HttpSession sesion=request.getSession(); 
%>  
<nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="container-fluid">
        <a class="navbar-brand" href="/CompraPE">
            <img src="src/img/Logo.png" alt="" width="30" height="24" class="d-inline-block align-text-top">
              CompraPe
          </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="#">Mis intercambios</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="ControllerArticulo?accion=myArticulo&idUser=<%=sesion.getAttribute("SIdUsuario")%>">Mis Productos</a>
            </li>
           <!-- <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                Dropdown
              </a>
              <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                <li><a class="dropdown-item" href="#">Action</a></li>
                <li><a class="dropdown-item" href="#">Another action</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="#">Something else here</a></li>
              </ul>
            </li>-->
            <li class="nav-item">
               <% 
                      
                       
                      if(sesion.getAttribute("SIdUsuario")==null) {
                       
               %>
              <a class="nav-link" href="Controller?accion=login" tabindex="-1" aria-disabled="true">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                  <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                </svg>
                Iniciar Sesíon</a>
               <% }else{ %>
               
               <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
               
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                  <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                </svg>
                <%=sesion.getAttribute("SIUserName") %></a>
              </a>
              <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                <li>
                    <a class="dropdown-item" href="ControllerUsuario?accion=editUser&idUser=<%=sesion.getAttribute("SIdUsuario")%>" tabindex="-1" aria-disabled="true">Cuenta</a>
                </li>
                <li><a class="dropdown-item" href="ControllerArticulo?accion=addArticulo&idUser=<%=sesion.getAttribute("SIdUsuario")%>">Publicar</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="ControllerUsuario?accion=cerrarSession">Cerrar Session</a></li>
              </ul>
            </li>
               
               
                <% } %>
            </li>
          </ul>
          <form class="d-flex">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success"  type="submit">Buscar</button>
          </form>
        </div>
      </div>
    </nav>