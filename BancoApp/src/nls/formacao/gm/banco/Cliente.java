/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nls.formacao.gm.banco;

/**
 *
 * @author Formação
 */
public class Cliente {
    public String nomeCli;
    public String moradaCli;
    private int idCli;
    private int cartaoCli;
    private int pinCli;

    public Cliente(String nomeCli, String moradaCli, int idCli, int cartaoCli, int pinCli) { //contrutor
        this.nomeCli = "";
        this.moradaCli = "";
        this.idCli = 0;
        this.cartaoCli = 0;
        this.pinCli = 0;
    }

    public String getNomeCli() {
        return nomeCli;
    }

    public void setNomeCli(String nomeCli) {
        this.nomeCli = nomeCli;
    }

    public String getMoradaCli() {
        return moradaCli;
    }

    public void setMoradaCli(String moradaCli) {
        this.moradaCli = moradaCli;
    }

    public int getIdCli() {
        return idCli;
    }

    public void setIdCli(int idCli) {
        this.idCli = idCli;
    }

    public int getCartaoCli() {
        return cartaoCli;
    }

    public void setCartaoCli(int cartaoCli) {
        this.cartaoCli = cartaoCli;
    }

    public int getPinCli() {
        return pinCli;
    }

    public void setPinCli(int pinCli) {
        this.pinCli = pinCli;
    }

    public boolean validarPin(int iPin)  {
        if (this.pinCli == iPin) {
            return true;
        }
        else
            return false;
    }
    
    public float levantarAtm (String iAtm, int iConta, float iValor) {
        return 0.0f;
    }
    
    public float depositarAtm (String iAtm, int iConta, float iValor) {
        return 0.0f;
    }
    
}
