import java.util.InputMismatchException;
import java.util.Scanner;


public class Principal {

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        ConversorMoedas conversor = new ConversorMoedas();
        int opcao = 0;

        System.out.println("*************************************************");
        System.out.println("Bem-vindo ao Conversor de Moedas!");
        System.out.println("*************************************************");

        do {
            exibirMenu();
            try {
                System.out.print("\nEscolha uma opção: ");
                opcao = leitura.nextInt();
                leitura.nextLine();

                if (opcao == 9) {
                    System.out.println("Programa Encerrado. Obrigado por usar o Conversor de Moedas, Volte Sempre que Precisar!");
                    break;
                }

                if (opcao < 1 || opcao > 8) {
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                    continue;
                }

                System.out.print("Digite o valor que deseja converter: ");
                double valorParaConverter = leitura.nextDouble();
                leitura.nextLine();

                String moedaOrigem = "";
                String moedaDestino = "";
                String simboloMoedaDestino = "";

                switch (opcao) {
                    case 1: // Dólar para Real
                        moedaOrigem = "USD";
                        moedaDestino = "BRL";
                        simboloMoedaDestino = "R$";
                        break;
                    case 2: // Real para Dólar
                        moedaOrigem = "BRL";
                        moedaDestino = "USD";
                        simboloMoedaDestino = "$";
                        break;
                    case 3: // Dólar para Peso Argentino
                        moedaOrigem = "USD";
                        moedaDestino = "ARS";
                        simboloMoedaDestino = "ARS$";
                        break;
                    case 4: // Peso Argentino para Dólar
                        moedaOrigem = "ARS";
                        moedaDestino = "USD";
                        simboloMoedaDestino = "$";
                        break;
                    case 5: // Dólar para Euro
                        moedaOrigem = "USD";
                        moedaDestino = "EUR";
                        simboloMoedaDestino = "€";
                        break;
                    case 6: // Euro para Dólar
                        moedaOrigem = "EUR";
                        moedaDestino = "USD";
                        simboloMoedaDestino = "$";
                        break;
                    case 7: // Dólar para Peso Colombiano
                        moedaOrigem = "USD";
                        moedaDestino = "COP";
                        simboloMoedaDestino = "COP$";
                        break;
                    case 8: // Peso Colombiano para Dólar
                        moedaOrigem = "COP";
                        moedaDestino = "USD";
                        simboloMoedaDestino = "$";
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        continue;
                }

                System.out.println("\nConvertendo " + valorParaConverter + " " + moedaOrigem + " para " + moedaDestino + "...");
                double valorConvertido = conversor.converterValor(valorParaConverter, moedaOrigem, moedaDestino);

                if (valorConvertido != -1) {
                    System.out.printf("Valor convertido: %s %.2f%n", simboloMoedaDestino, valorConvertido);
                } else {
                    System.out.println("Não foi possível realizar a conversão. Verifique as mensagens de erro.");
                }
                System.out.println("-------------------------------------------------");


            } catch (InputMismatchException e) {
                System.err.println("Entrada inválida. Por favor, digite um número para a opção e para o valor.");
                leitura.nextLine();
            } catch (Exception e) {
                System.err.println("Ocorreu um erro inesperado: " + e.getMessage());

            }

        } while (opcao != 9);

        leitura.close();
    }

    public static void exibirMenu() {
        System.out.println("\nOpções de Conversão:");
        System.out.println("1 - Dólar (USD) => Real (BRL)");
        System.out.println("2 - Real (BRL) => Dólar (USD)");
        System.out.println("3 - Dólar (USD) => Peso Argentino (ARS)");
        System.out.println("4 - Peso Argentino (ARS) => Dólar (USD)");
        System.out.println("5 - Dólar (USD) => Euro (EUR)");
        System.out.println("6 - Euro (EUR) => Dólar (USD)");
        System.out.println("7 - Dólar (USD) => Peso Colombiano (COP)");
        System.out.println("8 - Peso Colombiano (COP) => Dólar (USD)");
        System.out.println("9 - Sair");
    }
}