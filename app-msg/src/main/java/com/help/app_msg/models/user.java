package com.help.app_msg.models;

public class user {

    private String nome;
    private int idade;
    private int turma;
    private int prontuario;

    public user(String nome, int idade, int turma, int prontuario){
        this.nome = nome;
        this.prontuario = prontuario;
        this.turma = turma;
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public int getProntuario() {
        return prontuario;
    }

    public String getNome() {
        return nome;
    }

    public int getTurma() {
        return turma;
    }
}
