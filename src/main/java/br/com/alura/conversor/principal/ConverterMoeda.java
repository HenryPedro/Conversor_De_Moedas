package br.com.alura.conversor.principal;

import br.com.alura.conversor.ConsumoAPI.ConsomeAPI;

import java.io.IOException;
import java.util.Scanner;

public class ConverterMoeda extends ConsomeAPI {
    Scanner leitura = new Scanner(System.in);
    ConversorDeMoedas conversorDeMoedas = new ConversorDeMoedas();

    public void exibeMenu() throws IOException, InterruptedException {
        var n = -1;
        while (n != 7) {
            var menu = "\n" + """
                    -------------------------------                
                     1) Dólar -> Real
                     2) Real -> Dólar
                     3) Peso Argentino -> Real
                     4) Dólar -> Peso Argentino
                     5) Peso Colombiano -> Dólar 
                     6) Peso Argentino -> Dólar
                     
                     
                     7) Sair 
                                    
                    ------------------------------- 
                     """;

            System.out.println(menu);
            n = leitura.nextInt();
            leitura.nextLine();

            switch (n) {
                case 1:
                    conversorDeMoeda("USD", "BRL", "Dólar");
                    break;
                case 2:
                    conversorDeMoeda("BRL", "USD", "Real");
                    break;
                case 3:
                    conversorDeMoeda("ARS", "BRL", "Peso Argentino");
                    break;
                case 4:
                    conversorDeMoeda("USD", "ARS", "Dólar");
                    break;
                case 5:
                    conversorDeMoeda("COP", "USD", "Peso Colombiano");
                    break;
                case 6:
                    conversorDeMoeda("ARS", "COP", "Peso Argentino");
                    break;
                case 7:
                    System.out.println("Fechando aplicação... ");
                    break;
            }
        }
    }

    public ConversorDeMoedas conversorDeMoeda(String primeiraMoeda, String segundaMoeda, String nomeDaMoeda) throws IOException, InterruptedException {
        System.out.println(primeiraMoeda + " Será convertida para -> " + segundaMoeda);
        System.out.println("Digite o valor: ");
        double valorDigitado = leitura.nextDouble();
        var moedas = ConverterMoeda.Consultarmoeda(primeiraMoeda, segundaMoeda, nomeDaMoeda);
        var taxaConversor = moedas.Conversor();
        var calculo = valorDigitado * taxaConversor;

        System.out.println("o valor de -> " + valorDigitado + " " + primeiraMoeda + "convertido para " + segundaMoeda + " --> " + calculo);
        return conversorDeMoedas;
    }
}
