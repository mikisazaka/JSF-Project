package br.com.tcs.treinamento.bean;

import br.com.tcs.treinamento.entity.Funcionario;
import org.primefaces.PrimeFaces;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "consultaFuncionarioBean")
@SessionScoped
public class ConsultaFuncionarioBean implements Serializable {
    private static final long serialVersionUID = 3450069247988201468L;

    private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

    private Funcionario funcionarioEscolhido = new Funcionario();

    private String errorMessage;

    public void selecionarFuncionario(Funcionario funcionario) {
        this.funcionarioEscolhido = funcionario;
    }

    public void alterarFuncionario(Funcionario funcionario) {
        this.funcionarioEscolhido = funcionario;
        this.funcionarioEscolhido.setTipoDocumento("");
        this.funcionarioEscolhido.setDataManutencao(LocalDate.now());
    }

    public void confirmarExclusao() {
        if (funcionarioEscolhido != null) {
            funcionarioEscolhido.setAtivo(false);
            funcionarios.remove(funcionarioEscolhido);
            funcionarioEscolhido = null;
        }
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
            errorMessage = String.join("<br/>", erros);
            PrimeFaces.current().executeScript("PF('errorDialog').show();");
        } else {
            PrimeFaces.current().executeScript("PF('successDialog').show();");
        }
    }

    public String getDataNascimentoFormatada() {
        return funcionarioEscolhido.getData() != null ? funcionarioEscolhido.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "";
    }

    public String getDataManutencaoFormatada() {
        return funcionarioEscolhido.getDataManutencao() != null ? funcionarioEscolhido.getDataManutencao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "";
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
