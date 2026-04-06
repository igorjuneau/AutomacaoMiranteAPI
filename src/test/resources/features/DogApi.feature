#language: pt

@DogApi
Funcionalidade: Gestão de Raças na Dog API

  Contexto:
    Dado que a Dog API está disponível

  Cenário: Consultar lista de todas as raças com sucesso
    Quando eu consulto a lista de todas as raças
    Então o status code deve ser 200
    E a resposta deve conter a estrutura de raças válida
    E a lista não deve estar vazia

  Esquema do Cenário: Validar busca de imagens por raça específica
    Dado que eu escolho a raça "<raca>"
    Quando eu solicito as imagens dessa raça
    Então o status code deve ser 200
    E a lista de imagens deve conter URLs válidas

      Exemplos:
        | raca     |
        | husky    |
        | labrador |
        | beagle   |

  Cenário: Solicitar uma imagem aleatória de um cão
    Quando eu solicito uma imagem aleatória de um cão
    Então o status code deve ser 200
    E o campo "status" deve retornar "success"
    E a mensagem deve conter o link de uma imagem (.jpg, .jpeg ou .png)

  Cenário: Validar erro ao consultar raça inexistente
    Dado que eu escolho a raça "raca_inexistente"
    Quando eu solicito as imagens dessa raça
    Então o status code deve ser 404
    E o campo "status" deve retornar "error"
    E a mensagem de erro deve ser "Breed not found"