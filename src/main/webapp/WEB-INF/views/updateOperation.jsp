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

    <title>Update Operation</title>
</head>
    <body>
        <%@ include file="common/navbar.html"%>
        <form:form modelAttribute="operation" action="/updateOperation" method="POST">
            <div class="form-group col-sm-3">
                <h1>Update this operation</h1>
                <c:if test="${message != null && !message.equals('')}">
                    <div class="alert alert-danger" role="alert">
                        ${ message }
                    </div>
                </c:if>
                <div class="form-group">
                    <label for="idDescription">Description: </label>
                    <form:input type="text" path="description" class="form-control" id="idDescription" value="${updOperation.description}" />
                </div>
                <div class="form-group">
                    <label for="idAmount">Amount: </label>
                    <form:input type="text" path="amount" class="form-control" id="idAmount" value="${updOperation.amount}" />
                </div>
                <div class="form-group">
                    <label for="idDated">Transfer Date: </label>
                        <form:input type="date" path="dated" class="form-control" id="idDated" placeholder="date" />
                    </div>
                <div class="form-group">
                    <label for="idType">Select Type: </label>
                    <form:select id="idType" class="form-control" path="type">
                        <form:option value="${updOperation.type}">"${updOperation.type}"</form:option>
                    </form:select>
                    <small id="typeHelp" class="form-text text-muted">Type of operation can`t be changed</small>
                </div>
                <form:input id="username" name="username" type="hidden" value="${updOperation.username}" path="username"/>
                <form:input id="opId" name="opId" type="hidden" value="${updOperation.id}" path="id"/>
                <button type="submit" class="btn btn-primary">Update Operation</button>
            </div>
            <button type="button" class="btn btn-link"><a href="/home">back to Homepage</a></button>
        </form:form>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>