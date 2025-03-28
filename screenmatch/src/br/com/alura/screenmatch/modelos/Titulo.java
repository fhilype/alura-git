package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.excecoes.ConversaoAnoException;

public class Titulo implements Comparable<Titulo> {
    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb tituloOmdb) {
        this.nome = tituloOmdb.title();
        if (tituloOmdb.year().length() > 4) {
            throw new ConversaoAnoException("Erro ao converter Ano, mais de 4 caracteres");
        }
        this.anoDeLancamento = Integer.valueOf(tituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(tituloOmdb.runtime().split(" ")[0]);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }


    public void exibeFichaTecnica() {
        System.out.println(this.nome);
        System.out.println(this.anoDeLancamento);
        System.out.println(this.incluidoNoPlano);
        System.out.println(this.somaDasAvaliacoes);
        System.out.println(this.totalDeAvaliacoes);
        System.out.println(this.duracaoEmMinutos);
    }

    public void avaliacao(double nota) {
        this.somaDasAvaliacoes += nota;
        this.totalDeAvaliacoes++;
    }

    public double pegaMedia() {
        return this.somaDasAvaliacoes / this.totalDeAvaliacoes;
    }

    @Override
    public String toString() {
        return "Titulo (" +
                "nome='" + nome + '\'' +
                ", anoDeLancamento=" + anoDeLancamento +
//                ", incluidoNoPlano=" + incluidoNoPlano +
//                ", somaDasAvaliacoes=" + somaDasAvaliacoes +
//                ", totalDeAvaliacoes=" + totalDeAvaliacoes +
                ", duracaoEmMinutos=" + duracaoEmMinutos +
                ')';
    }

    @Override
    public int compareTo(Titulo titulo) {
        return this.getNome().compareTo(titulo.getNome());
    }
}
