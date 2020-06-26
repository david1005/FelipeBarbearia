/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fjn.barbearia.model;

import java.io.Serializable;
import java.util.Date;
import java.util.TimerTask;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author david
 */
@Entity
public class Agendamento  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Servico servico;

    @JoinColumn
    @ManyToOne(fetch = FetchType.EAGER)
    private Funcionario funcionario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private DataDia dataDia;
    
  

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Horario horario;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Usuario usuario;
    
    private String nameCliente;
    
    
    
    public Agendamento(){
        
    }

    public String getNameCliente() {
        return nameCliente;
    }

    public void setNameCliente(String nameCliente) {
        this.nameCliente = nameCliente;
    }

    
  

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

 

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public DataDia getDataDia() {
        return dataDia;
    }

    public void setDataDia(DataDia dataDia) {
        this.dataDia = dataDia;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

  

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    
    
}
