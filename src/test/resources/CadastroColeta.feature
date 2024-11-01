# language: pt
Funcionalidade: Cadastro de nova coleta
  Como usuário da API
  Quero cadastrar uma nova coleta
  Para que o registro seja salvo corretamente no sistema

  Cenário: Cadastro bem-sucedido de coleta
    Dado que eu tenha os seguintes dados da coleta:
      | campo       | valor        |
      | cepFinal   | 12345-678     |
      | cepInicial | 87654-321     |
      | dataColeta | 30/10/2024    |
    Quando eu enviar a requisição para o endpoint "/coletas/gravar" de cadastro de coletas
    Então o status code da resposta deve ser: 201