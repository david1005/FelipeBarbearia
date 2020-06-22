package br.edu.fjn.barbearia.controllers;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.fjn.barbearia.components.UsuarioSession;
import br.edu.fjn.barbearia.model.DataDia;
import br.edu.fjn.barbearia.model.Servico;
import br.edu.fjn.barbearia.model.Funcionario;
import br.edu.fjn.barbearia.model.Horario;
import br.edu.fjn.barbearia.model.Usuario;
import br.edu.fjn.barbearia.repositorios.AgendamentoRopositorio;
import br.edu.fjn.barbearia.repositorios.DataDiaRepositorio;
import br.edu.fjn.barbearia.repositorios.FuncionarioRepositorio;
import br.edu.fjn.barbearia.repositorios.HorarioRepositorio;
import br.edu.fjn.barbearia.repositorios.LoginRepositorio;
import br.edu.fjn.barbearia.repositorios.ServicoRepositorio;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Davi-Dario
 */
@Controller
@Path("/admin")
public class AdmController {

    @Inject
    Result result;
    @Inject
    private UsuarioSession usuarioSession; 
     @Inject
    private AgendamentoRopositorio agendamentoRepositorio;

    @Get("")
    public void loginAdm() {

    }

    public void inicio() {

    }
    
    @Post("login")
    public void login(Usuario user){
        LoginRepositorio loginRepositorio = new LoginRepositorio();
        
        if(loginRepositorio.buscaPorNomeESenha(user.getUserName(), user.getPassword()) != null){
            usuarioSession.setLogado(true);
            result.redirectTo(AdmController.class).inicio();
        }else{
            result.include("mensagem", "Usuario ou senha incorretos.");
            result.redirectTo(this).loginAdm();
        }
    }

    @Get("servico")
    public void verServico() {
        ServicoRepositorio servicoRepositorio = new ServicoRepositorio();
        List<Servico> servicos = servicoRepositorio.list();
        result.include("servico", servicos);
    }

    @Get("cadastrarservico")
    public void cadServico() {

    }

    @Get("cadastrarfuncionario")
    public void cadFuncionario() {

    }

    @Get("cadastrarhorario")
    public void cadHorario() {

    }

    @Get("cadastrardias")
    public void cadDias() {

    }
    
    @Get("listadeagendamentos")
    public void verAgendamentos(){
         result.include("agendamentoList", agendamentoRepositorio.list());                
    }
       @Get("meushorarios")
    public void meuAgendamento() {
        result.include("agendamentoList", agendamentoRepositorio.list());

    }
    

    /*@Post("atualizarservico")
        public void update(Servico servico) {
        ServicoRepositorio servicoRepositorio = new ServicoRepositorio();

        if (servicoRepositorio.buscarPorId(servico.getId()) != null) {
            Servico s = servicoRepositorio.buscarPorId(servico.getId());

            if (servico.getDescricao() != null) {
                s.setDescricao(servico.getDescricao());
            }

            servicoRepositorio.atualizar(s);
            result.redirectTo(this).verServico();
        } else {
            result.include("menssage", "Não existe um servico com esse id!");
            result.redirectTo(this).verServico();
        }
    }*/
    @Get("funcionario")
    public void verFuncionario() {
        FuncionarioRepositorio funcionarioRepositorio = new FuncionarioRepositorio();
        List<Funcionario> funcionarios = funcionarioRepositorio.list();
        result.include("funcionario", funcionarios);
    }

    @Post("salvar")
    public void salvar(Servico servico) {
        ServicoRepositorio servicoRepositorio = new ServicoRepositorio();
        servicoRepositorio.salvar(servico);
        result.redirectTo(this).verServico();

    }

    @Post("salvar2")
    public void salvar(Funcionario funcionario) {
        FuncionarioRepositorio funcionarioRepositorio = new FuncionarioRepositorio();
        funcionarioRepositorio.salvar(funcionario);
        result.redirectTo(this).verFuncionario();

    }

    @Post("salvar3")
    public void salvar(Horario horario) {
        HorarioRepositorio horarioRepositorio = new HorarioRepositorio();
        horarioRepositorio.salvar(horario);
        result.redirectTo(this).verHorario();

    }

    @Post("salvar4")
    public void salvar(DataDia data) {
        DataDiaRepositorio dataDiaRepositorio = new DataDiaRepositorio();
        dataDiaRepositorio.salvar(data);
        result.redirectTo(this).verDias();

    }

    @Get("horario")
    public void verHorario() {
        HorarioRepositorio horarioRepositorio = new HorarioRepositorio();
        List<Horario> horario = horarioRepositorio.list();
        result.include("horario", horario);
    }

    @Get("dias")
    public void verDias() {
        DataDiaRepositorio dataDiaRepositorio = new DataDiaRepositorio();
        List<DataDia> data = dataDiaRepositorio.list();
        result.include("data", data);
    }

    @Post("remover")
    public void deletar(Horario horario) {
        HorarioRepositorio horarioRepositorio = new HorarioRepositorio();
        horarioRepositorio.deletar(horario);
        result.redirectTo(this).verHorario();
    }

    @Post("remover2")
    public void deletar(Servico servico) {
        ServicoRepositorio servicoRepositorio = new ServicoRepositorio();
        servicoRepositorio.deletar(servico);
        result.redirectTo(this).verServico();
    }

    @Post("remover3")
    public void deletar(DataDia data) {
        DataDiaRepositorio dataDiaRepositorio = new DataDiaRepositorio();
        dataDiaRepositorio.deletar(data);
        result.redirectTo(this).verDias();
    }

    @Post("remover4")
    public void deletar(Funcionario funcionario) {
        FuncionarioRepositorio funcionarioRepositorio = new FuncionarioRepositorio();
        funcionarioRepositorio.deletar(funcionario);
        result.redirectTo(this).verFuncionario();
    }
    

}
