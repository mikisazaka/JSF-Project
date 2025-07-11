package br.com.tcs.treinamento.bean;

import br.com.tcs.treinamento.entity.Funcionario;
import br.com.tcs.treinamento.model.FuncionarioVO;
import org.primefaces.PrimeFaces;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedProperty;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="cadastroFuncionario")
@SessionScoped
public class CadastroFuncionarioBean implements Serializable {
    private static final long serialVersionUID = 3450069247988201468L;

    private FuncionarioVO cadastrarFuncionario = new FuncionarioVO();

    @ManagedProperty(value = "#{consultaFuncionarioBean}")
    private ConsultaFuncionarioBean consultaFuncionarioBean;

    private String errorMessage;

    public void confirmar() {
        try {
            Funcionario funcionario = new Funcionario();
            funcionario.setNome(cadastrarFuncionario.getNome());
            funcionario.setData(cadastrarFuncionario.getData());
            funcionario.setTipoDocumento(cadastrarFuncionario.getTipoDocumento());
            funcionario.setNumeroCPF(cadastrarFuncionario.getNumeroCPF());
            funcionario.setNumeroCNPJ(cadastrarFuncionario.getNumeroCNPJ());
            funcionario.setAtivo(true);
            funcionario.setDataManutencao(null);

            consultaFuncionarioBean.getFuncionarios().add(funcionario);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void limpar() {
        cadastrarFuncionario.setNome(null);
        cadastrarFuncionario.setData(null);
        cadastrarFuncionario.setTipoDocumento(null);
        cadastrarFuncionario.setNumeroCPF(null);
        cadastrarFuncionario.setNumeroCNPJ(null);
        cadastrarFuncionario.setDataManutencao(null);
        errorMessage = null;
    }

    public void validarCampos() {
        List<String> erros = new ArrayList<>();

        if (cadastrarFuncionario.getNome() == null || cadastrarFuncionario.getNome().trim().isEmpty()) {
            erros.add("Nome não informado.");
        }
        if (cadastrarFuncionario.getData() == null) {
            erros.add("Data de nascimento não informada.");
        }
        if (cadastrarFuncionario.getData().isAfter(LocalDate.now())) {
            erros.add("Data de nascimento inválida - não pode ser no futuro.");
        }
        if (cadastrarFuncionario.getTipoDocumento() == null || cadastrarFuncionario.getTipoDocumento().trim().isEmpty()) {
            erros.add("Tipo de documento não informado.");
        } else {
            if ("CPF".equals(cadastrarFuncionario.getTipoDocumento())) {
                if (cadastrarFuncionario.getNumeroCPF() == null || cadastrarFuncionario.getNumeroCPF().trim().isEmpty() ||
                        cadastrarFuncionario.getNumeroCPF().trim().length() < 11) {
                    erros.add("CPF não informado ou incompleto (deve conter 11 dígitos).");
                }
            } else if ("CNPJ".equals(cadastrarFuncionario.getTipoDocumento())) {
                if (cadastrarFuncionario.getNumeroCNPJ() == null || cadastrarFuncionario.getNumeroCNPJ().trim().isEmpty() ||
                        cadastrarFuncionario.getNumeroCNPJ().trim().length() < 14) {
                    erros.add("CNPJ não informado ou incompleto (deve conter 14 dígitos).");
                }
            }
        }

        if (!erros.isEmpty()) {
            errorMessage = String.join("<br/>", erros);
            PrimeFaces.current().executeScript("PF('errorDialog').show();");
        } else {
            confirmar();
            PrimeFaces.current().executeScript("PF('successDialog').show();");
        }
    }

    public FuncionarioVO getCadastrarFuncionario() {
        return cadastrarFuncionario;
    }

    public void setCadastrarFuncionario(FuncionarioVO cadastrarFuncionario) {
        this.cadastrarFuncionario = cadastrarFuncionario;
    }

    public void setConsultaFuncionarioBean(ConsultaFuncionarioBean consultaFuncionarioBean) {
        this.consultaFuncionarioBean = consultaFuncionarioBean;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
