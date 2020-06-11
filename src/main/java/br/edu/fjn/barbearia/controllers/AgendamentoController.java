/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fjn.barbearia.controllers;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.fjn.barbearia.model.Agendamento;
import br.edu.fjn.barbearia.model.DataDia;
import br.edu.fjn.barbearia.model.Funcionario;
import br.edu.fjn.barbearia.model.Horario;
import br.edu.fjn.barbearia.model.Servico;
import br.edu.fjn.barbearia.repositorios.AgendamentoRopositorio;
import br.edu.fjn.barbearia.repositorios.DataDiaRepositorio;
import br.edu.fjn.barbearia.repositorios.FuncionarioRepositorio;
import br.edu.fjn.barbearia.repositorios.HorarioRepositorio;
import br.edu.fjn.barbearia.repositorios.ServicoRepositorio;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author david
 */
@Controller
@Path("agendar")
public class AgendamentoController {

    @Inject
    private Result result;

    @Inject
    private AgendamentoRopositorio agendamentoRepositorio;

    public void agendamento() {

    }

    @Get("agendar")
    public void agendar() {
        ServicoRepositorio servicoRepositorio = new ServicoRepositorio();
        FuncionarioRepositorio funcionarioRepositorio = new FuncionarioRepositorio();
        HorarioRepositorio horarioRepositorio = new HorarioRepositorio();
        DataDiaRepositorio dataDiaRepositorio = new DataDiaRepositorio();

        List<Servico> servicos = servicoRepositorio.list();
        List<Funcionario> funcionarios = funcionarioRepositorio.list();
        List<Horario> horarios = horarioRepositorio.list();
        List<DataDia> datadias = dataDiaRepositorio.list();

        result.include("servicos", servicos);
        result.include("funcionarios", funcionarios);
        result.include("horarios", horarios);
        result.include("datadias", datadias);

    }

    @Get("id/{id}")
    public void get(Integer id) {
        result.include("chamado", agendamentoRepositorio.buscarPorId(id));
//        result.of(this).atualizaChamado();
    }
    
    @Post("salvar")
    public void salvar(Agendamento agendar) {
        agendamentoRepositorio.salvar(agendar);
        result.redirectTo(this).meuAgendamento();
    }
    
    @Get("meushorarios")
    public void meuAgendamento(){
           result.include("agendamentoList", agendamentoRepositorio.list());
        
    }
     @Post("remover")
    public void deletar(Agendamento agendamento) {
        agendamentoRepositorio.deletar(agendamento);
        result.redirectTo(this).meuAgendamento();
    }

}
