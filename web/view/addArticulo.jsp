<%-- 
    Document   : AddArticulo
    Created on : 30-jun-2022, 3:35:33
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
                            <div class="card-header"><h3 class="text-center font-weight-light my-4">Registro de Articulo</h3></div>
                            <div class="card-body">
                                <form action="ControllerArticulo" id="myForm" method="post">
                                    <input type="hidden" name="opc" value="1">
                                    <div>
                                        <h6 style="color: red">${errorMessage}</h6>
                                    </div>
                                    
                                     <div class="row mb-3">
                                        <div class="col-md-6">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <input class="form-control" id="Nombres" name="NomArticulo" type="text" placeholder="Nombre Articulo">
                                                <label for="inputFirstName">*Nombre Articulo</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-floating">
                                                <!--<input class="form-control" id="Apellidos" name="IdCategoria" type="text" placeholder="Categoria">-->
                                                <select class="form-control" id="Apellidos" name="IdCategoria" type="text" placeholder="Categoria">
                                                    <option value="1">Deporte</option>
                                                    <option value="2">Instrumento Musical</option>
                                                    <option value="3">Electronica</option>
                                                    <option value="4">Juguetes y Juegos</option>
                                                </select>
                                                <label for="inputLastName">*Categoria</label>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <input class="form-control" id="Nombres" name="DistritoArticulo" type="text" placeholder="Distrito Articulo">
                                                <label for="inputFirstName">*Distrito</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-floating">
                                                <input class="form-control" id="PreferenciaArticulo" name="PreferenciaArticulo" type="text" placeholder="Preferencia">
                                                <label for="inputLastName">*Preferencia</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="Email" name="TituloArticulo" type="text" placeholder="Titlo de Articulo">
                                        <label for="inputEmail">*Titulo de Articulo</label>
                                    </div>

                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <input class="form-control" id="Distrito" name="EstadoArticulo" type="text" placeholder="Estado de articulo">
                                                <label for="inputFirstName">*Estado de Articulo</label>
                                            </div>
                                        </div>
                                        
                                        <div class="col-md-6">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <input class="form-control" id="Distrito" name="DescripcionArticulo" type="text" placeholder="Descripcion de Articulo">
                                                <label for="inputFirstName">*Descripcion de Articulo</label>
                                            </div>
                                        </div>

                                       <!--<div class="col-md-6">
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


                                        </div>-->
                                    </div>

                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <div class="mb-3">
                                                <label for="formFile" class="form-label">Imagen 1</label>
                                                <input class="form-control" type="file" id="Imagen" name="fichero">
                                                 
                                              </div>
                                            <!--<div class="form-floating mb-3 mb-md-0">
                                                <input class="form-control" id="Celular" name="Imagen" type="number" placeholder="file">    
                                                <label for="formFile" class="form-label">Default file input example</label>
                                                <input class="form-control" type="file" id="Imagen" name="Imagen">
                                            </div>-->
                                        </div>
                                    </div>

                                    <div class="mt-4 mb-0">
                                        <div class="d-grid">
                                            <input type='hidden' name="accion" value="publicarArticulo">
                                            <input type='hidden' name="IdUsuario" value="${idUser}">
                                            <input class="btn btn-primary btn-block" onclick='submitDetailsForm()' type="submit" name="load" value="Publicar">

                                        </div>
                                    </div>
                                </form>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

        </div>

<!--
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
-->
    </body>
</html>
