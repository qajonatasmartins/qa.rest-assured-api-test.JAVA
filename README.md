# Projeto de testes automatizado da API report

## Sobre o serviço

O projeto do report service está localizado no repositório [report]()

## Sobre a API

A documentação dos endpoints da API testada está no [Swagger]()

## Frameworks e tecnologias

- [Java](): Java é uma linguagem de programação orientada a objetos;
- [Maven](): O apache Maven ou Maven é uma ferramenta de automação de compilação;
- [RestAssured](): Rest-Assured é uma ferramenta que foi desenvolvida para facilitar a criação de testes automatizados para APIS Rest. Está oferece suporte para validar protocolo HTTP e requisições em JSON;
- [AssertJ](): AssertJ fornece um rico conjunto de asserções, mensagens de erro verdadeiramente úteis, melhora a legibilidade do código e é projetado para ser super fácil de usar em seu IDE favorito;
- [TestNG](): TestNG é uma estrutura de teste para a linguagem java;
- [Lombok](): O lombok é uma biblioteca java focada em produtividade e redução de código boilerplate que por meio de anotações adicionadas ao nosso código ensinamos o compilador (maven ou gradler) durante o processo de compilação a criar código java. Desta forma não é necessário Construtores, Getters e Setters no projeto;
- [Allure](): Allure Framework é uma ferramenta de relatório da web, mas que não só mostra uma representação muito concisa do que foi testado em um formulário de relatório da web, mas permite que todos os participantes do processo de desenvolvimento extraiam o máximo de informações úteis da execução diária de testes.

## Hierarquia Azzure (GIT)

- Master --> Branch principal do projeto;
- Demais branchs --> Branches de desenvolvimento de novas features ou refactoring de código.

## Nomenclatura de branchs

- Features: feature/"Num Card Jira". Exemplo: feature/KE-1234
- Correções: fix/"Num Card Jira". Exemplo: feature/TS-1234

## Suites

### Contract

Valida o response(JsonSchema) obtido de cada retorndo do endpoint(Status 200,400 e etc...)

### Functional

Valida a regra de negócio dos endpoints.

### HealthCheck

Realiza se a API está no ar.

## Json Schema - Obtendo o jsonSchema

Para a suite de 'contract' é necessário que seja gerado o jsonSchema para validar se o response está de acordo com o especificado no Swagger e evitar de ter mais atributos do que necessário.

No exemplo abaixo é utilizado o endpoint do serviço 'report service':

**1 ª Passo:** Acesse o [endpoint]() e copie o response da requisição

