<%-- 
    Document   : verDias
    Created on : 18 de jun de 2020, 19:09:10
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
                        <th><h1>Dias</h1></th>
                                                                       
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${data}" var="data">
                        <tr>

                           <td><h3 type="date">${data.data}</h3></td>
                                       
                            <td class="right aligned">
                                <div >  
                                    
                                    <form action="${pageContext.request.contextPath}/admin/remover3" method="post">
                                        <input type="hidden" name="data.id" value="${data.id}"/>
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
