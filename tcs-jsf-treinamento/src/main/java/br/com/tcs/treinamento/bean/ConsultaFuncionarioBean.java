package br.com.tcs.treinamento.bean;

import br.com.tcs.treinamento.entity.Funcionario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "consultaFuncionarioBean")
@ViewScoped
public class ConsultaFuncionarioBean {

    private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}
