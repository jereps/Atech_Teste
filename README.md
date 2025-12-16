# Atech_Teste
Dando continuidade ao processo seletivo da Atech, para avaliação das habilidades técnicas.

#### Análise do Sistema de Cálculo de Lotação Máxima (SalaEspera)

##### 1. Explicação Técnica do Algoritmo

Objetivo:
O sistema SalaEspera tem como objetivo calcular a lotação máxima de uma sala de espera.
A aplicação foi feita em Java 11, com Maven.

Fluxo principal:
1. Entrada de Dados
   A classe Main utiliza a entrada de dados padrão para receber, os dados informado pelo usuário.
   A quantidade total de passageiros (quantidadePassageiros).
   Uma String contendo os horários de entrada, separados por espaço.
   Uma String contendo os horários de saída, separados por espaço.
   O método calcularLotacao da classe SalaEspera é invocado com esses dados.

2. Conversão e Validação
   converteStringToListaInteger(String lista): Converte a String de horários para uma List<Integer>, tratando exceções de formato (NumberFormatException).
   O método calcularLotacao executa validações de pré-condição na seguinte ordem:
   validarTamanho: Verifica se a quantidade de passageiros informada é igual ao tamanho das listas de entrada e saída.
   validarSaidaMaiorEntrada: Garante que o horário de saída de cada passageiro seja maior que seu horário de entrada.
   validarOrdemEntrada: Assegura que a lista de horários de entrada esteja na ordem de chagada de cada passageiro.

3. Algoritmo de Lotação Máxima
   A lógica opera comparando o horário de entrada de um passageiro com o horário de saída de todos os passageiros anteriores.
   Para cada horário de entrada a partir do segundo.
   Se o horário de entrada do novo passageiro for menor que o horário de saída do passageiro anterior, significa que o passageiro ainda está na sala quando o novo passageiro entra.
   O contador auxiliar é incrementado nessas condições.
   O valor total máximo (total) é atualizado para reter o maior valor encontrado em auxiliar.
   O valor final de total representa a quantidade máxima de passageiros que estiveram na sala simultaneamente.

A cobertura de testes verifica a lógica de negócios:
Validação de tamanho das listas.
Validação da ordem de entrada (pré-requisito para o algoritmo de lotação).
Validação de que a saída ocorre após a entrada.
Casos de teste para a função lotacaoMaxima (com resultados esperados de 1 e 3) e a função de conversão de String para List<Integer>.


##### 2. Explicação para a leitura de uma equipe não técnica

Objetivo:
Este aplicativo é um "Contador de Ocupação Máxima" para a sua sala de espera. O objetivo dele é descobrir qual foi o momento de maior pico de lotação na sala.

1. Como Funciona
   Entrada de Dados: Você fornece a lista dos horários de entrada e a lista dos horários de saída de todos os passageiros.
   Antes de fazer o cálculo, o sistema verifica se os dados fazem sentido:
   Se todos os horários de entrada e saída foram informados corretamente para cada passageiro.
   Se o horário de saída de alguém é sempre depois do seu horário de entrada.
   Se as entradas foram registradas na ordem em que as pessoas chegaram.

2. O Cálculo
   O sistema analisa cada pessoa que entra e, no momento da entrada, ele verifica quantas das pessoas que já estavam na sala ainda não saíram.
   Ele faz isso para cada novo passageiro.
   Se o Passageiro A entra às 10h, e o Passageiro B entra às 11h, e o Passageiro A só sai às 13h, quando o Passageiro B entra, ele vê se o A ainda está lá.
   O sistema armazena a maior quantidade de pessoas que ele encontrou em qualquer um desses momentos de entrada.
   O sistema retorna uma mensagem, como: "A lotação Máxima da Sala de Espera foi de: 3 pessoas." Este número é a lotação máxima de ocupação que a sala atingiu em algum momento.