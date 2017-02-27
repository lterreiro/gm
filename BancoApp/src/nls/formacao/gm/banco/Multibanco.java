/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nls.formacao.gm.banco;

import java.util.Scanner;

/**
 *
 * @author nls.formacao.JosePinto
 */
public class Multibanco {

    public static void main(String[] args) {

        System.out.println("=================================================");
        Conta c[] = new Conta[5];     //        
        c[0] = new Conta(1, "ordem", 33000.00f, "Banco11");
        c[1] = new Conta(2, "ordem", 15000.00f, "Banco22");
        c[2] = new Conta(3, "ordem", 3000.00f, "Banco33");
        c[3] = new Conta(4, "ordem", 8000.00f, "Banco11");
        c[4] = new Conta(5, "prazo", 50000.00f, "Banco11");
        for (Conta c1 : c) {
            System.out.println("Conta " + c1.getNumero() + "  saldo - " + c1.getSaldo());
        }

        Banco b[] = new Banco[4];
        b[0] = new Banco("Banco11", 1, "Rua 1", "911111111", 1000.00f, c[0]);
        b[1] = new Banco("Banco22", 2, "Rua 2", "911111112", 2000.00f, c[1]);
        b[2] = new Banco("Banco33", 3, "Rua 3", "911111113", 3000.00f, c[2]);
        b[3] = new Banco("Banco44", 4, "Rua 4", "911111114", 3000.00f, c[3]);
        for (Banco b1 : b) {
            System.out.println("Banco - " + b1.getNome() + "  Morada - " + b1.getMorada());
        }

        System.out.println("=================================================");
        Cliente cli[] = new Cliente[3];
        cli[0] = new Cliente("Antonio 1 ", "Rua 1", 1, 1, 1111);
        cli[1] = new Cliente("Paula 2 ", "Rua 2", 2, 2, 2222);
        cli[2] = new Cliente("Marta 3 ", "Rua 3", 3, 3, 3333);
        for (Cliente cli1 : cli) {
            System.out.println("Cliente - " + cli1.getNomeCli() + "  Cartao - " + cli1.getCartaoCli());
        }

        System.out.println("=================================================");
        Atm a[] = new Atm[2];
        a[0] = new Atm("ATM1", 10000.00f, c[0], cli[0], b[0]);
        a[1] = new Atm("ATM2", 21000.00f, c[1], cli[1], b[1]);
        for (Atm a1 : a) {
            System.out.println("ATM - " + a1.getId() + "  Saldo - " + a1.getSaldo());
        }
        int opcao;
        int numcli;
        int numpin;
        int numconta;
        int numconta2;
        float valor;

        System.out.println("##########################################");
        System.out.println("#######  M U L T I B A N C O  ############");
        System.out.println("##########################################");
        System.out.println("");

        Scanner teclado;
        teclado = new Scanner(System.in);

        System.out.println("Insira o codigo de cliente: ");
        numcli = teclado.nextInt();
        if (numcli > cli.length) {
            System.out.println("Cliente invalido");
            return;
        }

        System.out.println("##########################################");
        System.out.println("Insira o codigo PIN :");
        numpin = teclado.nextInt();
        boolean valDados = false;
        valDados = a[numcli - 1].validarCliente(numcli, numpin);

        if (valDados) {
            System.out.println("");
            System.out.println("");

            System.out.println("##########################################");
            System.out.println("Insira o codigo da operacao pretendida : ");
            System.out.println("Levantamento  (1) : ");
            System.out.println("Deposito      (2) : ");
            System.out.println("Transferencia (3) : ");
            System.out.println("");

            opcao = teclado.nextInt();
            //neste momento a como cada cliente so tem uma conta e é igual ao numero de cliente....esta entra sempre por default
            switch (opcao) {
                case 1:
                    numconta = numcli;     //teclado.nextInt();
                    System.out.println("Insira o valor que pretende levantar : ");
                    valor = teclado.nextFloat();
                    if (valor > 200) {
                        System.out.println("Valor maximo permitido por levantamento 200 Euros");
                        break;
                    }
                    a[numconta - 1].levantar(numconta - 1, valor);
                    break;
                case 2:
                    numconta = numcli; //teclado.nextInt();
                    System.out.println("Insira o valor que pretende depositar : ");
                    valor = teclado.nextFloat();
                    a[numconta - 1].depositar(numconta - 1, valor);
                    break;
                case 3: 
                    // neste momento vou garantir que a conta origem pertence ao cliente que
                    // entrou ---default 
                    // mais tarde desenvolve-se para que o mesmo
                    //cliente possa ter mais que uma conta
                    
                    /*
                    System.out.println("Insira o numero da conta origem : ");
                    numconta = teclado.nextInt();
                    */
                    numconta = numcli; //teclado.nextInt();
                    System.out.println("Insira o numero da conta destino : ");
                    numconta2 = teclado.nextInt();
                    System.out.println("Insira o valor que pretende transferir : ");
                    valor = teclado.nextFloat();
                    a[numconta - 1].transferir(numconta - 1, c[numconta2 - 1], valor);
                    break;
                default:
                    System.out.println("Opcao invalida ");
                    break;
            }
        }
        System.out.println("");
        System.out.println("===========================================");
    }
}
