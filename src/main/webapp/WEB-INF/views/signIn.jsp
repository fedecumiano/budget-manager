<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

        <title>Sign In</title>
    </head>
    <body>
        <%@ include file="common/unloggedNavbar.html"%>
        <div class="container mt-4">
            <form:form modelAttribute="user" action="/signIn" method="POST">
                <div class="form-group col-sm-6">
                    <h1>Sign In</h1>
                    <c:if test="${message != null && !message.equals('')}">
                        <div class="alert alert-danger" role="alert">
                            ${ message }
                        </div>
                    </c:if>
                    <div class="form-group">
                        <label for="idTxtUser">User: </label>
                        <form:input type="text" path="username" class="form-control" id="idTxtUser" placeholder="Input User name" />
                    </div>
                    <div class="form-group">
                        <label for="InputPassword">Password: </label>
                        <form:input type="password" path="pass" class="form-control" id="InputPassword" placeholder="Password" />
                        <small id="pwHelp" class="form-text text-muted">Do not share your password</small>
                    </div>
                    <button type="submit" class="btn btn-primary">Sign In</button>
                </div>
                <button type="button" class="btn btn-link"><a href="/home">back to Homepage</a></button>
            </form:form>
        </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>