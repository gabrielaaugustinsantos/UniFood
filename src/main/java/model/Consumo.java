package model;

public class Consumo {

    private String emailUsuario;
    private String nomeRefeicao;

    public Consumo(String emailUsuario, String nomeRefeicao) {
        this.emailUsuario = emailUsuario;
        this.nomeRefeicao = nomeRefeicao;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public String getNomeRefeicao() {
        return nomeRefeicao;
    }
}