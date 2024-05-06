package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Banco {

	private String nome;
	private List<Conta> contas;

	public Banco(String nome){
		this.nome = nome;
	}

	public List<Cliente> listaClientes(){
		List<Cliente> clientes = new ArrayList<>();
		for(Conta conta : this.contas){
			clientes.add(conta.getCliente());
		}
		return clientes;
	}

}
