package br.com.alura.conversor.ConsumoAPI;
import br.com.alura.conversor.principal.Moeda;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsomeAPI {
    public static Moeda Consultarmoeda(String primeiraMoeda, String segundaMoeda, String nomeDaMoeda) throws IOException, InterruptedException {

        String API_KEY = "${SET_YOUR_API}";
        String ENDERECO = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + primeiraMoeda + "/" + segundaMoeda;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(ENDERECO))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            return new Gson().fromJson(json, Moeda.class);
        } catch (IOException | InterruptedException | JsonSyntaxException e) {
            throw new RuntimeException("Moeda Inválida");
        }
    }
}



