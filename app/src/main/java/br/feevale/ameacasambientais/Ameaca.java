package br.feevale.ameacasambientais;

import android.content.Intent;

/**
 * Created by 0197359 on 25/10/2018.
 */

public class Ameaca {


    private Integer id;
    private String nome;
    private String endereco;
    private String bairro;
    private Integer impacto;

    public Ameaca() {

            }

    public Integer getImpacto() {
        return impacto;
    }

    public String getBairro() {
        return bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNome() {
        return nome;
    }

    public Integer getId() { return id; }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setImpacto(Integer impacto) {
        this.impacto = impacto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(Integer id) {
        this.id = id;
   }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("Ameaca: "+nome);
        str.append("Endereco: "+endereco);
        str.append("Bairro: "+bairro);
        str.append("Impacto: "+impacto);
        return str.toString();
    }
}
