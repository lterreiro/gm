/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nls.formacao.gm.banco;

/**
 *
 * @author CollerMaster
 */
public class Banco {

    /**
     * @param args the command line arguments
     */
        // TODO code application logic here
        String nome;
        int codigo;
        String morada;
        String telefone;
        float cofre;
        
        public String adicionarATM() {
            return "";
        }        
        public boolean removerATM() {
            return true;
        }
        public int adicionarConta() {
            return 0;
        }
        public boolean removerConta(int conta) {
            return true;
        }
        public int adicionarCliente() {
            return 0;
        }
        public boolean removerCliente(int cliente) {
            return true;
        }
        public void creditar(int conta, float valor) {
            
        }
        public void debitar(int conta, float valor) {
            
        }
        public float carregarATM() {
            return 0;
        }
        public boolean descarregar() {
            return true;
        }        

    public Banco(String nome, int codigo, String morada, String telefone, float cofre) {
        this.nome = nome;
        this.codigo = codigo;
        this.morada = morada;
        this.telefone = telefone;
        this.cofre = cofre;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public float getCofre() {
        return cofre;
    }

    public void setCofre(float cofre) {
        this.cofre = cofre;
    }

}        
    

