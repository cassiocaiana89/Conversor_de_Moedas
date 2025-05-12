import java.io.IOException;

public class ConversorMoedas {

    private ClienteApi clienteApi;

    public ConversorMoedas() {
        this.clienteApi = new ClienteApi();
    }

    public double converterValor(double valor, String moedaOrigem, String moedaDestino) {
        try {
            RespostaTaxas resposta = clienteApi.buscarTaxaDeCambio(moedaOrigem, moedaDestino);

            if (resposta != null && "success".equalsIgnoreCase(resposta.result())) {
                double taxaConversao = resposta.conversion_rate();
                return valor * taxaConversao;
            } else {
                System.err.println("Não foi possível obter a taxa de conversão.");
                if (resposta != null) {
                    System.err.println("Resposta da API: " + resposta);
                }
                return -1;
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Erro ao conectar com a API de câmbio: " + e.getMessage());
            return -1;
        } catch (Exception e) {
            System.err.println("Ocorreu um erro inesperado durante a conversão: " + e.getMessage());
            return -1;
        }
    }
}