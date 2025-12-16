package Banco;



import Banco.cliente.Cliente;
import Banco.contas.Conta;
import Banco.contas.tipo.ContaCorrente;
import Banco.contas.tipo.ContaPoupanca;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Bem vindo ao ByteBank");

		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");
	
		Cliente Fabiou = new Cliente();
		Fabiou.setNome("Fabio");
		
		Conta cc = new ContaCorrente(venilton);
		Conta poupanca = new ContaPoupanca(venilton);

		cc.depositar(200);
		cc.transferir(50, poupanca);
		cc.comprarBitcoin();

		cc.imprimirExtrato();
		poupanca.imprimirExtrato();

		Conta Fabio = new ContaCorrente(Fabiou);
		Conta pp = new ContaPoupanca(Fabiou);

		Fabio.depositar(200);
		Fabio.transferir(100, pp);
		
		Fabio.comprarBitcoin();

		Fabio.imprimirExtrato();
		pp.imprimirExtrato();
		
	}
	
}