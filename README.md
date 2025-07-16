# 💱 Conversor de Moedas

Este projeto foi desenvolvido como parte do Challenge da **Alura + Oracle Next Education** e tem como objetivo proporcionar uma experiência prática no desenvolvimento de aplicações Java. A proposta consiste em criar um **Conversor de Moedas** utilizando uma **API de taxas de câmbio em tempo real**, além de aplicar boas práticas como logs e interface gráfica com JavaFX.

<img width="451" height="180" alt="image" src="https://github.com/user-attachments/assets/bb58f5c9-bfc1-41b7-a901-7f077337de72" />


---

##  Funcionalidades

-  Interface gráfica com JavaFX
-  Conversão de moedas com dados em tempo real
-  Suporte a **todas as moedas disponíveis** na API
-  Sistema de logs que registra cada conversão realizada




## Explicação do que foi feito

Pra economizar as 1500 chamadas gratuitas mensais da API ExchangeRate-API, implementei uma estratégia de otimização:

Uma única chamada por execução: Toda vez que o projeto é executado, ele faz apenas uma única chamada à API. Por padrão, a requisição é feita pra https://v6.exchangerate-api.com/v6/#1/latest/USD, que retorna as taxas de câmbio de todas as moedas em relação ao dólar americano (USD). Isso evita a necessidade de várias chamadas pra cada conversão individual.

Organização dos dados: A resposta da API, que já vem com todas as moedas, é organizada e guardada em um HashMap. As chaves do HashMap são os símbolos das moedas (tipo "BRL", "EUR") e os valores são suas taxas de câmbio em USD. Isso facilita e acelera muito a busca por valores específicos de moedas no sistema, já que não precisamos chamar a API de novo pra pegar as taxas.

Cálculo da conversão: Pra pegar o valor atual de uma moeda em relação a outra, o sistema usa os valores que já foram obtidos na primeira e única chamada à API. Por exemplo, se a API retorna que 1 USD equivale a X BRL, e você quer saber quanto 1 BRL vale em USD, o sistema faz o cálculo dividindo 1 pelo valor X (taxa de BRL em relação a USD) obtido do HashMap. Dessa forma, pra converter um valor, a taxa é aplicada diretamente ou através de uma divisão simples, utilizando apenas os dados carregados inicialmente.



## 📋 Requisitos

- Java **21** instalado
- Conexão com a internet
- Uma conta gratuita no [ExchangeRate API](https://www.exchangerate-api.com/) para obter sua chave de API

---

## ⚙️ Como executar

1.  **Clone o repositório:**

    ```bash
    git clone [https://github.com/seu-usuario/conversor-moedas.git](https://github.com/seu-usuario/conversor-moedas.git)
    cd conversor-moedas
    ```

2.  **Configure a variável de ambiente (`API_KEY`):**

    Para que o sistema funcione corretamente, você precisará fornecer sua chave da API do ExchangeRate-API através de uma variável de ambiente chamada `API_KEY`. Você pode fazer isso de duas maneiras principais:

    * **Usando um arquivo `.env` (Recomendado):**

        Crie um novo arquivo na raiz do seu projeto (na mesma pasta onde está o `pom.xml` ou `build.gradle`, se houver) chamado **`.env`**. Dentro deste arquivo, adicione a seguinte linha:

        ```
        API_KEY="sua_chave_de_api_aqui"
        ```

        Substitua `"sua_chave_de_api_aqui"` pela sua chave real da API. Certifique-se de que o nome do arquivo seja exatamente `.env` (com o ponto na frente).

    * **Configurando diretamente no IntelliJ IDEA:**

        Se você estiver usando o IntelliJ IDEA, pode configurar a variável de ambiente diretamente nas configurações de execução:

        1.  Vá em **"Run"** (Executar) > **"Edit Configurations..."** (Editar Configurações...).
        2.  Encontre a configuração de execução principal do seu projeto (geralmente sob "Application" ou "Maven/Gradle" se você a configurou).
        3.  No painel direito, procure o campo **"Environment variables"** (Variáveis de ambiente).
        4.  Clique no botão **"..."** ao lado do campo.
        5.  Na janela que se abre, clique no botão **"+"** para adicionar uma nova variável.
        6.  No campo **"Name"** (Nome), digite `API_KEY`.
        7.  No campo **"Value"** (Valor), insira sua chave da API.
        8.  Clique em **"OK"** para fechar as janelas e salvar as configurações.

