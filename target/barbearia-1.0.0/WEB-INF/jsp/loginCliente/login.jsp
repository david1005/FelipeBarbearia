<%-- 
    Document   : login
    Created on : 24 de mai de 2020, 15:12:17
    Author     : david
--%>

<%@include file="header.jsp" %>

        <section class="services-section ftco-section ">
            <div class="container">
                <form action="${pageContext.request.contextPath}/agendamento/login" method="post">    
                    <h3 class="text-center text-body">Acesse sua conta</h3>


                    <div class="form-group" align="center">
                        <!--                        <div class="col-md-4">
                                                    <input class="form-control input-md" type="text" id="userName" name="user.userName" placeholder="Usuário">    
                                                </div>-->


                        <div class="row">
                            <div class="input-field col s6">
                                <input  class="form-control" type="text" id="userName" name="user.userName" placeholder="exemplo@exemplo.com">
                                
                            </div>
                        </div>

                        <div class="row">
                            <div class="input-field col s6">
                                <input  class="form-control" type="password" name="user.password"  id="senha"   placeholder="*********">
                                
                            </div>
                        </div>


                        <!--                        <div class="col-md-4" align="center">
                                                    <input  class="form-control input-md" type="password" name="user.password"  id="senha"  placeholder="*********">
                                                </div>-->
                    </div>
                    <br>
                    <div align="center">
                        <div class="col-md-8" >               
                            <button id="Cadastrar" name="Cadastrar" class="waves-effect waves-light btn-large" align="center" type="Submit">Entrar</button>                
                            <div class="container-login102-form-btn m-t-32">
                                <p class="text-center small">Não tem uma conta?<a href="${pageContext.request.contextPath}/agendamento/registrar"> Cadastrar-se</a></p>
                            </div>
                        </div>
                    </div>        
                </form>
                <div align="center">
                    <h5 style="color: red; border-bottom: 2px;">${mensagem}</h5>
                </div>
            </div>
        </section>

        <!--        <div class="row">
                    <form class="col s12">
        
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="email" type="email" class="validate">
                                <label for="email">Email</label>
                            </div>
                        </div>
        
                        
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="password" type="password" class="validate">
                                <label for="password">Password</label>
                            </div>
                        </div>
                                        
                    </form>
                </div>-->








<%@include file="footer.jsp" %>
