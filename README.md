# Documentação de Projeto

Este documento fornece informações sobre a API de Desenvolvimento para Dispositivos Móveis, um sistema desenvolvido para a compra, venda e locação de veículos.

## Requisitos

Antes de instalar o software, verifique se o seu sistema atende aos seguintes requisitos:

```
Dependências:
    > Java JDK-23
    > MySql
    > Maven
    > WildFly
```

## Configuração

Antes de realizar a instação é necessário configurar o software:

```
./src/main/resources/application.properties
    > server.port=<porta>
    > spring.datasource.url=jdbc:mysql://<ip>:<porta>/<banco>
    > spring.datasource.username=<usuário>
    > spring.datasource.password=<senha>
    > security.jwt.secret-key=<secret-key JWT>
```

## Instalação

Realizando a Instalação

```
> Inicie o seu terminal
> Vá para a pasta onde o arquivo está localizado
> Após chegar na pasta rode o seguinte comando: mvn clean package
> Realize o deploy no WildFly do .war que está localizado na pasta ./target/ddm-<Versão>.war

```

## Documentação da API

#### Swagger

```
http://<ip>:<port>/swagger-ui/index.html#/
```

## Solução de problemas

Ao realizar a compilação do software são gerados erros de Compilação: cannot find symbol. Esses erros estão sendo causados pela utilização das anotações da biblioteca Lombok, necessário esperar uma atualização do Spring Boot que venha a solucionar o problema, por hora a solução é gerar todos os construtores, getters e setters de forma manual.

## Autores

- [@Eduardo Schiliga](https://github.com/Eduschiliga)
- [@Kauê Querino](https://github.com/kauequerino)
- [@Marcos Gomes](https://github.com/marcos221-Br)
