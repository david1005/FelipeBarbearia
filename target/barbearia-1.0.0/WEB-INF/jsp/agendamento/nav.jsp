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
    <div class="container-xl">
        <div  align="center">  

            <h3 align="center"  >-BEM VINDO }-</h3>

            <a  href="${pageContext.request.contextPath}/agendar/agendar" ><h2 class="font-weight-bold">AGENDE UM HOR�RIO</h2></a>


            <a  href="${pageContext.request.contextPath}/agendar/meushorarios" ><h2  class="font-weight-bold">MEUS HOR�RIOS    </h2></a>
        </div>
    </div>

</div>
</section>