# Desafio Spring Boot

## Descrição
A empresa "Sua Avaliação de Casas" precisa ser capaz de calcular os metros quadrados e o custo dos diferentes imóveis 
que possui em sua carteira de clientes.
Para isso, solicita de cada propriedade: um nome, um bairro e a quantidade de cômodos que tem; ao mesmo tempo, cada 
cômodo contém um nome, uma largura e um comprimento.

## Requisitos Implementados

Requisitos funcionais implementados:
* **US-0001:** Calcule o total de metros quadrados de uma propriedade;
* **US-0002:** Indique o valor de uma propriedade com base em seus cômodos e medidas. Lembre-se que os preços por metro quadrado são determinados de acordo com a vizinhança;
* **US-0003:** Determine qual é o maior cômodo;
* **US-0004:** Determinar a quantidade de metros quadrados que tem cada cômodo de uma propriedade.


## Testes implementados

**PropertyServiceTest.java**

* **checkIfPropertySizeIsCorrectTest:** verifica se *PropertyServicegetPropertySize()* retorna o tamanho correto de uma 
  propriedade;
  
**RoomServiceTest.java**

* **checkGetMaxRoomTest:** verifica se *RoomService.getMaxRoom()* retorna a response correta, com o tamanho do maior 
  quarto;
* **checkAllRoomsSize:** verifica se *RoomService.getAllRoomsResponse()* retorna o tamanho correto dos quartos (este 
  teste verifica se soma total do tamanho dos quartos está correta, seria mais confiável comparar um);
  
**DistrictServiceTest.java**

* **checkIfDistrictNotExistsTest:** verifica se *DistrictService.findByName()* retorna uma DistrictNotFoundException 
  quando é informado um nome de um bairro que não existe;
* **checkIfDistrictExistsTest:** verifica se *DistrictService.findByName()* retorna o valor correto de um bairro;
  
**Testes de integração**

* **checkIfPropertySizeIsCorrectTest:** verifica todo o funcionamento da API através de um POST no endpoint 
  "/property/info", comparando por completo, a response retornada e a response esperada;

## Executar

O projeto pode ser executado em uma IDE (de preferência no IntelliJ) ou através do terminal utilizando o comando:

```
mvn spring-boot:run
```

Todos os requisitos foram implementados à partir de um único endpoint (POST):

```
http://localhost:8080/property/info
```

A API também pode ser testada através do Swagger em:

```
http://localhost:8080/swagger-ui.html
```

O modelo de request a ser aceito, pode ser visualizado abaixo:
```json
{
  "prop_district": "string",
  "prop_name": "string",
  "rooms": [
    {
      "room_length": 0,
      "room_name": "string",
      "room_width": 0
    }
  ] 
}
```

Já o modelo de response:
```json
{
  "prop_name": "string",
  "rooms": [
    {
      "room_name": "string",
      "room_size": 0
    }
  ],
  "prop_district": "string",
  "district_value": 0,
  "prop_size": 0,
  "prop_value": 0,
  "max_room_name": "string",
  "max_room_size": 0
}
```

Descrição dos atributos calculados:
* **district_value:** valor por metro quadrado (referente ao bairro);
* **prop_size:** tamanho total da propriedade (soma do tamanho de todos os quartos);
* **prop_value:** valor de acordo com o tamanho da propriedade e o preço por metro quadrado em um bairro;
* **max_room_name:** nome do maior quarto;
* **max_room_size:** tamanho do maior quarto.

**Bairros ja cadastrados:**

Nome | Valor por metro quadrado
--- | --- | 
Bom Retiro | R$ 40.00|
Caravelas | R$ 5.00 |
Cariru | R$ 65.00 | 
Castelo | R$ 100.00 | 
Imbaubas | R$ 75.00 | 

## Restrições de validação

* O **nome de uma propriedade** não pode ser vazio ou nulo, deve começar com letra maiúscula, e deve ter no máximo 
  30 caracteres;
* O **nome do bairro** não pode ser vazio ou nulo, deve ter no máximo 45 caracteres e deve existir na base de dados 
  (em *com.mercadolivre.DesafioQuality.repositories.DistrictRepository*);
* O **nome do quarto** não pode ser vazio ou nulo, deve começar com letra maiúscula, e deve ter no máximo
  30 caracteres;
* A **largura do cômodo** não pode ser nula e deve valer no mínimo 1 e no maximo 25;
* O **comprimento do cômodo** não pode ser nula e deve valer no mínimo 1 e no maximo 33;
