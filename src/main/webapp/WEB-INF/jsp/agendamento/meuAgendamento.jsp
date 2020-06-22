<%-- 
    Document   : meuAgendamento
    Created on : 9 de jun de 2020, 19:49:45
    Author     : david
--%>


<%@include file="header.jsp" %>


<section class="services-section ftco-section " align="center">
    <div class="container">
        <div class="ui column grid">

            <table class="ui small stackable striped table">
                <thead>
                    <tr>                                                
                        <th><h3>Dia</h3></th>
                        <th><h3>Horário</h3></th>
                        <th><h3>Serviço</h3></th>
                        <th><h3>Profissional</h3></th>                                                
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${agendamentoList}" var="agendamento">
                        <tr>

                            <td><h6>${agendamento.dataDia.data}</h6></td>
                            <td><h6>${agendamento.horario.hora}</h6></td>
                            <td><h6>${agendamento.servico.descricao}</h6></td>
                            <td><h6>${agendamento.funcionario.name}</h6></td>            
                            <td class="right aligned">
                                <!--                                <div class="sixteen wide column right aligned">-->



                                <div class="sixteen wide column right aligned" >
                                    <div  class="ui buttons">

                                      
                                        <form action="${pageContext.request.contextPath}/agendar/remover" method="Post">
                                            <input type="hidden" name="agendamento.id" value="${agendamento.id}" />
                                            <button type="submit" class="ui olive basic button" >
                                            Cancelar
                                        </button>
                                        </form>

                                    </div>
                                </div>  



                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</section>

<%@include file="footer.jsp" %>



