package nls.formacao.gm.banco; //nls.formacao.gm.banco;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Formacao
 */
public class Atm {

    private String id;
    private float saldo = 100;
    private Date data;

    //construtor
    public Atm() {

    }

    //getters  -  setters
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getSaldo() {
        return this.saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Date getData() {
        Calendar cal = new GregorianCalendar();
        return cal.getTime();
    }

    public void setData(Date data) {
        this.data = data;
    }

    //metodos do ATM
    public float carregar() {
        return 0.0f;
    }

    public boolean descarregar() {
        return true;
    }

    public float levantar(int valor, float saldo) {
        if (this.getSaldo() >= valor) {
            this.setSaldo(this.getSaldo() - valor);
            System.out.println("data de movimento : " + this.getData());
            System.out.println("Efectuou um levantamento no valor de " + valor + " Euros");
            System.out.println("O seu saldo actual é : " + this.getSaldo());
        } else {
            System.out.println("A operação não é permitida !! ");
            System.out.println("Saldo insuficiente");
        }
        return this.getSaldo();
    }

    public float depositar(int conta, float valor) {
        if (true) //numconta numero conta existe/ativa
        {
            this.setSaldo(this.getSaldo() + valor);
            System.out.println("Deposito efectuado , o seu saldo actual é : " + this.getSaldo());
        } else {
            System.out.println("Esta conta não está válida");
        }
        return this.getSaldo();
    }

    public boolean transferir(int origem, int destino, float valor) {
        return true;
    }

}
