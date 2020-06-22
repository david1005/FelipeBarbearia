<%-- 
    Document   : atualizaAgendamento
    Created on : 19 de jun de 2020, 10:38:08
    Author     : david
--%>

<%@include file="header.jsp" %>

      



        <section class="services-section ftco-section " align="center">
            <div class="container">
                <div   text-right> 
                    <button class=" text-right " >
                        <a href="${pageContext.request.contextPath}/agendamento/sair">
                            SAIR
                        </a>
                    </button>     
                </div>
                <h3>Agendar um horário</h3>
                

                <form action="${pageContext.request.contextPath}/agendar/update" method="post">

                    <select class="form-control" name="agendamento.servico.id"  >                                                
                        <option value="${agendamento.servico.id}">${agendamento.servico.descricao}</option>                        
                    </select>
                    
                    <br>
                    <select class="form-control" name="agendamento.funcionario.id" >                         
                            <option value="${agendamento.funcionario.id}">${agendamento.funcionario.name}</option>
                        
                    </select>
                    <br>
                    <select class="form-control" name="agendamento.dataDia.id" >                          
                            <option value="${agendamento.datadia.id}">${agendamento.datadia.data}</option>
                        
                    </select>
                    <br>
                    <select class="form-control" name="agendamento.horario.id" >
                        
                            <option value="${agendamento.horario.id}">${agendamento.horario.hora}</option>
                        
                    </select>
                        
                    <br>
                        <button type="submit" class="btn btn-outline-secondary">Confirmar</button>
                </form>
            </div>
        </section>



        
       <%@include file="footer.jsp" %>