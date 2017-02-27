/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nls.formacao.gm;

/**
 *
 * @author Formação
 */
public class Lutador {

    private String nome;
    private String nacionalidade;
    private int idade;
    private float altura;
    private float peso;
    private String categoria;
    private int vitorias, derrotas, empates;
    
    /**
     * 
     */
    public Lutador() {
        this.nome = "";
        this.nacionalidade = "";
        this.idade = 0;
        this.altura = 0;
        this.peso = 0;
        this.vitorias = 0;
        this.derrotas = 0;
        this.empates = 0;
    }

    /**
     * Cria um lutador
     * @param nome
     * @param nacionalidade
     * @param idade
     * @param altura
     * @param peso
     * @param vitorias
     * @param derrotas
     * @param empates 
     */
    public Lutador(String nome, String nacionalidade, int idade, float altura, float peso, int vitorias, int derrotas, int empates) {
        this();
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.idade = idade;
        this.altura = altura;
        setPeso(peso);
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.empates = empates;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
        this.setCategoria();
    }

    public String getCategoria() {
        return categoria;
    }

    private void setCategoria() {
        if(this.peso < 52.2){
            this.categoria = "Inválido";
        } else if(this.peso <= 70.3){
            this.categoria = "Leve";
        } else if(this.peso <= 83.9){
            this.categoria = "Médio";
        } else if(this.peso < 120.2){
            this.categoria = "Pesado";
        } else {
            this.categoria = "Inválido";
        }
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public void apresentar() {
        System.out.println("\nLutador");
        System.out.println("-------------------------");
        System.out.println("nome: " + getNome());
        System.out.println("nacionalidade: " + getNacionalidade());
        System.out.println("idade: " + getIdade());
        System.out.println("altura: " +getAltura());
        System.out.println("peso: " + getPeso());
        System.out.println("categoria: " + getCategoria());
        System.out.printf("palmarés (V-E-D): %d-%d-%d\n\n",getVitorias(), getEmpates(), getDerrotas());
    }

    public void status() {
        System.out.printf("Lutador %s, é um peso %s, com o seguinte palmarés : %d vitórias, %d empates e %d derrotas.\n", 
                this.getNome(), this.getCategoria(),this.getVitorias(),this.getEmpates(),this.getDerrotas());
    }

    public void ganharLuta() {
        setVitorias(getVitorias()+1);
    }

    public void perderLuta() {
        this.setDerrotas(getDerrotas()+1);
    }

    public void empatarLuta() {
        this.setEmpates(getEmpates()+1);
    }

    @Override
    public String toString() {
        return "Lutador{" + "nome=" + nome + ", nacionalidade=" + nacionalidade + ", idade=" + idade + ", altura=" + altura + ", peso=" + peso + ", categoria=" + categoria + ", vitorias=" + vitorias + ", derrotas=" + derrotas + ", empates=" + empates + '}';
    }
}
