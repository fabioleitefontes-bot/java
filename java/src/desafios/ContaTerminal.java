package desafios;

import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) {
        Scanner Fabio = new Scanner(System.in);
       
        
        System.out.println("Digite o numero do cliente: ");
        int numero = Fabio.nextInt();
        Fabio.nextLine();
        System.out.println("Digite o numero da agencia: ");
        String agencia = Fabio.nextLine();
        
        System.out.println("Digite o nome do cliente: ");
        String nomeCliente = Fabio.nextLine();
        
        System.out.println("Digite o saldo do cliente: ");
        double saldo = Fabio.nextDouble();
         Fabio.close();
       System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo é R$ %.2f já está disponível para saque.\n", 
    nomeCliente, agencia, numero, saldo);

}
}