package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SalaEspera {

    public String calcularLotacao(Integer quantidadePassageiros, String entrada, String saida) {
        List entradaList = converteStringToListaInteger(entrada);
        List saidaList = converteStringToListaInteger(saida);

        String resposta = "";
        if(!validarTamanho(quantidadePassageiros,entradaList,saidaList))
            return String.format("Quantidade de Horário de entrada e Saída, está diferente de " +
                    "quantidade de passageiros informado %d",quantidadePassageiros);

        if(!validarSaidaMaiorEntrada(entradaList,saidaList))
            return String.format("Horário de Saída de um dos passageiros esta anterior a sua entrada, " +
                    "favor verificar.");

        if(!validarOrdemEntrada(entradaList))
            return String.format("Horário de Entrada dos passageiros " +
                    "não está na ordem de chegada, " +
                    "favor verificar.");

        resposta = String.format("A lotação Máxima da Sala de Espera foi de: %d pessoas."
                ,lotacaoMaxima(quantidadePassageiros,entradaList,saidaList));

        return resposta;
    }

    public List<Integer> converteStringToListaInteger(String lista) {
        String[] listaArray = lista.split(" ");
        return Arrays.stream(listaArray).map(s -> {
                    try {
                        return Integer.valueOf(s);
                    } catch (NumberFormatException e) {
                        return null;
                    }
                })
                .filter(n -> n != null)
                .collect(Collectors.toList());
    }

    public Boolean validarTamanho(Integer passageiros, List<Integer> Entrada, List<Integer> Saida) {
        return passageiros.compareTo(Entrada.size()) == 0 && passageiros.compareTo(Saida.size()) == 0;
    }

    public Boolean validarOrdemEntrada(List<Integer> Entrada) {
        return IntStream.range(0, Entrada.size() - 1)
                .allMatch(i -> Entrada.get(i).compareTo(Entrada.get(i + 1)) <= 0);
    }

    public Boolean validarSaidaMaiorEntrada(List<Integer> Entrada, List<Integer> Saida) {
        return IntStream.range(0, Entrada.size())
                .allMatch(i -> Entrada.get(i).compareTo(Saida.get(i)) < 0);
    }

    public Integer lotacaoMaxima(Integer passageiros, List<Integer> Entrada, List<Integer> Saida) {
        AtomicInteger total = new AtomicInteger(1);


            IntStream.range(1, Entrada.size())
                    .forEach(i -> {
                        AtomicInteger auxiliar = new AtomicInteger(1);
                        IntStream.range(0, i)
                                .forEach(a -> {
                                    if (Entrada.get(i).compareTo(Saida.get(a)) < 0)
                                        auxiliar.getAndIncrement();
                                });
                        total.updateAndGet(n -> Math.max(n, auxiliar.get()));
                    });

        return total.get();
    }


}
