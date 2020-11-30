<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

        <title>Login</title>
      </head>
    <body>
        <form method="post" action="Login">
            <div class="form-group col-sm-3">
                <h1>Iniciar Sesion</h1>
                <c:if test="${mensajeError != null && !mensajeError.equals('')}">
                    <div class="alert alert-danger" role="alert">
                    ${ mensajeError }
                </div>
                </c:if>
                <div class="form-group">
                    <label for="idTxtUsuario">Usuario: </label>
                    <input name="txtUsuario" type="user" class="form-control" id="idTxtUsuario" placeholder="Ingresar Usuario">
                </div>
                <div class="form-group">
                    <label for="InputPassword">Contraseña: </label>
                    <input name="txtPass" type="password" class="form-control" id="InputPassword" placeholder="Password" aria-describedby="passHelp">
                    <small id="passHelp" class="form-text text-muted">No compartas tu usuario o contraseña</small>
                </div>

                <button type="submit" class="btn btn-primary">Ingresar</button>
            </div>
            <button type="button" class="btn btn-link"><a href="/TrabajoPractico/signIn.jsp">Registrarse</a></button>
            <button type="button" class="btn btn-link"><a href="/TrabajoPractico/menu.jsp">Volver al Menu</a></button>

        </form>
            </body>

</html>