package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SalaEspera salaEspera = new SalaEspera();


        do {
            System.out.println();
            System.out.printf("Digite a quantidade de Passageiros: ");
            Integer quantidadePassageiros = Integer.parseInt(scanner.nextLine());
            System.out.printf("Digite uma lista com a Entrada de cada passageiro, separado por espaço: ");
            String entrada = scanner.nextLine();
            System.out.printf("Digite uma lista com a Saída de cada passageiro, separado por espaço: ");
            String saida = scanner.nextLine();
            System.out.println(salaEspera.calcularLotacao(quantidadePassageiros, entrada, saida));
            System.out.println();
            System.out.printf("Digite S para Fechar, ou C para continuar : ");

        } while (!scanner.nextLine().toUpperCase().equals("S"));

    }
}


