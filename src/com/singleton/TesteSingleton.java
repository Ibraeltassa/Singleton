package com.singleton;

public class TesteSingleton {

    public static void main(String[] args) {
        // Criando clientes
        Cliente cliente1 = new Cliente("1", "Alice");
        Cliente cliente2 = new Cliente("2", "Bob");

        // Realizando operações com o cliente 1
        cliente1.depositar(500);
        cliente1.verSaldo();

        // Realizando operações com o cliente 2
        cliente2.depositar(300);
        cliente2.sacar(100);
        cliente2.verSaldo();

        // Verificar se ambos compartilham o mesmo AccountManager
        AccountManager.getInstance().listarContasAtivas();

        // Tentando criar outra instância de AccountManager (não será possível)
        AccountManager anotherInstance = AccountManager.getInstance();
        System.out.println("AccountManager é a mesma instância: " + (AccountManager.getInstance() == anotherInstance));
    }

}
