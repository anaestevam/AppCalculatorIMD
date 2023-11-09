Aqui está um exemplo de um arquivo README para o seu aplicativo Android:

# Calculadora IMD - Proposta de Avaliação (1ª Unidade)

Este aplicativo Android foi desenvolvido como parte da proposta de avaliação para a disciplina de Programação de Dispositivos Móveis I, da Universidade Federal do Rio Grande do Norte.

## Descrição

O aplicativo "Calculadora IMD" é uma aplicação simples que consiste em uma única Activity contendo dois Fragments. Ele atende aos seguintes requisitos:

1. O aplicativo possui apenas uma Activity, chamada MainActivity, e seu respectivo layout XML.

2. O título "Calculadora IMD" é exibido na parte superior da tela.

3. O aplicativo é escrito em Java e tem um SDK mínimo na API 19 (Android 4.4 - "KitKat").

4. O nome do estudante é exibido na parte interior da tela em ambos os Fragments.

## Fragmento 1 - Calculadora Simples

O primeiro Fragment é uma calculadora simples que permite realizar operações matemáticas básicas. Ele inclui botões para números de 0 a 9, operações de soma, subtração, multiplicação, divisão, um botão "DEL" para exclusão e um botão "IGUAL" para calcular o resultado.

- Caso seja feita uma operação inválida, como divisão por zero, uma mensagem do tipo Toast ou AlertDialog é gerada com o texto "Operação não permitida".

## Fragmento 2 - Calculadora de Notas Acadêmicas

O segundo Fragment é uma calculadora de notas acadêmicas. Ele possui três caixas de texto do tipo EditText para inserir notas numéricas e um botão para realizar o cálculo.

- Se o usuário digitar apenas a primeira nota, o aplicativo calcula as notas mínimas necessárias na segunda e terceira unidade para passar por média (7,0) e por nota (5,0). Por exemplo: "Com 6,0 na 2ª e na 3ª você será aprovado por média e com 3,3 na 2ª e na 3ª você será aprovado por nota".

- Se o usuário digitar a primeira e a segunda nota, o aplicativo calcula a nota necessária na terceira unidade para passar.

- Se o usuário digitar as três notas, o aplicativo calcula a média e informa em um Toast se ele passou ou não na disciplina (7,0 >= Aprovado) (7,0 < e 5,0 >= Aprovado por nota) (5,0 < Reprovado).


**Desenvolvedor: [Ana Luisa Estevam Dantas]**