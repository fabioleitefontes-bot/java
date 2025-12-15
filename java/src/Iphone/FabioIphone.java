package Iphone;

import Iphone.apps.ligacao.AppLigacao;
import Iphone.apps.ligacao.Contatos;
import Iphone.apps.musica.AppMusica;
import Iphone.apps.musica.TiposMusica;
import java.util.Scanner;

public class FabioIphone {

    private AppLigacao appLigacao;
    private AppMusica appMusica;

    private int bateria;
    protected boolean ligado;

    public FabioIphone() {
        this.bateria = 50;
        this.ligado = false;
        this.appLigacao = new AppLigacao();
        this.appMusica = new AppMusica();
    }

    private void gastarBateria(int consumo) {
        if (this.bateria >= consumo) {
            this.bateria -= consumo;
            System.out.println(" Bateria gasta em " + consumo + "%. Nível atual: " + this.bateria + "%");
        } else {
            this.bateria = 0;
            this.desligar();
            System.out.println(" Bateria esgotada. Desligando.");
        }
    }

    public void carregar(int cargaAdicionada) {
        this.bateria = this.bateria + cargaAdicionada;
        this.bateria = Math.min(100, this.bateria);
        if(this.bateria == 100){
            System.out.println("Carregado 100%");
        } else {
            System.out.println("Carregou +" + cargaAdicionada + "%. Bateria atual: " + this.bateria + "%");
        }
    }

    public void mostrarBateriaAtual() {
        System.out.println("Bateria atual: " + this.bateria + "%");
    }

    public void ligar(){
        if(this.bateria > 5 && !this.ligado){
            this.ligado = true;
            System.out.println("Ligado"); }
        else if(this.ligado == true){
            System.out.println("o FabioIphone já estáLigado");
        }
        else{System.out.println("bateria insuficiente");}
    }

    public void desligar(){
        if(this.ligado == true){
            this.ligado = false;
            System.out.println("Desligado");
        }
        else{System.out.println("FabioIphone ja desligado");}
    }

    public void fazerLigacao(Contatos contato) {
        if (!this.ligado || this.bateria < 5) {
            System.out.println(" Erro: Não é possível fazer a chamada.");
            System.out.println("Requisitos: FabioIphone ligado e bateria acima de 5%.");
            return;
        }
        this.gastarBateria(5);
        this.appLigacao.ligar(contato);
    }

    public void encerrarLigacao() {
        this.appLigacao.pararLigacao();
    }

    public void tocarMusica(String nomeMusica, TiposMusica tipo) {
        if (!this.ligado || this.bateria < 1) {
            System.out.println("Erro: Não é possível reproduzir música.");
            System.out.println("Requisitos: FabioIphone ligado e bateria acima de 1%.");
            return;
        }
        this.gastarBateria(1);
        this.appMusica.tocarMusica(nomeMusica, tipo);
    }

    public void pararReproducaoMusica() {
        this.appMusica.pararMusica();
    }

    public static void main(String[] args) {

        FabioIphone meuIphone = new FabioIphone();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        System.out.println("=========================================");
        System.out.println("       SIMULADOR FABIOIPHONE INICIAL");
        System.out.println("=========================================");

        meuIphone.ligar();
        System.out.println();

        while (meuIphone.ligado) {

            MenuPrincipal();
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println(" Opção inválida. Digite um número.");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    menuLigacao(meuIphone, scanner);
                    break;
                case 2:
                    menuMusica(meuIphone, scanner);
                    break;
                case 3:
                    meuIphone.mostrarBateriaAtual();
                    meuIphone.carregar(10);
                    break;
                case 0:
                    meuIphone.desligar();
                    break;
                default:
                    System.out.println(" Opção não reconhecida. Tente novamente.");
            }
            System.out.println("-----------------------------------------");
        }

