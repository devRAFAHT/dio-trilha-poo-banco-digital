import entities.*;

public class Main {

	public static void main(String[] args) {
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");

		Banco banco = new Banco("Inter");
		Conta cc = new ContaCorrente(venilton);
		Conta poupanca = new ContaPoupanca(venilton);

		cc.depositar(100);
		cc.transferir(100, poupanca);

		System.out.println("Lista");
		cc.listaTranferencias();
		
		//cc.imprimirExtrato();
		//poupanca.imprimirExtrato();
	}

}
