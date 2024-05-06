package entities;

import exceptions.InsufficientBalanceException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	List<Transferencia> transferencias = new ArrayList<>();

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) throws InsufficientBalanceException {
        if(valor <= this.saldo) {
            this.saldo -= valor;
        }else{
			throw new InsufficientBalanceException("Saldo insuficiente");
        }
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		try {
			this.sacar(valor);
			contaDestino.depositar(valor);
			Instant instant = Instant.now();
			Transferencia transferencia = new Transferencia(this , (Conta) contaDestino, valor, instant);
			transferencias.add(transferencia);
		}catch (InsufficientBalanceException e){
			System.out.println("Erro na operação de transferência: " + e.getMessage());
		}
	}

	public void listaTranferencias(){
		for(Transferencia transferencia : transferencias){
			System.out.println(transferencia + "\n\n");
		}
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
