<%-- 
    Document   : inicio
    Created on : 18 de jun de 2020, 01:04:29
    Author     : Davi-Dario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
         <link rel="stylesheet" href="${pageContext.request.contextPath}/css/semantic.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adjust.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/icon.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sem/components/icon.min.css"/>
        
    </head>
    <body>
        <div>
            <%@include file="header.jsp" %>
        </div>
        
        <div class="ui container">
            <div class="ui grid stackable">
                <%@include file="nav.jsp" %>
               
            </div>
        </div>
                <div class="footer-copyright">
         <%@include file="footer.jsp" %>
                </div>
    </body>
    
    
    
   