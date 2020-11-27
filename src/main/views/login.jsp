<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
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
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="js/bootstrap.min.js"></script>

</html>