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
                        <th>Dia</th>
                        <th>Horário</th>
                        <th>Serviço</th>
                        <th>Profissional</th>                                                
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${agendamentoList}" var="agendamento">
                        <tr>

                            <td>${agendamento.dataDia.data}</td>
                            <td>${agendamento.horario.hora}</td>
                            <td>${agendamento.servico.descricao}</td>
                            <td>${agendamento.funcionario.name}</td>            
                            <td class="right aligned">
                                <div >  
                                    <button type="submit" class="ui left attached button">

                                        <a href="${pageContext.request.contextPath}/agendar/id/${chamado.id}">Editar</a>
                                    </button>
                                    <form action="${pageContext.request.contextPath}/agendar/remover" method="post">
                                        <input type="hidden" name="chamado.id" value="${agendamento.id}"/>
                                        <button type="submit" class="ui left attached button">Remover</button>
                                    </form>

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



