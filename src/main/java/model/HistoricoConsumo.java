package model;

public class HistoricoConsumo {

    private String nomeAluno;
    private String refeicao;
    private String data;

    public HistoricoConsumo(String nomeAluno, String refeicao, String data) {
        this.nomeAluno = nomeAluno;
        this.refeicao = refeicao;
        this.data = data;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public String getRefeicao() {
        return refeicao;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Aluno: " + nomeAluno +
                " | Refeição: " + refeicao +
                " | Data: " + data;
    }
}