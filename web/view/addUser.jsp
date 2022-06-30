
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
   <jsp:include page="menu.jsp"></jsp:include>
    <body>
        <div class="container">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-7">
                        <div class="card shadow-lg border-0 rounded-lg mt-5">
                            <div class="card-header"><h3 class="text-center font-weight-light my-4">Registro de Clientes</h3></div>
                            <div class="card-body">
                                <form action="ControllerUsuario" id="myForm" method="post">
                                    <input type="hidden" name="opc" value="1">
                                    <div>
                                        <h6 style="color: red">${errorMessage}</h6>
                                    </div>
                                     <div class="form-floating mb-3">
                                        <input class="form-control" id="UserName" name="UserName" type="text" >
                                        <label for="inputUserName">*Nombre de Usuario</label>
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
                                                <input class="form-check-input" type="radio" name="Sexo" id="Sexo1" value="M" checked>
                                                <label class="form-check-label" for="Sexo1">Masculino</label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="Sexo" id="Sexo2" value="F">
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
                                            <input type='hidden' name="accion" value="agregarUsuario">
                                            <input class="btn btn-primary btn-block" onclick='submitDetailsForm()' type="submit" name="load" value="Crear Usuario">

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