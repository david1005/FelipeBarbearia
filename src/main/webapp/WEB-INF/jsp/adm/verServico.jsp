<%-- 
    Document   : verServico
    Created on : 16 de jun de 2020, 22:31:14
    Author     : Davi-Dario
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
                        <th><h1>Descricao</h1></th>
                                                                       
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${servico}" var="servico">
                        <tr>

                           <td><h3>${servico.descricao}</h3></td>
                                       
                            <td class="right aligned">
                                <div >  
                                    
                                    <form action="${pageContext.request.contextPath}/admin/remover2" method="post">
                                        <input type="hidden" name="servico.id" value="${servico.id}"/>
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




