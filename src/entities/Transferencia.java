package entities;

import lombok.*;
import org.w3c.dom.ls.LSOutput;

import java.time.Instant;

@Getter
@Setter
@EqualsAndHashCode
public class Transferencia {

    private Conta contaOrigem;
    private Conta contaDestino;
    private double valor;
    Instant dataHora;

    public Transferencia(Conta contaOrigem, Conta contaDestino, double valor, Instant dataHora) {
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "\n----------------------------------------------" +
                "\nOrigem\n" +
                "----------------------------------------------\n" +
                "Titular: " + contaOrigem.getCliente().getNome() +
                "\nAgência: " + contaOrigem.getAgencia() +
                "\nNúmero: " + contaOrigem.getNumero() +
                "\n----------------------------------------------" +
                "\nDestino\n" +
                "----------------------------------------------\n" +
                "Titular: " + contaDestino.getCliente().getNome() +
                "\nAgência: " + contaDestino.getAgencia() +
                "\nNúmero: " + contaDestino.getNumero() +
                "\n----------------------------------------------" +
                "\nValor: " + valor +
                "\nData e hora: " + dataHora +
                "\n----------------------------------------------";
    }
}
