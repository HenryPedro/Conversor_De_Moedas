package br.com.alura.conversor.principal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        ConverterMoeda menu = new ConverterMoeda();
        menu.exibeMenu();
    }
}
