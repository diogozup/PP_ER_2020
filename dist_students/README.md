# Recursos PP - Momento de avaliação 2 (Avaliação contínua)

## Javadoc

Documentação que devem seguir para a implementação da API. A utilização destes recursos é obrigatória!

## Exemplo documento JSON (ficheiroJSONExemplo)
Exemplo de documento JSON que a API deverá gerar como resultado do processo de serialização:

```json
{
  "orderId": 1,
  "destination": {
    "address": {
      "country": "country A2",
      "number": 2,
      "stress": "street A2",
      "city": "city A2",
      "state": "state A2"
    },
    "name": "Jane Doe"
  },
  "containers": [
    {
      "volume": 125000,
      "reference": "c1",
      "depth": 50,
      "color": "white",
      "length": 50,
      "colorEdge": "black",
      "items": [
        {
          "reference": "ITEM1",
          "depth": 1,
          "color": "aqua",
          "x": 0,
          "length": 1,
          "y": 0,
          "description": "ITEM1",
          "z": 0,
          "colorEdge": "aqua",
          "height": 1
        },
        {
          "reference": "ITEM2",
          "depth": 2,
          "color": "blue",
          "x": 10,
          "length": 2,
          "y": 0,
          "description": "ITEM1",
          "z": 0,
          "colorEdge": "blue",
          "height": 2
        },
        {
          "reference": "ITEM3",
          "depth": 3,
          "color": "gray",
          "x": 20,
          "length": 3,
          "y": 0,
          "description": "ITEM1",
          "z": 0,
          "colorEdge": "gray",
          "height": 3
        }
      ],
      "height": 50,
      "occupiedVolume": 36
    },
    {
      "volume": 125000,
      "reference": "c2",
      "depth": 50,
      "color": "white",
      "length": 50,
      "colorEdge": "black",
      "items": [
        {
          "reference": "ITEM1",
          "depth": 1,
          "color": "lime",
          "x": 0,
          "length": 1,
          "y": 0,
          "description": "ITEM1",
          "z": 0,
          "colorEdge": "lime",
          "height": 1
        },
        {
          "reference": "ITEM2",
          "depth": 2,
          "color": "maroon",
          "x": 10,
          "length": 2,
          "y": 0,
          "description": "ITEM1",
          "z": 0,
          "colorEdge": "maroon",
          "height": 2
        },
        {
          "reference": "ITEM3",
          "depth": 3,
          "color": "teal",
          "x": 15,
          "length": 3,
          "y": 0,
          "description": "ITEM1",
          "z": 0,
          "colorEdge": "teal",
          "height": 3
        }
      ],
      "height": 50,
      "occupiedVolume": 36
    }
  ],
  "status": "RECEIVED",
  "customer": {
    "address": {
      "country": "country A1",
      "number": 1,
      "stress": "street A1",
      "city": "city A1",
      "state": "state A1"
    },
    "name": "John Doe",
    "id": 1,
    "billingAddress": {
      "country": "country A1",
      "number": 1,
      "stress": "street A1",
      "city": "city A1",
      "state": "state A1"
    }
  }
}
```



## Ficheiro jar (MA02_Resources.jar)
Ficheiro Jar que devem importar num novo projeto. Para além da biblioteca que contém os recursos que devem utilizar no trabalho, é ainda incluída a biblioteca: json-simple-1.1.1, que pode ser utilizada para a manipulação de documentos JSON.

Para importar a biblioteca (MA02_Resources.jar) no seu projeto, deverá selecionar com botão direito do rato a pasta Libraries e selecionar add JAR/Folder. Ver:
[imagem](http://wiki.netbeans.org/wiki/images/b/b7/Adding_jar_AntlrInNetBeansJavaApplication.jpg)

