# TODO-List Acelera ZG

Implementação de uma aplicação TODO List em Java.

## Configuração do Projeto

Certifique-se de ter o JDK 17 instalado em sua máquina. Você também precisará do Maven para compilar e executar o projeto.

## Compilando o Projeto

Para compilar o projeto, execute o seguinte comando no terminal:

```bash
mvn package
```

Isso criará um arquivo JAR `TODO-List-1.0-SNAPSHOT.jar` na pasta `target`.

## Executando o Projeto

Para executar o projeto, use o seguinte comando:

```bash
java -jar ./target/TODO-List-1.0-SNAPSHOT.jar
```

Certifique-se de ter todas as dependências corretamente configuradas no seu ambiente. O projeto depende das seguintes bibliotecas:

- JCalendar 1.4
- Gson 2.10.1

Certifique-se de que essas dependências estejam disponíveis no classpath ao executar o projeto.

## Funcionalidades

- CRD(Criar,ler e deletar) de Tarefas
- Listagem de atividades por categoria, prioridade e status
- Rebalanceamento da ordem das atividades ao inserir uma nova tarefa, considerando a prioridade
---