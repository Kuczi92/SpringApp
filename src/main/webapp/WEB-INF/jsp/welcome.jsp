<%-- 
    Document   : welcome
    Created on : 2017-10-17, 17:35:04
    Author     : Quchi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Strona startowa</title>
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" >
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>${greeting}</h1>
                    <p>${tagline}</p>
                </div>
            </div>
        </section>

    </body>
</html>
