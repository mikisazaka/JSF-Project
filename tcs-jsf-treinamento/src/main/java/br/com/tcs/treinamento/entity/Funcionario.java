package br.com.tcs.treinamento.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private LocalDate data;

    private String tipoDocumento;

    private String numeroCPF;

    private String numeroCNPJ;

    private Boolean ativo = true;

    private LocalDate dataManutencao;

    public Funcionario() {
    }

    public Funcionario(String nome, LocalDate data, String tipoDocumento, String numeroCPF, String numeroCNPJ, Boolean ativo, LocalDate dataManutencao) {
        this.nome = nome;
        this.data = data;
        this.tipoDocumento = tipoDocumento;
        this.numeroCPF = numeroCPF;
        this.numeroCNPJ = numeroCNPJ;
        this.ativo = ativo;
        this.dataManutencao = dataManutencao;
    }

    public String getDataNascimentoFormatada() {
        return data != null ? data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "";
    }

    public String getDataManutencaoFormatada() {
        return dataManutencao != null ? dataManutencao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(data, that.data) && Objects.equals(tipoDocumento, that.tipoDocumento) && Objects.equals(numeroCPF, that.numeroCPF) && Objects.equals(numeroCNPJ, that.numeroCNPJ);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, data, tipoDocumento, numeroCPF, numeroCNPJ);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", data=" + data +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", numeroCPF='" + numeroCPF + '\'' +
                ", numeroCNPJ='" + numeroCNPJ + '\'' +
                '}';
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDate getDataManutencao() {
        return dataManutencao;
    }

    public void setDataManutencao(LocalDate dataManutencao) {
        this.dataManutencao = dataManutencao;
    }
}