```
{
  "list": [
    {
      "id": 0,
      "name": "string"
    }
  ],
  "page": 0
}
```
**2 ª Passo:** Acesse o [site json-to-schema-convert](https://www.liquid-technologies.com/online-json-to-schema-converter);
**3 ª Passo:** Cole o response no campo `Sample JSON Document`;
**4 ª Passo:** Clique na opção `Não sou um robô`;
**5 ª Passo:** Clique em `Generate Schema`;
**6 ª Passo:** Copie o `Infered JSON Schema`;
```
{
  "$schema": "http://json-schema.org/draft-04/schema#",
  "type": "object",
  "properties": {
    "list": {
      "type": "array",
      "items": [
        {
          "type": "object",
          "properties": {
            "id": {
              "type": "integer"
            },
            "name": {
              "type": "string"
            }
          },
          "additionalProperties": true,
          "required": [
            "id",
            "name"
          ]
        }
      ],
      "additionalItems": true
    },
    "page": {
      "type": "integer"
    }
  },
  "additionalProperties": true,
  "required": [
    "list",
    "page"
  ]
}
```
**7 ª Passo:** Dentro do diretório `Test >> Resources >> jsonSchema`, crie um arquivo .json e cole o `Infered JSON Schema` do passo anterior;

## Configurações do ambiente

As variáveis e o ambiente são declarados no arquivo `configuration<ambiente>.properties` localizado no diretório `scr >> test >> resources`.

## Configuração do Intellij

- Acessar as configurações de debug em: `Run >> Edit configurations...`;
- Expandir o menu lateral de `Templates`;
- Localizar o template do `TestNG`;
- Editar a configuração e na opção `Vm Options` adicionar `-Dtestng.dtd.http=true`


## Pré-Requisitos

- Instalar o Apache Maven;
    - **How to install Maven on Windows:**
        - **1 ªPasso:** Acesse o site do [Maven](http://maven.apache.org/download.cgi) e faça o download do arquivo `apache-maven-x.x.x-bin.zip`;
        - **2 ªPasso:** Extraia o arquivo dentro do `C:`;
        - **3 ªPasso:** Acesse as 'Variáveis de Ambiente' do windows e crie a váriavel `MAVEN_HOME` com o valor `C:\apache-maven-x.x.x`(pasta do diretório do maven);
        - **4 ªPasso:** Nas variáveis de ambiente ainda, add no `PATH` o caminho `C:\apache-maven-x.x.x\bin`
        - **5 ªPasso:** Abra o terminal do windows e execute o comando `mvn −version`
      - **How to install Maven on Linux:**
        - **1 ªPasso:** Acesse o site do [Maven](http://maven.apache.org/download.cgi) e faça o download do arquivo `apache-maven-x.x.x-bin.tar.gz`;
        - **2 ªPasso:** Abra o Terminal e altere o diretório para a pasta `/opt` com o comando `cd /opt`;
        - **3 ªPasso:** Extraia o arquivo apache-maven no diretório opt. Execute o comando `sudo tar -xvzf ~/Downloads/apache-maven-3.6.3-bin.tar.gz`;
        - **4 ªPasso:** Edite o arquivo `/etc/environment` e adicione a seguinte variável de ambiente: `M2_HOME="/opt/apache-maven-3.6.3"`
        - **5 ªPasso:** Além disso, anexe o diretório bin à variável PATH: `/opt/apache-maven-3.6.3/bin`;
        - **6 ªPasso:** Atualize o comando mvn: `sudo update-alternatives --install "/usr/bin/mvn" "mvn" "/opt/apache-maven-3.6.3/bin/mvn" 0` e `sudo update-alternatives --set mvn /opt/apache-maven-3.6.3/bin/mvn`;
        - **7 ªPasso:** Adicione a conclusão do Bash ao mvn para que você possa concluir comandos complexos do Maven pressionando Tab várias vezes executando o comando `sudo wget https://raw.github.com/dimaj/maven-bash-completion/master/bash_completion.bash --output-document /etc/bash_completion.d/mvn`;
        - **8 ªPasso:** Efetue logout e login no computador e verifique a versão do Maven usando o seguinte comando: `mvn --version`.
- Instalar o Java 8 (Java 8 - JDK);
        - Configure o jdk nas variáveis de ambiente no windows.[Exemplo](https://confluence.atlassian.com/confbr1/configurando-a-variavel-java_home-no-windows-933709538.html)
- Instalar o GIT na maquina;
- IDE Intellij;
- Allure Reports;

## Execução local

- Fazer o git clone do projeto;
- Executar o comando `mvn install`;
- Agora execute o comando `mvn test -Papi-tests -DtestSuite=$TEST_SUITE -Denvironment=$ENVIRONMENT -Dtestng.dtd.http=true`
    - `mvn test -Papi-tests -DtestSuite=HealthCheckSuite -Denvironment=HML -Dtestng.dtd.http=true`
    - `mvn test -Papi-tests -DtestSuite=ContractSuite -Denvironment=HML -Dtestng.dtd.http=true`
    - `mvn test -Papi-tests -DtestSuite=FunctionalSuite -Denvironment=HML -Dtestng.dtd.http=true`
    
## Executando o relatório allure

Execute o comando `allure serve target/allure-results` no terminal para abrir o relatório do allure reports.