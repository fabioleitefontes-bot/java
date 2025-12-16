package Banco.contas;

import java.util.Scanner;

import Banco.cliente.Cliente;

public abstract class Conta implements IConta {
	Scanner scanner = new Scanner(System.in);
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected int bitcoin;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	public void comprarBitcoin() {
		
		System.out.println("Quantos bitcoins deseja comprar?");
		int quantidade = scanner.nextInt();
		int valorUnitario = 10;
		double valorTotal = quantidade * valorUnitario;
	
	
		if (this.saldo >= valorTotal) {
			this.sacar(valorTotal);
			this.bitcoin += quantidade;
			System.out.println(String.format("Compra de %d bitcoins realizada com sucesso!", quantidade));
		} else {
			System.out.println("Saldo insuficiente para comprar bitcoins.");
		}
	
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
	public int getBitcoin() {
		return bitcoin;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		System.out.println(String.format("Bitcoin: %d \n", this.bitcoin));
	}

}