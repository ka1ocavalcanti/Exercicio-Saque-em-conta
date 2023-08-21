package entities;

import excecoes.NegociosExececoes;

public class Conta {

    private Integer numero;
    private String titular;
    private Double saldo;
    private Double limiteDeSaque;

    public Conta() {
    }

    public Conta(Integer numero, String titular, Double saldo, Double limiteDeSaque) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.limiteDeSaque = limiteDeSaque;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getLimiteDeSaque() {
        return limiteDeSaque;
    }

    public void setLimiteDeSaque(Double limiteDeSaque) {
        this.limiteDeSaque = limiteDeSaque;
    }
    public void deposito(double quantia){
        saldo += quantia;
    }
    public void saque(double quantia){
        validadeDeLimite(quantia);
        saldo -= quantia;
    }
    private void validadeDeLimite(double quantia){
        if (quantia > getLimiteDeSaque()){
            throw new NegociosExececoes("Erro de saque: A quantia excede o limite de saque");
        }
        if (quantia >getSaldo()) {
            throw new NegociosExececoes("Erro de saque insuficiente");
        }
    }
}
