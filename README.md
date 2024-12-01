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

## Instalação

Realizando a Instalação

```
> Inicie o seu terminal
> Vá para a pasta onde o arquivo está localizado
> Após chegar na pasta rode o seguinte comando: mvn clean package
> Realize o deploy no WildFly do .war que está localizado na pasta ./target/ddm-<Versão>.war

```

## Documentação da API

#### Endpoints

Todas as requisições são realizadas por meio de protocolos *HTTP* definidos nos controllers:

* /api/auth/login - Caminho para requisições de login de usuários;
* /api/auth/signup - Caminho para requisições de cadastro de usuários;
* /api/user - Caminho para requisições utilizadas no CRUD de usuários;
* /api/address - Caminho para requisições utilizadas no CRUD de endereços;

## Uso/Exemplos

#### Login / SignUp

```http
> POST /api/auth/login
> POST /api/auth/signup
```

#### Usuário

```http
> GET /api/user
> GET /api/user/${email}
> PUT /api/user/${id}
> DELETE /api/user/${id}
```

#### Endereços

```http
> GET /api/address
> GET /api/address/${id}
> POST /api/address
> PUT /api/address/${id}
> DELETE /api/address/${id}
```

## Solução de problemas

Ao realizar a compilação do software são gerados erros de Compilação: cannot find symbol. Esses erros estão sendo causados pela utilização das anotações da biblioteca Lombok, necessário esperar uma atualização do Spring Boot que venha a solucionar o problema, por hora a solução é gerar todos os construtores, getters e setters de forma manual.

## Autores

- [@Eduardo Schiliga](https://github.com/Eduschiliga)
- [@Kauê Querino](https://github.com/kauequerino)
- [@Marcos Gomes](https://github.com/marcos221-Br)