        System.out.println("Simulador Encerrado.");
        scanner.close();
    }

    private static void MenuPrincipal() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1 - Fazer Ligação");
        System.out.println("2 - Tocar Música");
        System.out.println("3 - Status Bateria / Carregar (+10%)");
        System.out.println("0 - Desligar FabioIphone e Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void menuLigacao(FabioIphone iphone, Scanner scanner) {

        int escolha = -1;
        while(escolha != 0) {

            if (escolha != -1) {
                System.out.println("\n--- APLICAÇÃO LIGAÇÃO ---");
                System.out.println("Deseja continuar no aplicativo ou sair?");
                System.out.println("1 - Confirmar (Continuar)");
                System.out.println("0 - Sair (Voltar ao Menu Principal)");
                System.out.print("Escolha: ");

                if (scanner.hasNextInt()) {
                    int confirmacao = scanner.nextInt();
                    scanner.nextLine();
                    if (confirmacao == 0) {
                        escolha = 0;
                        continue;
                    }
                } else {
                    scanner.nextLine();
                    continue;
                }
            }

            System.out.println("\n--- APP LIGAÇÃO ---");
            System.out.println("1 - Encerrar Ligação Atual");
            System.out.println("2 - Ligar para Novo Número (Manual)");

            Contatos[] contatos = Contatos.values();
            for (int i = 0; i < contatos.length; i++) {
                System.out.println((i + 3) + " - Ligar para " + contatos[i].name());
            }
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                escolha = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println(" Entrada inválida.");
                scanner.nextLine();
                continue;
            }

            if (escolha == 1) {
                iphone.encerrarLigacao();
            } else if (escolha == 2) {
                System.out.print("Nome do Novo Contato: ");
                String nome = scanner.nextLine();
                System.out.print("Número de Telefone: ");
                String numero = scanner.nextLine();

                System.out.println("\n AÇÃO MANUAL: LIGANDO...");
                System.out.println("Tentativa de ligação manual para: " + nome + " (" + numero + ")");
            } else if (escolha >= 3 && escolha <= contatos.length + 2) {
                Contatos contatoEscolhido = contatos[escolha - 3];
                iphone.fazerLigacao(contatoEscolhido);
            } else if (escolha != 0) {
                System.out.println(" Opção de contato inválida.");
            }
            if (escolha != 0) System.out.println("-----------------------------------------");
        }
    }

    private static void menuMusica(FabioIphone iphone, Scanner scanner) {

        int escolhaApp = -1;
        while(escolhaApp != 0) {

            if (escolhaApp != -1) {
                System.out.println("\n--- APLICAÇÃO MÚSICA ---");
                System.out.println("Deseja continuar no aplicativo ou sair?");
                System.out.println("1 - Confirmar (Continuar)");
                System.out.println("0 - Sair (Voltar ao Menu Principal)");
                System.out.print("Escolha: ");

                if (scanner.hasNextInt()) {
                    int confirmacao = scanner.nextInt();
                    scanner.nextLine();
                    if (confirmacao == 0) {
                        iphone.pararReproducaoMusica();
                        escolhaApp = 0;
                        continue;
                    }
                } else {
                    scanner.nextLine();
                    continue;
                }
            }

            System.out.println("\n--- APP MÚSICA ---");
            System.out.print("Digite o NOME da música: ");
            String nomeMusica = scanner.nextLine();

            System.out.println("Escolha o GÊNERO:");
            TiposMusica[] generos = TiposMusica.values();
            for (int i = 0; i < generos.length; i++) {
                System.out.println((i + 1) + " - " + generos[i].name());
            }
            System.out.print("Escolha uma opção de gênero: ");

            int escolhaGenero = -1;
            if (scanner.hasNextInt()) {
                escolhaGenero = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println(" Entrada inválida.");
                scanner.nextLine();
                continue;
            }

            if (escolhaGenero >= 1 && escolhaGenero <= generos.length) {
                TiposMusica generoEscolhido = generos[escolhaGenero - 1];
                iphone.tocarMusica(nomeMusica, generoEscolhido);
            } else {
                System.out.println(" Opção de gênero inválida. Retornando ao menu do App Música.");
                continue;
            }

            escolhaApp = 1;
            if (escolhaApp != 0) System.out.println("-----------------------------------------");
        }
    }
}