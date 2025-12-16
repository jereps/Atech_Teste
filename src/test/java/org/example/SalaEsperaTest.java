package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SalaEsperaTest {

    private static SalaEspera salaEspera = new SalaEspera();

    @Test
    void testValidarTamanhoVerdadeiro() {
        Boolean resultado = salaEspera.validarTamanho(5,List.of(1,4,7,8,10),List.of(18,8,10,10,17));
        assertTrue(resultado, "Valida se Entrada e Saida tem o tamanho de passageiros");
    }

    @Test
    void testValidarTamanhoFalso() {
        Boolean resultado = salaEspera.validarTamanho(4,List.of(),List.of(18,8,10,10,17));
        assertFalse(resultado, "Valida se Entrada e Saida tem o tamanho de passageiros");
    }

    @Test
    void testValidarEntradaOrdenada() {

        Boolean resultado = salaEspera.validarOrdemEntrada(List.of(1,5,7));
        assertTrue(resultado, "Entrada em ordenada");
    }

    @Test
    void testValidarEntradaDesordenada() {

        Boolean resultado = salaEspera.validarOrdemEntrada(List.of(1,5,7,8,6));
        assertFalse(resultado, "Entrada desordenada");
    }

    @Test
    void testValidarSaidaMaiorEntrada() {

        Boolean resultado = salaEspera.validarSaidaMaiorEntrada(List.of(1,4,7,8,10),List.of(18,8,10,10,17));
        assertTrue(resultado, "Saída maior que Entrada");
    }

    @Test
    void testValidarSaidaMenorEntrada() {

        Boolean resultado = salaEspera.validarSaidaMaiorEntrada(List.of(1,4,7,8,10),List.of(18,8,10,10,8));
        assertFalse(resultado, "Entrada maior que Saída");
    }

    @Test
    void testLotacaoMaxima3() {
        Integer resultado = salaEspera.lotacaoMaxima(3,List.of(1,5,7),List.of(9,13,12));
        assertEquals(3,resultado, "Testa lotação Máxima");
    }

    @Test
    void testLotacaoMaxima1() {
        Integer resultado = salaEspera.lotacaoMaxima(4,List.of(1,4,8,10),List.of(3,8,10,17));
        assertEquals(1,resultado, "Testa lotação Máxima");
    }

    @Test
    void testLotacaoMaxima3_() {
        Integer resultado = salaEspera.lotacaoMaxima(5,List.of(1,4,7,8,10),List.of(18,8,10,10,17));
        assertEquals(3,resultado, "Testa lotação Máxima");
    }

    @Test
    void testConverteStringToListaInteger() {
        List<Integer> resultado = salaEspera.converteStringToListaInteger("18 8 10 10");
        assertEquals(List.of(18,8,10,10),resultado , "Testa a conversão de uma String para Lista de Inteiro");
    }

}
