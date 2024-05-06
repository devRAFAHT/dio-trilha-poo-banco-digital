package entities;

import exceptions.InsufficientBalanceException;

public interface IConta {
	
	void sacar(double valor) throws InsufficientBalanceException;
	
	void depositar(double valor);
	
	void transferir(double valor, IConta contaDestino);
	
	void imprimirExtrato();
}
