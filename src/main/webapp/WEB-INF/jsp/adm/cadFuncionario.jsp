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
                  
                        <div   >
                            <input type="text"  class="col-sm-2 col-form-label" name="funcionario.name" value="${funcionario.name}" required placeholder="Nome"/>
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













