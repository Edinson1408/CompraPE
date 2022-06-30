<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Login</title>
    </head>
    
   
    <body>
        <div class="container mt-4 col-lg-4">
            <div class="card" col-sm-10>
                <div class="card-body">
                    <form class="form-sing" action="ControllerUsuario" method="POST">
                        <div class="form-group text-center">
                            <img src="src/img/LogoLogin.PNG" alt="70" width="230"/>
                            
                        </div>
                        <label style="color: #6482fd;">${Usuario}</label>
                        <div class="form-group">
                            <label>Usuario:</label>
                            <input type="text" name="txtuser" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Password:</label>
                            <input type="password" name="txtpass" class="form-control">
                        </div>
                        <input type="submit" name="Ingresar" value="Ingresar" class="btn btn-primary btn-block">
                        <div class="form-group">
                            <label>¿Olvidaste tu contraseña?</label>
                            <label><a href="ControllerUsuario?accion=addUser">¿No tienes cuenta? Regístrate</a></label>
                        </div>
                        <input type="hidden" name="accion" value="inicioSession">
                    </form>
                </div>
            </div>
        </div>       
        
        



        
            
            
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        
    </body>
    
 
</html>
