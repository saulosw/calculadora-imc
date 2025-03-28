# Calculadora IMC

## Descrição
Aplicativo Android para cálculo do Índice de Massa Corporal (IMC) que fornece feedback personalizado com base na classificação do resultado.

## Funcionalidades
- Cálculo de IMC a partir de peso e altura
- Suporte para entrada de valores com vírgula ou ponto
- Conversão automática de altura em centímetros para metros
- Classificação do IMC em 6 categorias diferentes:
    - Abaixo do Peso (IMC < 18.5)
    - Peso Normal (IMC entre 18.5 e 24.9)
    - Sobrepeso (IMC entre 25 e 29.9)
    - Obesidade Grau 1 (IMC entre 30 e 34.9)
    - Obesidade Grau 2 (IMC entre 35 e 39.9)
    - Obesidade Grau 3 (IMC ≥ 40)
- Feedback personalizado para cada categoria
- Suporte para modo claro e escuro

## Tecnologias Utilizadas
- Java
- Android SDK
- Material Design Components
- AndroidX

## Como Usar
1. Abra o aplicativo
2. Clique no botão "Calculadora IMC"
3. Insira seu peso em kg
4. Insira sua altura em metros (ou centímetros, o app converterá automaticamente)
5. Clique em "Calcular"
6. Visualize sua classificação e recomendações personalizadas

## Estrutura do Projeto
O aplicativo utiliza uma arquitetura baseada em Activities:
- `MainActivity`: Tela inicial
- `CalculoIMCActivity`: Entrada de dados e cálculo
- Activities específicas para cada classificação de IMC:
    - `AbaixoDoPesoActivity`
    - `PesoNormalActivity`
    - `SobrepesoActivity`
    - `Obesidade1Activity`
    - `Obesidade2Activity`
    - `Obesidade3Activity`

## Requisitos
- Android 5.0 (API 21) ou superior
- Aproximadamente 10MB de espaço livre

## Desenvolvido por
Saulo Pereira de Jesus
24026095
FECAP - Fundação Escola de Comércio Álvares Penteado - Campus Liberdade