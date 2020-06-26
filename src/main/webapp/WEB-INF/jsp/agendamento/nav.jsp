<%-- 
    Document   : nav
    Created on : 3 de jun de 2020, 15:48:27
    Author     : david
--%>
<%@page import="br.edu.fjn.barbearia.model.Usuario"%>
<%
    String usuario = (String) Usuario.class.getName();
%>


<section class="services-section ftco-section ">

    <div class="container c-iframe-agende">                
        <h3 align="center"  >-BEM VINDO-</h3>
        
        
    </div>
    
    

    <div class="form-group" align="center">
        <a class="item" href="${pageContext.request.contextPath}/agendar/agendar" ><h2 class="font-weight-bold">AGENDE UM HORÁRIO</h2></a>
    </div>

    <div class="form-group" align="center">
        <a class="item" href="${pageContext.request.contextPath}/agendar/meushorarios" ><h2  class="font-weight-bold">MEUS HORÁRIOS    </h2></a>
    </div>

</div>
</section>