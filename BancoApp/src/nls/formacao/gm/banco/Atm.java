/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nls.formacao.gm.banco;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


/**
 *  NOTAS: carregar/descarregar ainda nao percebi bem 
 * 
 * 
 * @author nls/formacao/gm/JosePinto
 */
public class Atm {

    //Atributos 
    private String id;
    private float saldo;
    private Date data;
    private Conta conta;
    private Cliente cliente;
    private Banco banco;

    //Metodos especiais
    public Atm(String id, float saldo, Conta conta, Cliente cliente, Banco banco) {
        this.id = id;
        this.saldo = saldo;
        this.conta = conta;
        this.cliente = cliente;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    //Metodos publicos
    public boolean carregar(float val) {
        this.setSaldo(val);
        return true;
    }

    public boolean descarregar() {
        return false;
    }

    public boolean validarCliente(int cli, int pin) {
        System.out.println("========================================================");
        if (this.cliente.getIdCli() == cli && this.cliente.getPinCli() == pin) {
            System.out.println("Dados corretos");
            System.out.println("Cliente : " + this.cliente.getIdCli() + this.cliente.getNomeCli());
            System.out.println("========================================================");
            return true;
        } else {
            System.out.println("Dados incorretos");
            System.out.println("========================================================");
            System.out.println("");
            return false;
        }
        //System.out.println("Dados corretos");
    }

    public void VerData() {
        Date data = new Date();
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MMMMM/yyyy HH:mm:ss ");
	Locale locale = new Locale("pt", "PT");
        GregorianCalendar calendar = new GregorianCalendar();
        System.out.println("");
        System.out.println("=======================================");
        System.out.println(" Data da transacao ");
        System.out.println(sdf2.format(calendar.getTime()));
        System.out.println("========================================");
        this.setData(data);
    }

    public void levantar(int num, float val) {
        this.VerData();
        //verificar saldo do ATM
        if (val > this.getSaldo() || this.getSaldo() < 5) {
            System.out.println("ATM com levantamento indisponivel");

        } else {
            if (this.conta.encerrada) {
                System.out.println("conta encerrada " + this.conta.getNumero());
            } else {
                if (this.conta.getSaldo() >= val) {
                    this.conta.debitar(val);
                    this.cliente.levantarAtm(this.getId(), num, val);
                    this.setSaldo(this.getSaldo() - val);
                    System.out.println("Operacao efetuado com sucesso");
                    System.out.println("Cliente - " + this.cliente.getNomeCli());
                    System.out.printf("O Saldo da sua conta numero %s , foi actualizado para %.2f euros \n",this.conta.getNumero() , this.conta.getSaldo());
                    //System.out.println("Saldo " + this.getId() + "  : " + this.getSaldo() + " euros");
                    System.out.printf("Saldo : %s , %.2f euros", this.getId() , this.getSaldo());
                } else {
                    System.out.println("Conta sem saldo");
                }
            }
        }
    }

    public void depositar(int num, float val) {
        this.VerData();
        if (!this.conta.encerrada && val > 0) {
            this.conta.creditar(val);
            this.cliente.depositarAtm(this.getId(), num, val);
            this.setSaldo(this.getSaldo() + val);
            System.out.println("Operacao efetuado com sucesso");
            System.out.printf("O Saldo da sua conta numero %s , foi actualizado para %.2f euros \n",this.conta.getNumero() , this.conta.getSaldo());
            System.out.printf("Saldo : %s , %.2f euros", this.getId() , this.getSaldo());
        } else {
            System.out.println("Conta invalida ou valor do deposito invalido");
        }
    }

    public boolean transferir(int contaOrigem, Conta contaDestino, float val) {
        this.VerData();
        if (val > 0) {
            if (contaOrigem != contaDestino.getNumero()) {
                //vamos validar conta origem e o seu saldo
                if (!this.conta.encerrada && this.conta.getSaldo() >= val) {
                    //vamos validar a conta destino
                    if (!contaDestino.encerrada) {
                        contaDestino.creditar(val);
                        this.conta.setSaldo(this.conta.getSaldo() - val);
                        System.out.println(this.getId());
                        System.out.println("Operacao efetuado com sucesso");
                        System.out.println("O Seu novo saldo é de : " + this.conta.getSaldo() + " euros");
                        System.out.println("Saldo da conta " + contaDestino.getNumero() + " é de " + contaDestino.getSaldo() + " euros");
                    } else {
                        System.out.println("Conta destino invalida");
                    }
                } else {
                    System.out.println("Conta origem invalida ou sem saldo");
                }
            } else {
                System.out.println("nao é possivel transferir para a mesma conta");
            }
        } else {
            System.out.println("Valor invalido");
        }
        return true;
    }
}
