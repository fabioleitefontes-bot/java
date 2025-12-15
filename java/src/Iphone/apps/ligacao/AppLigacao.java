package Iphone.apps.ligacao;

public class AppLigacao {

    private Contatos contatoAtual;
    private boolean chamada = false;

    public void ligar(Contatos contato){

        if (this.chamada) {
            System.out.println("⚠️ Já em uma chamada com: " + this.contatoAtual.name() + ". Desligue primeiro.");
            return;
        }

        String numeroParaDiscar = contato.getNumeroTelefone();

        this.contatoAtual = contato;
        this.chamada = true;

        switch (contato){
            case MAE:
                System.out.println("📞 Ligando para " + contato.name() +
                        " (" + numeroParaDiscar + ")...");
                System.out.println("💖 Aviso: Ativando áudio no modo Hi-Fi.");
                break;

            case EMERGENCIA:
                System.out.println("🚨 Ligando para EMERGÊNCIA (" + numeroParaDiscar + ")");
                System.out.println("🚨 MODO: Prioridade de rede máxima.");
                break;

            default:
                System.out.println("📱 Ligando para " + contato.name() +
                        " (" + numeroParaDiscar + ")...");
                break;
        }
    }

    public void pararLigacao(){
        if(this.chamada == true){
            this.chamada = false;
            this.contatoAtual = null;
            System.out.println("pi pi pi... chamada encerrada");
        }
        else {
            System.out.println("você não está em uma chamada");
        }
    }
}