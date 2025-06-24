package br.com.tcs.treinamento.bean;

import br.com.tcs.treinamento.model.FuncionarioVO;
import br.com.tcs.treinamento.model.PessoaVO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean(name="cadastroFuncionario")
@ViewScoped
public class CadastroFuncionarioBean implements Serializable {
    private static final long serialVersionUID = 3450069247988201468L;

    private FuncionarioVO cadastrarFuncionario = new FuncionarioVO();

    private String errorMessage;


}
