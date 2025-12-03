package logica.lacos;

import java.util.Scanner;

public class loop {
    public static void main(String[] args) {
        Scanner fabio = new Scanner(System.in);
        double saldo = 100.00;
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- SIMULADOR BANCÁRIOd ---");
            System.out.printf("Seu saldo é: R$ %.2f\n", saldo);
            System.out.println("Deseja fazer um saque ou depósito? (s/d) ou (e) para Encerrar:");
            
            String opcao = fabio.nextLine().toLowerCase();

            if (opcao.equals("s")) {
                System.out.println("Digite o valor a ser sacado: ");
                double saque = fabio.nextDouble();
                
                if (saque > saldo) {
                    System.out.println("ERRO: Saldo insuficiente para esta operação.");
                } else {
                    saldo -= saque;
                    System.out.println("Saque realizado com sucesso.");
                }
                
                fabio.nextLine(); 

            } else if (opcao.equals("d")) {
                System.out.println("Digite o valor a ser depositado: ");
                double deposito = fabio.nextDouble();
                
                saldo += deposito;
                System.out.println("Depósito realizado com sucesso.");
                
                fabio.nextLine();

            } else if (opcao.equals("e")) {
                continuar = false;
                
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        } 

        System.out.println("Obrigado por utilizar  serviço o Saldo final é: R$ " + saldo);
        fabio.close();
    }
}