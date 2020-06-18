<%-- 
    Document   : nav
    Created on : 18 de jun de 2020, 14:41:09
    Author     : david
--%>






<section class="services-section ftco-section " >


    <table class="ui small stackable striped table">
        <thead>
            <tr>                                                
                <th><h1>CADASTROS</h1></th>                                                                                          
            </tr>
        </thead>
    </table>

    <div class="ui inverted menu">
        <div class="ui inverted segment" style="font-weight:bolder;color:black;">

            <div class="ui inverted secondary" >
                <h3> <a href="${pageContext.request.contextPath}/admin/cadastrarservico">Cadastrar Servico</a></h3><br>
                <h3> <a href="${pageContext.request.contextPath}/admin/cadastrarfuncionario">Cadastrar Funcionario</a></h3><br>
                <h3>  <a href="${pageContext.request.contextPath}/admin/cadastrarhorario">Cadastrar Horários</a></h3><br>
                <h3>   <a href="${pageContext.request.contextPath}/admin/cadastrardias">Cadastrar Dias</a></h3><br>

            </div>
        </div>

        <table class="ui small stackable striped table" >
            <thead >

                <tr>   

                    <th ><h1><a href="${pageContext.request.contextPath}/admin/listadeagendamentos" style="font-weight:bolder;color:black;">LISTA DE AGENDAMENTOS</a> </h1></th>                                                                                    
                </tr>

            </thead>
        </table>

        <table class="ui small stackable striped table">
            <thead>
                <tr>                                                
                    <th><h1>LISTA DE CADASTROS</h1></th>                                                                                          
                </tr>
            </thead>
        </table>

        <div class="ui inverted menu">
            <div class="ui inverted segment" style="font-weight:bolder;color:black;">

                <div class="ui inverted secondary" >
                    <h3> <a href="${pageContext.request.contextPath}/admin/servico">Listar Servico</a></h3><br>
                    <h3> <a href="${pageContext.request.contextPath}/admin/funcionario">Listar Funcionario</a></h3><br>
                    <h3> <a href="${pageContext.request.contextPath}/admin/horario">Listar Horários</a></h3><br>
                    <h3> <a href="${pageContext.request.contextPath}/admin/dias">Listar Dias</a></h3><br>

                </div>
            </div>
            </section>





