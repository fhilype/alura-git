package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecoes.ConversaoAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
        while (!busca.equalsIgnoreCase("sair")) {
            System.out.println("Busca por título: ");
            busca = scanner.nextLine();
            if (busca.equalsIgnoreCase("sair")) {
                break;
            }
            try {
                HttpClient httpClient = HttpClient.newHttpClient();
                HttpRequest httpRequest = HttpRequest.newBuilder()
                        .uri(URI.create("http://www.omdbapi.com/?apikey=8bea8be0&t=" + busca.replaceAll(" ", "_"))).build();
                HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

                //Gson gson = new Gson();
                //Titulo titulo = gson.fromJson(httpResponse.body(), Titulo.class);

                TituloOmdb tituloOmdb = gson.fromJson(httpResponse.body(), TituloOmdb.class);
                System.out.println(tituloOmdb);

                Titulo titulo = new Titulo(tituloOmdb);
                titulos.add(titulo);


            } catch (NumberFormatException e) {
                System.out.println("NumberFormatException" + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Verifique o endereço - IllegalArgumentException " + e.getMessage());
            } catch (ConversaoAnoException e) {
                System.out.println("Aconteceu algo errado: " + e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(titulos);

        FileWriter fileWriter = new FileWriter("filmes.json");
        fileWriter.write(gson.toJson(titulos));
        fileWriter.close();
    }
}
