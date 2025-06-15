package com.help.app_msg.models;

public class user {

    private String nome;
    private int idade;
    private int turma;
    private String prontuario;

    public user(String nome, int idade, int turma, String prontuario){
        this.nome = nome;
        this.prontuario = prontuario;
        this.turma = turma;
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public String getProntuario() {
        return prontuario;
    }

    public String getNome() {
        return nome;
    }

    public int getTurma() {
        return turma;
    }
}
