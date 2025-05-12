import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteApi {


    private static final String CHAVE_API = "c1fda63f6016fbfeafa4620f";
    private static final String URL_BASE_API = "https://v6.exchangerate-api.com/v6/";

    public RespostaTaxas buscarTaxaDeCambio(String moedaOrigem, String moedaDestino) throws IOException, InterruptedException {
        String endereco = URL_BASE_API + CHAVE_API + "/pair/" + moedaOrigem + "/" + moedaDestino;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Erro ao chamar a API: " + response.statusCode() + " - " + response.body());
        }

        String json = response.body();

        Gson gson = new Gson();
        return gson.fromJson(json, RespostaTaxas.class);
    }
}