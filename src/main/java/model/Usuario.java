package model;

public class Usuario {

    private int id;
    private String nome;
    private String matricula;
    private String email;
    private String senha;
    private double saldo;

    public Usuario(
            int id,
            String nome,
            String matricula,
            String email,
            String senha,
            double saldo
    ) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.senha = senha;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}