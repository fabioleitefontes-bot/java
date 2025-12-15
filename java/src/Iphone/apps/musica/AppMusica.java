package Iphone.apps.musica;

public class AppMusica {
    private String MusicaAtual;
    private TiposMusica genero;
    private boolean tocando;

    public void abrirAppMusica(){
        System.out.println("Abrindo o  AppMusica");
    }
    public void tocarMusica(String MusicaAtual, TiposMusica genero) {

        if (this.tocando) {
            System.out.println("⚠️ Já está tocando: " + this.MusicaAtual + ". Pare a música primeiro.");
            return;
        }
        this.MusicaAtual = MusicaAtual;
        this.genero = genero;

        this.tocando = true;
        System.out.println("🎶 Reproduzindo: " + this.MusicaAtual);
        switch (genero) {
            case ROCK:
                System.out.println("🎸 MODO: Hardcore ativado! Volume no limite.");
                break;
            case CLASSICA:
                System.out.println("🎻 MODO: Foco. Volume suave, audição prolongada.");
                break;
            case POP:
                System.out.println("🎤 MODO: Festa! Preparando lista de dança.");
                break;
            case MPB:
                System.out.println("🇧🇷 MODO: Relaxamento. Foco na voz e instrumental.");
                break;
            default:
                System.out.println("Erro ao selecionar genero");
        }
    }
    public void pararMusica(){
            if (tocando){ this.tocando = false;
            System.out.println("Parando o  AppMusica");
        }
        else{
            System.out.println("o AppMusica já esta fechado");
    }}}


