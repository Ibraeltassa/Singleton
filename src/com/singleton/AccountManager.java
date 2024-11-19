package com.singleton;

import java.util.HashMap;
import java.util.Map;

public class AccountManager {
    // A única instância da classe
    private static AccountManager instance;

    // Map para armazenar as contas (ID -> Saldo)
    private Map<String, Double> contas;

    // Construtor privado (ninguém pode instanciar diretamente)
    private AccountManager() {
        contas = new HashMap<>();
    }

    // Método para obter a instância única
    public static AccountManager getInstance() {
        if (instance == null) {
            instance = new AccountManager();
        }
        return instance;
    }

    // Criar ou garantir que uma conta exista
    public void criarConta(String contaId, double saldoInicial) {
        contas.putIfAbsent(contaId, saldoInicial);
    }

    // Método para depositar
    public void depositar(String contaId, double valor) {
        if (!contas.containsKey(contaId)) {
            System.out.println("Conta não encontrada!");
            return;
        }
        contas.put(contaId, contas.get(contaId) + valor);
        System.out.println("Depósito de " + valor + " realizado na conta " + contaId);
    }

    // Método para sacar
    public void sacar(String contaId, double valor) {
        if (!contas.containsKey(contaId)) {
            System.out.println("Conta não encontrada!");
            return;
        }
        double saldoAtual = contas.get(contaId);
        if (saldoAtual >= valor) {
            contas.put(contaId, saldoAtual - valor);
            System.out.println("Saque de " + valor + " realizado na conta " + contaId);
        } else {
            System.out.println("Saldo insuficiente na conta " + contaId);
        }
    }

    // Ver saldo
    public void verSaldo(String contaId) {
        if (!contas.containsKey(contaId)) {
            System.out.println("Conta não encontrada!");
            return;
        }
        System.out.println("Saldo da conta " + contaId + ": " + contas.get(contaId));
    }

    // Listar todas as contas ativas
    public void listarContasAtivas() {
        System.out.println("Contas ativas:");
        for (Map.Entry<String, Double> entry : contas.entrySet()) {
            System.out.println("Conta ID: " + entry.getKey() + ", Saldo: " + entry.getValue());
        }
    }
}
