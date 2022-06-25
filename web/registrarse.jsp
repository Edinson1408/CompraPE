<%-- 
    Document   : index.jsp
    Created on : 15-jun-2022, 22:58:59
    Author     : edins
--%>

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
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    </head>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">
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
                        <a class="nav-link" href="#">Mis Productos</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Dropdown
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#">Action</a></li>
                            <li><a class="dropdown-item" href="#">Another action</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="#">Something else here</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">

                        <a class="nav-link" href="#" tabindex="-1" aria-disabled="true">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                            <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                            <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                            </svg>
                            Iniciar Sesíon</a>

                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="registrarse.jsp" tabindex="-1" aria-disabled="true">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-bookmark-star" viewBox="0 0 16 16">
                            <path d="M7.84 4.1a.178.178 0 0 1 .32 0l.634 1.285a.178.178 0 0 0 .134.098l1.42.206c.145.021.204.2.098.303L9.42 6.993a.178.178 0 0 0-.051.158l.242 1.414a.178.178 0 0 1-.258.187l-1.27-.668a.178.178 0 0 0-.165 0l-1.27.668a.178.178 0 0 1-.257-.187l.242-1.414a.178.178 0 0 0-.05-.158l-1.03-1.001a.178.178 0 0 1 .098-.303l1.42-.206a.178.178 0 0 0 .134-.098L7.84 4.1z"/>
                            <path d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5V2zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1H4z"/>
                            </svg>
                            Registrarse</a>
                    </li>
                </ul>
                <form class="d-flex">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success"  type="submit">Buscar</button>
                </form>
            </div>
        </div>
    </nav>
    <body>
        <div class="container">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-7">
                        <div class="card shadow-lg border-0 rounded-lg mt-5">
                            <div class="card-header"><h3 class="text-center font-weight-light my-4">Registro de Clientes</h3></div>
                            <div class="card-body">
                                <form action="ControlRegistro" id="myForm" method="post">
                                    <input type="hidden" name="opc" value="1">
                                    <div>
                                        <h6 style="color: red">${errorMessage}</h6>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <input class="form-control" id="Nombres" name="Nombres" type="text" placeholder="Enter your first name">
                                                <label for="inputFirstName">*Nombres</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-floating">
                                                <input class="form-control" id="Apellidos" name="Apellidos" type="text" placeholder="Enter your last name">
                                                <label for="inputLastName">*Apellidos</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="Email" name="Email" type="email" placeholder="name@example.com">
                                        <label for="inputEmail">*Email</label>
                                    </div>

                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <input class="form-control" id="Distrito" name="Distrito" type="text" placeholder="Enter your first name">
                                                <label for="inputFirstName">Distrito</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div>
                                                <label>Sexo</label>
                                            </div>
                                            <div class="form-check form-check-inline"> 
                                                <input class="form-check-input" type="radio" name="Sexo" id="Sexo1" value="1" checked>
                                                <label class="form-check-label" for="Sexo1">Masculino</label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="Sexo" id="Sexo2" value="2">
                                                <label class="form-check-label" for="Sexo2">Femenino</label>
                                            </div>
                                         

                                        </div>
                                    </div>

                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <input class="form-control" id="Celular" name="Celular" type="number" placeholder="Enter your first name">
                                                <label for="inputFirstName">*Nro Celular</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-floating">
                                                <input class="form-control" id="FechaNacimiento" name="FechaNacimiento" type="date" placeholder="Enter your last name">
                                                <label for="inputLastName">Fecha Nacimiento</label>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <input class="form-control" id="PassWord" name="PassWord" type="password" placeholder="Create a password">
                                                <label for="inputPassword">*Contraseña</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <input class="form-control" id="PassWord2" name="PassWord2" type="password" placeholder="Confirm password">
                                                <label for="inputPasswordConfirm">*Confirma Contraseña</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="mt-4 mb-0">
                                        <div class="d-grid">
                                            <input class="btn btn-primary btn-block" onclick='submitDetailsForm()' type="button" name="load" value="Regitrar Cliente">

                                        </div>
                                    </div>
                                </form>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

        </div>


        <script type="text/javascript">
            function submitDetailsForm() {
                var dni = $("#Dni").val();
                var email = $("#Email").val();

                var PassWord = $("#PassWord").val();
                var PassWord2 = $("#PassWord2").val();

                if ($("#Nombres").val() == '') {
                    alert("Error, El campo nombre no puede quedar en blanco");
                    return false;
                } else if ($("#Apellidos").val() == '') {
                    alert("Error, El campo apellido no puede quedar en blanco");
                    return false;

                } else if ($("#Email").val() == '') {
                    alert("Error,El campo correo no puede quedar en blanco");
                    return false;
                }
                else if ($("#Celular").val() == '') {
                    alert("Error,El campo celular no puede quedar en blanco");
                    return false;
                }

                if (email != '') {
                    emailRegex = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;
                    if (emailRegex.test(email)) {
                    } else {
                        alert("Error, Correo invalido");
                        return false;
                    }
                }
                if ($("#PassWord").val() == '') {
                    alert("Error, El campo contraseña no puede quedar en blanco");
                    return false;
                } else if ($("#PassWord2").val() == '') {
                    alert("Error, El campo de confirmación de contraseña no puede quedar en blanco");
                    return false;
                }

                if (PassWord != PassWord2) {
                    alert("Error, Las contraseÃ±as no coninciden");
                    return false;
                }

                document.getElementById("myForm").submit();
            }
        </script>

    </body>
</html>
