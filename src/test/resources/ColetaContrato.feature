# language: pt
Funcionalidade: Validar o contrato ao realizar um cadastro bem-sucedido de coleta
  Como usuario da API
  Quero cadastrar uma nova coleta bem-sucedida
  Para que eu consiga validar se o contrato esta conforme o esperado
  Cenario: Validar contrato do cadastro bem-sucedido de coleta
    Dado que eu tenha os seguintes dados da coleta:
      | campo        | valor         |
      | cepFinal     | 12345-678     |
      | cepInicial   | 87654-321     |
      | dataColeta   | 30/10/2024    |
    Quando eu enviar a requisição para o endpoint "/coletas/gravar" de cadastro de coletas
    Então o status code da resposta deve ser: 201
    E que o arquivo de contrato de coleta esperado é o "Cadastro bem-sucedido de coleta"
    Então a resposta da requisição deve estar em conformidade com o contrato de coleta selecionado