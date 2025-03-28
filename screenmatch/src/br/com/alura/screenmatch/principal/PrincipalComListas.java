package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme filme1 = new Filme("Filme1", 2000);
        filme1.avaliacao(8);
        filme1.setDuracaoEmMinutos(60);
        filme1.setDiretor("DiretorX");
        filme1.setIncluidoNoPlano(true);

        Filme filme2 = new Filme("Filme2", 2004);
        filme2.avaliacao(9);
        filme2.setDuracaoEmMinutos(60);
        filme2.setDiretor("DiretorX");
        filme2.setIncluidoNoPlano(true);

        var filme3 = new Filme("Filme3", 2003);
        filme3.avaliacao(10);
        filme3.setDuracaoEmMinutos(200);
        filme3.setDiretor("DiretorX");
        filme3.avaliacao(10);

        Serie serie1 = new Serie("Serie1", 2000);
        serie1.avaliacao(9);
        serie1.setIncluidoNoPlano(true);
        serie1.setTemporadas(10);
        serie1.setEpisodiosPorTemporada(10);
        serie1.setMinutosPorEpisodio(40);

        List<Titulo> list = new ArrayList<>();
        list.add(filme1);
        list.add(filme2);
        list.add(filme3);
        list.add(serie1);

        for (Titulo titulo : list) {
            System.out.println(titulo.getNome());
            if (titulo instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificacao: " + filme.getClassificacao());
            }
        }

        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Jacqueline");
        System.out.println("Antes da ordenação: " + buscaPorArtista);
        Collections.sort(buscaPorArtista);
        System.out.println("Depois da ordenação: " + buscaPorArtista);

        Collections.sort(list);
        System.out.println("Titulos ordenados: " + list);

        list.sort(Comparator.comparing(Titulo::getNome));
        list.forEach(titulo -> System.out.println(titulo.getNome()));

        list.stream().filter(titulo -> titulo.getNome().contains("Filme")).forEach(titulo -> System.out.println(titulo.getNome()));
    }
}
