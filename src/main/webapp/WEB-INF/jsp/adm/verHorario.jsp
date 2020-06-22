<%-- 
    Document   : verHorario
    Created on : 18 de jun de 2020, 17:30:54
    Author     : david
--%>

<div>
    <%@include file="header.jsp" %>
</div>

<section class="services-section ftco-section " align="center">
    <div class="container">
        <div class="ui column grid">

            <table class="ui small stackable striped table">
                <thead>
                    <tr>                                                
                        <th><h1>Horários</h1></th>
                                                                       
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${horario}" var="horario">
                        <tr>

                           <td><h3>${horario.hora}</h3></td>
                                       
                            <td class="right aligned">
                                <div >  
                                    
                                    <form action="${pageContext.request.contextPath}/admin/remover" method="post">
                                        <input type="hidden" name="horario.id" value="${horario.id}"/>
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




<div>
    <%@include file="footer.jsp" %>
</div>
