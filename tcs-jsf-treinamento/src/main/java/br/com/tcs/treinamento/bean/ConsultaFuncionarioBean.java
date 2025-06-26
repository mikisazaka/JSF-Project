package br.com.tcs.treinamento.bean;

import br.com.tcs.treinamento.entity.Funcionario;
import org.primefaces.PrimeFaces;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "consultaFuncionarioBean")
@ViewScoped
public class ConsultaFuncionarioBean {

    private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

    private Funcionario funcionarioEscolhido;

    private String errorMessage;

    public void selecionarFuncionario(Funcionario funcionario) {
        this.funcionarioEscolhido = funcionario;
    }

    public void alterarFuncionario(Funcionario funcionario) {
        PrimeFaces.current().executeScript("PF('modifyDialog'.show());");
    }

    public void deletarFuncionario(Funcionario funcionario) {
        funcionarios.remove(funcionario);
        PrimeFaces.current().executeScript("PF('deletarDialog'.show());");
    }

    public void validarCampos(Funcionario funcionario) {
        List<String> erros = new ArrayList<>();

        if(funcionario.getTipoDocumento() == null || funcionario.getTipoDocumento().trim().isEmpty()) {
            erros.add("Tipo de documento não informado.");
        } else {
            if(funcionario.getTipoDocumento().equals("CPF")) {
                if(funcionario.getNumeroCPF() == null || funcionario.getNumeroCPF().trim().isEmpty()
                        || funcionario.getNumeroCPF().length() < 11) {
                    erros.add("CPF não informado ou incompleto (deve conter 11 dígitos).");
                }
            } else if(funcionario.getTipoDocumento().equals("CNPJ")) {
                if(funcionario.getNumeroCNPJ() == null || funcionario.getNumeroCNPJ().trim().isEmpty()
                        || funcionario.getNumeroCNPJ().length() < 14) {
                    erros.add("CNPJ não informado ou incompleto (deve conter 14 dígitos).");
                }
            }
        }

        if(!erros.isEmpty()) {
            errorMessage = String.join("\n" + erros);
            PrimeFaces.current().executeScript("PF('errorDialog'.show());");
        } else {
            PrimeFaces.current().executeScript("PF('successDialog'.show());");
        }
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public Funcionario getFuncionarioEscolhido() {
        return funcionarioEscolhido;
    }

    public void setFuncionarioEscolhido(Funcionario funcionarioEscolhido) {
        this.funcionarioEscolhido = funcionarioEscolhido;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
