<%-- 
    Document   : agendar
    Created on : 3 de jun de 2020, 15:56:29
    Author     : david
--%>

<%@include file="header.jsp" %>

<!--
        <section class="services-section ftco-section ">

            <div class="container c-iframe-agende">                
                <h3 align="center">Olá, {Nome do Usuário} </h3>

                <div class="form-group" align="center">
                    <a class="item" href="$//{pageContext.request.contextPath}/agendar/agendar" ><h2 class="font-weight-bold">AGENDE UM HORÁRIO</h2></a>
                </div>

            </div>
        </section>-->



<section class="services-section ftco-section " align="center">
    <div class="container">

        <h3>Agendar um horário</h3>


        <form action="${pageContext.request.contextPath}/agendar/salvar" method="post">


            <input  class="form-control" type="text" id="nameCliente" name="agendamento.nameCliente" placeholder="Seu Nome">
            <br/>

           
           
           



            <br/>

            <select class="form-control" name="agendamento.servico.id"  >
                <option  selected>Selecione um Serviço</option>
                <c:forEach items="${servicos}" var="servico">  
                    <option value="${servico.id}">${servico.descricao}</option>
                </c:forEach>
            </select>
            <br>
            <select class="form-control" name="agendamento.funcionario.id" >
                <option selected>Selecione um Profissional</option>
                <c:forEach items="${funcionarios}" var="funcionario">  
                    <option value="${funcionario.id}">${funcionario.name}</option>
                </c:forEach>
            </select>
            <br>
            <select class="form-control" name="agendamento.dataDia.id" >
                <option  selected>Selecione o Dia </option>
                <c:forEach items="${datadias}" var="datadia">  
                    <option value="${datadia.id}">${datadia.data}</option>
                </c:forEach>
            </select>
            <br>
            <select class="form-control" name="agendamento.horario.id" >
                <option selected>Selecione um Horário</option>
                <c:forEach items="${horarios}" var="horario">  
                    <option value="${horario.id}">${horario.hora}</option>
                </c:forEach>
            </select>

            <br/>



            <br>
            <button type="submit" class="btn btn-outline-secondary">Confirmar</button>
        </form>
    </div>
</section>




<%@include file="footer.jsp" %>