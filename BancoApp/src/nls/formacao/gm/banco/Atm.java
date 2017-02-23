/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nls.formacao.gm.banco;

import java.util.Date;

/**
 *
 * @author Formacao
 */
public class Atm {
   private String id ;
   private float saldo ;
   private Date data ;

    public Atm() {
        
    }

    public Atm(Date data) {
        this.data = data ;
    }
         
   public  float carregar()
   {
       return 0.0f ;
   }
   
    public boolean descarregar()
   {
        return true ;
   }
   
   public float levantar(int lev , float lev1)
   {   
       return  0 ;
   }
   
   public float depositar(int dep1 , float dep2)
   {
       return 0;
   }
   
    public boolean transferir(int tra , int tra1 , float tra2)
   {
       return false;
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
        
        {
          this.saldo = saldo;  
        }
        
        this.saldo = saldo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
   
    public static void main(String[] args) {
        //String cont = new Conta(1, "CC", (float) 5.0,"");
       
    }
}
