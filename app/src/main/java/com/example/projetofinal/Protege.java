package com.example.projetofinal;

public class Protege {
    private String id;
    private String review;
    private String status;
    private String cod_prof; // adicionado posteriormente

    // Construtor vazio (default)
    public Protege(String id, String review, String status, String cod_prof)  {
        this.id = id;
        this.review = review;
        this.status = status;
        this.cod_prof = cod_prof;
    }

    // Getters e Setters para os campos
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCod_prof() {
        return cod_prof;
    }

    public void setCod_prof(String codProf) {
        this.cod_prof = codProf;
    }
}
