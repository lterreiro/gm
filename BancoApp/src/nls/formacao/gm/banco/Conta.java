/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nls.formacao.gm.banco;

/**
 *
 * @author NLS
 */
public class Conta {

    /**
     * @param args the command line arguments
     */
    private int numero;
    public String tipo;
    private float saldo;
    public String nib;
    public boolean encerrada;

    public Conta(int numero, String tipo, float saldo, String banco) {
        this.numero = numero;
        this.tipo = tipo;
        this.saldo = saldo;
        this.nib = banco+numero;
        this.encerrada = false;
    }
    
    public void EncerrarConta(float val) {
        this.encerrada = true;;
    }
        
    public void creditar(float val) {
        this.saldo = this.saldo + val;
    }

    public void debitar(float val) {
        this.saldo = this.saldo - val;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getNib() {
        return nib;
    }

    public void setNib(String nib) {
        this.nib = nib;
    }
    
}
