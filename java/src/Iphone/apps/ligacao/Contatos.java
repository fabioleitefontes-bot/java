package Iphone.apps.ligacao;

    public enum Contatos {

        MAE("55-11-98765-4321"),
        TRABALHO("55-11-2020-3030"),
        EMERGENCIA("911"),
        SUPORTE_APPLE("0800-777-1980"),
        FARMACIA("55-11-3030-4040");

        private final String numeroTelefone;

        Contatos(String numeroTelefone) {
            this.numeroTelefone = numeroTelefone;
        }

        public String getNumeroTelefone() {
            return numeroTelefone;
        }
    }

