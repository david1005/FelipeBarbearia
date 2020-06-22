<%-- 
    Document   : verFuncionario
    Created on : 18 de jun de 2020, 00:42:45
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
                        <th><h1>Nome do Funcionário</h1></th>
                                                                       
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${funcionario}" var="funcionario">
                        <tr>

                           <td><h3>${funcionario.name}</h3></td>
                                       
                            <td class="right aligned">
                                <div >  
                                    
                                    <form action="${pageContext.request.contextPath}/admin/remover4" method="post">
                                        <input type="hidden" name="funcionario.id" value="${funcionario.id}"/>
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






