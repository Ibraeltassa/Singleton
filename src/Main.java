import com.singleton.AccountManager;
import com.singleton.Cliente;

public class Main {
    public static void main(String[] args) {
        // Criando dois clientes
        Cliente cliente1 = new Cliente("1", "Alice");
        Cliente cliente2 = new Cliente("2", "Bob");

        // Cliente 1 realiza operações
        cliente1.depositar(500); // Deposita 500
        cliente1.verSaldo();     // Mostra o saldo de Alice

        // Cliente 2 realiza operações
        cliente2.depositar(300); // Deposita 300
        cliente2.sacar(100);     // Saca 100
        cliente2.verSaldo();     // Mostra o saldo de Bob

        // Listar todas as contas ativas no sistema
        AccountManager.getInstance().listarContasAtivas();

        // Demonstra que o Singleton é a mesma instância
        AccountManager anotherInstance = AccountManager.getInstance();
        System.out.println("AccountManager é a mesma instância: " + (AccountManager.getInstance() == anotherInstance));
    }
}