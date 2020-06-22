<%-- 
    Document   : cadHorario
    Created on : 18 de jun de 2020, 17:12:39
    Author     : david
--%>

 <div>
            <%@include file="header.jsp" %>
        </div>

        <section class="services-section ftco-section " >

            <div align="center" >
                <h1>Cadastrar Horários</h1>
                <form action="${pageContext.request.contextPath}/admin/salvar3" method="post">
                    <div >
                        <div  >
                            <input  type="time" class="datepicker"  name="horario.hora" value="${horario.hora}" required placeholder="00:00" />
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

