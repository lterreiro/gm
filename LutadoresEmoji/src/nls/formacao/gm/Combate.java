/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nls.formacao.gm;

import java.util.Random;

/**
 *
 * @author nls.formacao.gm
 */
public class Combate {
    private Lutador adversario1;
    private Lutador adversario2;
    private int rounds;
    private boolean aprovado;
    
public void marcarCombate(Lutador lutador1 , Lutador lutador2) {
    if (lutador1 != lutador2  && 
            lutador1.getCategoria().equals(lutador2.getCategoria())) {
        System.out.println("Combate pode ser marcado");
        this.setAprovado(true);
        this.setAdversario1(lutador1);
        this.setAdversario2(lutador2);
    } else {
        this.setAprovado(false);
        this.setAdversario1 = null;
        this.setAdversario2 = null;
        System.out.println("Combate nao pode ser marcado");
    }
}    
    
public void Combater() {
    if (this.getAprovado()) {
        this.adversario1.apresentar();
        this.adversario2.apresentar();
        
        Random opcao = new Random() ;
        int resultado = opcao.nextInt(3);
        
        System.out.println("========================================");
        
        switch(resultado) {
            case 0:
                System.out.println("Resultado do combate foi um empate !!");
                this.adversario1.empatarLuta();
                this.adversario2.empatarLuta();
                break;
            case 1:
                System.out.println("O vencedor é " + this.adversario1.getNome());
                this.adversario1.ganharLuta();
                this.adversario2.perderLuta();
                break;
            case 2:
                System.out.println("O vencedor é " + this.adversario2.getNome());
                this.adversario2.ganharLuta();
                this.adversario1.perderLuta();
                break;
        }
        System.out.println("====================================");
    }
}

    public Lutador getAdversario1() {
        return adversario1;
    }

    public void setAdversario1(Lutador adversario1) {
        this.adversario1 = adversario1;
    }

    public Lutador getAdversario2() {
        return adversario2;
    }

    public void setAdversario2(Lutador adversario2) {
        this.adversario2 = adversario2;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public boolean getAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

}
