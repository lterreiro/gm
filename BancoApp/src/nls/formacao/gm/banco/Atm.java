/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nls.formacao.gm.banco;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author nls/JosePinto
 */
public class Atm {

    //Atributos 
    private String id;
    private float saldo;
    // private Date data ;
    private Conta conta;
    private Banco banco;

    //Metodos especiais
    public Atm(String id, float saldo, Conta conta, Banco banco) {
        this.id = id;
        this.saldo = saldo;
        //  this.data = data;
        this.conta = conta;
        this.banco = banco;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    /*
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
     */
    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    //Metodos publicos
    public boolean carregar(float val) {
        return true;
    }

    public boolean descarregar() {
        return true;
    }

    public void levantar(int num, float val) {
        if (!conta.encerrada) {
            if (val > conta.getSaldo()) {
                System.out.println("conta sem saldo ");
            } else {
                banco.debitar(num, val);
                System.out.println("Operacao efetuado com sucesso");
                System.out.println("O Seu novo saldo é de : " + (conta.getSaldo() - val));
            }
        } else {
            System.out.println("conta encerrada " + conta.getNumero());
        }
    }

    public void depositar(int num, float val) {
        if (!conta.encerrada && val > 0) {
            banco.creditar(num, val);
            System.out.println("Operacao efetuado com sucesso");
            System.out.println("O Seu novo saldo é de : " + (conta.getSaldo() + val));
        } else {
            System.out.println("Conta invalida" );
        }
    }

    public boolean transferir(int contaOrigem, int contaDestino, float val) {
        return true;
    }

}
