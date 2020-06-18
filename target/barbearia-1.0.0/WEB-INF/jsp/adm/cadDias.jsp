<%-- 
    Document   : cadDias
    Created on : 18 de jun de 2020, 17:14:04
    Author     : david
--%>

<div>
            <%@include file="header.jsp" %>
        </div>

        <section class="services-section ftco-section " >

            <div align="center" >
                <h1>Cadastrar Dias</h1>
                <form action="${pageContext.request.contextPath}/admin/salvar4" method="post">
                    <div >
                        <div class="input-group-prepend" >
                            <input type="text" class="form-control" name="data.data" value="${data.data}" required placeholder="00/00/0000"/>
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

