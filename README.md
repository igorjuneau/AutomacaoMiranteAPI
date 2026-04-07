# 🐾 Dog API Automation Framework

> [!IMPORTANT]
> ### ⚠️ AVISO DE PROPRIEDADE E ÉTICA PROFISSIONAL
> Este repositório é público exclusivamente para fins de **portfólio e avaliação**. 
> A cópia total ou parcial deste código para uso em desafios ou processos seletivos é **estritamente proibida**. 
> O histórico de commits e originalidade é monitorado. Use este material apenas como referência de estudo.

---
Este projeto consiste em uma suíte de testes automatizados para a [Dog API](https://dog.ceo/dog-api/), 
desenvolvida com o objetivo de validar os principais endpoints de raças e imagens. A arquitetura foi 
desenhada seguindo as melhores práticas de Engenharia de Qualidade (QE), garantindo manutenibilidade e 
escalabilidade.

## 🚀 Tecnologias Utilizadas

* **Java 11**: Linguagem base.
* **RestAssured**: Framework para automação de testes de API.
* **Cucumber (BDD)**: Escrita de cenários em Gherkin para melhor legibilidade.
* **JUnit**: Executor de testes e asserções.
* **Maven**: Gerenciamento de dependências e execução do ciclo de vida do projeto.
* **Hamcrest**: Biblioteca para asserções mais fluidas e legíveis.
* **GSON**: Serialização e desserialização de objetos JSON.

## 🏗️ Arquitetura do Projeto

O framework utiliza o padrão **DSL (Domain Specific Language)** e **Page Object adaptado para API**, organizado da seguinte forma:

* `api.client`: Encapsula as requisições HTTP, separando a lógica de negócio da infraestrutura.
* `api.models`: Representação em classes Java (POJOs) dos objetos da API.
* `steps`: Implementação dos passos do Cucumber, conectando o Gherkin à lógica do Client.
* `runner`: Configurações de execução do JUnit e relatórios.
* `setup`: Gerenciamento de propriedades e ambientes (`.properties`).
* `resources/features`: Cenários de teste escritos em português.

## 🛠️ Como Executar os Testes

### Pré-requisitos
* Java JDK 11 ou superior instalado.
* Maven instalado e configurado no PATH.

### Execução via Terminal
Para rodar todos os testes e gerar os relatórios, execute o comando na raiz do projeto:
```bash
mvn clean test




Execução via IDE
Importe o projeto como um projeto Maven.

Navegue até src/test/java/br/com/igorVieira/runner/ApiRunnerTest.java.

Clique com o botão direito e selecione Run 'ApiRunnerTest'.

📊 Relatórios de Execução
Após a execução dos testes, os relatórios detalhados são gerados automaticamente na pasta:
target/cucumber-reports/cucumber.html

⚙️ Diferenciais Implementados
Resiliência de Assertivas: Uso de containsString para validar mensagens de erro, evitando falhas por pequenas mudanças de texto na API.

Clean Code: Remoção de bibliotecas desnecessárias (Selenium) para garantir um projeto leve e focado.

Centralização de Massa: Arquivo de propriedades para troca rápida de baseUri e ambientes.

Desenvolvido por Igor Vieira
