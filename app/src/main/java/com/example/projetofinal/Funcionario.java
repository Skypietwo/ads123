package com.example.projetofinal;



public class Funcionario {
    private String id;
    private String cpf_cli;
    private String cod_espec;
    private String cod_prof;
    private String cod_proced;
    private String data_proced;
    private String descr_proced;
    private String link_proced;
    private String aut_vis_cli;

    public Funcionario(String id, String cpf_cli, String cod_espec, String cod_prof, String cod_proced, String data_proced, String descr_proced, String link_proced, String aut_vis_cli) {
        this.id= id;
        this.cpf_cli = cpf_cli;
        this.cod_espec = cod_espec;
        this.cod_prof = cod_prof;
        this.cod_proced = cod_proced;
        this.data_proced = data_proced;
        this.descr_proced = descr_proced;
        this.link_proced = link_proced;
        this.aut_vis_cli = aut_vis_cli;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getCpf_cli() {
        return cpf_cli;
    }

    public void setCpf_cli(String cpf_cli) {
        this.cpf_cli = cpf_cli;
    }

    public String getCod_espec() {
        return cod_espec;
    }

    public void setCod_espec(String cod_espec) {
        this.cod_espec = cod_espec;
    }

    public String getCod_prof() {
        return cod_prof;
    }

    public void setCod_prof(String cod_prof) {
        this.cod_prof = cod_prof;
    }

    public String getCod_proced() {
        return cod_proced;
    }

    public void setCod_proced(String cod_proced) {
        this.cod_proced = cod_proced;
    }

    public String getData_proced() {
        return data_proced;
    }

    public void setData_proced(String data_proced) {
        this.data_proced = data_proced;
    }

    public String getDescr_proced() {
        return descr_proced;
    }

    public void setDescr_proced(String descr_proced) {
        this.descr_proced = descr_proced;
    }

    public String getLink_proced() {
        return link_proced;
    }

    public void setLink_proced(String link_proced) {
        this.link_proced = link_proced;
    }

    public String getAut_vis_cli() {
        return aut_vis_cli;
    }

    public void setAut_vis_cli(String aut_vis_cli) {
        this.aut_vis_cli = aut_vis_cli;
    }
}
