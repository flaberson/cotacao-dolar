# cotacao-dolar

Este projeto foi desenvolvido em Quarkus e é uma simples aplicação que vai servir para verificar
a cotação do dolar através de uma data chamada na api que fará uma consulta através
de um RestClient em outra api que retorna as informações

## Excutando a aplicação

Para executar a aplicação com o Docker basta usar o comando:
```shell script
./mvnw clean package -Dquarkus.container-image.build=true -DskipTests
docker-compose up
```

> **_Aplicação:_**  Vai rodar nesta url: http://localhost:8080

## Chamando o serviço

### Curl:
```shell script
curl --location 'http://localhost:8080/cotacao/10-10-2023'
```

### Retorno:
```shell script
{
    "cotacaoCompra": "5.08560",
    "cotacaoVenda": "5.08620",
    "dataHoraCotacao": "2023-10-10 13:11:30.76"
}
```