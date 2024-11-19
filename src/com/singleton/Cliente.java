package com.singleton;

public class Cliente {
    private String id;
    private String nome;

    public Cliente(String id, String nome) {
        this.id = id;
        this.nome = nome;

        // Cria uma conta para o cliente automaticamente
        AccountManager.getInstance().criarConta(id, 0.0);
    }

    public void depositar(double valor) {
        AccountManager.getInstance().depositar(id, valor);
    }

    public void sacar(double valor) {
        AccountManager.getInstance().sacar(id, valor);
    }

    public void verSaldo() {
        AccountManager.getInstance().verSaldo(id);
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
