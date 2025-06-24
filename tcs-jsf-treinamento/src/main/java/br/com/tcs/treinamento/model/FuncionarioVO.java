package br.com.tcs.treinamento.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class FuncionarioVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String nome;
    private Date data;
    private String tipoDocumento;
    private String numeroCPF;
    private String numeroCNPJ;
    private Boolean ativo = true;

    public FuncionarioVO(Long id, String nome, Date data, String tipoDocumento, String numeroCPF, String numeroCNPJ, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.tipoDocumento = tipoDocumento;
        this.numeroCPF = numeroCPF;
        this.numeroCNPJ = numeroCNPJ;
        this.ativo = ativo;
    }

    public FuncionarioVO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroCPF() {
        return numeroCPF;
    }

    public void setNumeroCPF(String numeroCPF) {
        this.numeroCPF = numeroCPF;
    }

    public String getNumeroCNPJ() {
        return numeroCNPJ;
    }

    public void setNumeroCNPJ(String numeroCNPJ) {
        this.numeroCNPJ = numeroCNPJ;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuncionarioVO that = (FuncionarioVO) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(data, that.data) && Objects.equals(tipoDocumento, that.tipoDocumento) && Objects.equals(numeroCPF, that.numeroCPF) && Objects.equals(numeroCNPJ, that.numeroCNPJ) && Objects.equals(ativo, that.ativo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, data, tipoDocumento, numeroCPF, numeroCNPJ, ativo);
    }
}
