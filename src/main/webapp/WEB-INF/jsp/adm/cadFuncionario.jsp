<%-- 
    Document   : cadFuncionario
    Created on : 18 de jun de 2020, 00:38:44
    Author     : Davi-Dario
--%>

 <div>
            <%@include file="header.jsp" %>
        </div>

        <section class="services-section ftco-section " >

            <div align="center" >
                <h1>Cadastrar Funcionario</h1>
                <form action="${pageContext.request.contextPath}/admin/salvar2" method="post">
                    <div >
                        <div class="input-group-prepend" >
                            <input type="text" class="form-control" name="funcionario.name" value="${funcionario.name}" required placeholder="Nome"/>
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













