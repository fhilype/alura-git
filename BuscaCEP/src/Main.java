import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Endereco;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String cep = "";
        Scanner scanner = new Scanner(System.in);
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setPrettyPrinting().create();
        List<Endereco> enderecos = new ArrayList<>();
        while (true) {
            System.out.println("CEP: ");
            cep = scanner.nextLine();
            if (cep.equalsIgnoreCase("sair")) {
                break;
            }
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create("http://viacep.com.br/ws/" + cep + "/json/")).build();
            HttpResponse<String> httpResponse = null;
            try {
                httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
                Endereco endereco = gson.fromJson(httpResponse.body(), Endereco.class);
                enderecos.add(endereco);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            FileWriter fileWriter = new FileWriter("enderecos.json");
            fileWriter.write(gson.toJson(enderecos));
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}