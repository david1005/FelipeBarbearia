<%-- 
    Document   : cadservico
    Created on : 16 de jun de 2020, 22:08:48
    Author     : Davi-Dario
--%>
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

        <section class="services-section ftco-section " >

            <div align="center" >
                <h1>Adicionar Serviço</h1>
                <form action="${pageContext.request.contextPath}/admin/salvar" method="post">
                    <div >
                        <div  >
                            <input type="text" class="col-sm-2 col-form-label" name="servico.descricao" value="${servico.descricao}" required placeholder="Corte Simples - R$ 10,00"/>
                        </div>
                    </div>
                        </br>
                    <button class="btn btn-outline-secondary" type="subimit" >Cadastrar</button>
                    
                </form> 
            </div>


        </section>                                      

    </div>
    <div class="footer-copyright">
        <%@include file="footer.jsp" %>
    </div>
</body>







