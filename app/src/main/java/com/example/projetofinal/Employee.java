package com.example.projetofinal;

public class Employee {
    private String id;
    private String cpf_cli;
    private String nome_cli;
    private String cod_cli;
    private String tel_cli;
    private String cep_cli;
    private String logra_cli;
    private String num_logra_cli;
    private String compl_cli;
    private String bairro_cli;
    private String cidade_cli;
    private String uf_cli;
    private String rg_cli;
    private String est_rg_cli;
    private String nome_mae_cli;
    private String data_nasc_cli;

    public Employee() {
    }

    public Employee(String id,String cpf_cli, String nome_cli, String cod_cli, String tel_cli, String cep_cli, String logra_cli, String num_logra_cli, String compl_cli, String bairro_cli, String cidade_cli, String uf_cli, String rg_cli, String est_rg_cli, String nome_mae_cli, String data_nasc_cli) {
        this.id = id;
        this.cpf_cli = cpf_cli;
        this.nome_cli = nome_cli;
        this.cod_cli = cod_cli;
        this.tel_cli = tel_cli;
        this.cep_cli = cep_cli;
        this.logra_cli = logra_cli;
        this.num_logra_cli = num_logra_cli;
        this.compl_cli = compl_cli;
        this.bairro_cli = bairro_cli;
        this.cidade_cli = cidade_cli;
        this.uf_cli = uf_cli;
        this.rg_cli = rg_cli;
        this.est_rg_cli = est_rg_cli;
        this.nome_mae_cli = nome_mae_cli;
        this.data_nasc_cli = data_nasc_cli;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id =id;
    }

    public String getCpf_cli() {
        return cpf_cli;
    }

    public void setCpf_cli(String cpf_cli) {
        this.cpf_cli = cpf_cli;
    }

    public String getNome_cli() {
        return nome_cli;
    }

    public void setNome_cli(String nome_cli) {
        this.nome_cli = nome_cli;
    }

    public String getCod_cli() {
        return cod_cli;
    }

    public void setCod_cli(String cod_cli) {
        this.cod_cli = cod_cli;
    }

    public String getTel_cli() {
        return tel_cli;
    }

    public void setTel_cli(String tel_cli) {
        this.tel_cli = tel_cli;
    }

    public String getCep_cli() {
        return cep_cli;
    }

    public void setCep_cli(String cep_cli) {
        this.cep_cli = cep_cli;
    }

    public String getLogra_cli() {
        return logra_cli;
    }

    public void setLogra_cli(String logra_cli) {
        this.logra_cli = logra_cli;
    }

    public String getNum_logra_cli() {
        return num_logra_cli;
    }

    public void setNum_logra_cli(String num_logra_cli) {
        this.num_logra_cli = num_logra_cli;
    }

    public String getCompl_cli() {
        return compl_cli;
    }

    public void setCompl_cli(String compl_cli) {
        this.compl_cli = compl_cli;
    }

    public String getBairro_cli() {
        return bairro_cli;
    }

    public void setBairro_cli(String bairro_cli) {
        this.bairro_cli = bairro_cli;
    }

    public String getCidade_cli() {
        return cidade_cli;
    }

    public void setCidade_cli(String cidade_cli) {
        this.cidade_cli = cidade_cli;
    }

    public String getUf_cli() {
        return uf_cli;
    }

    public void setUf_cli(String uf_cli) {
        this.uf_cli = uf_cli;
    }

    public String getRg_cli() {
        return rg_cli;
    }

    public void setRg_cli(String rg_cli) {
        this.rg_cli = rg_cli;
    }

    public String getEst_rg_cli() {
        return est_rg_cli;
    }

    public void setEst_rg_cli(String est_rg_cli) {
        this.est_rg_cli = est_rg_cli;
    }

    public String getNome_mae_cli() {
        return nome_mae_cli;
    }

    public void setNome_mae_cli(String nome_mae_cli) {
        this.nome_mae_cli = nome_mae_cli;
    }

    public String getData_nasc_cli() {
        return data_nasc_cli;
    }

    public void setData_nasc_cli(String data_nasc_cli) {
        this.data_nasc_cli = data_nasc_cli;
    }
}
