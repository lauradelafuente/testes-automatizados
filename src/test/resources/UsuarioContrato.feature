# language: pt
Funcionalidade: Validar o contrato ao realizar um cadastro bem-sucedido de usuario
  Como usuario da API
  Quero cadastrar um novo usuario bem-sucedido
  Para que eu consiga validar se o usuario esta conforme o esperado
  Cenario: Validar contrato do cadastro bem-sucedido de usuario
    Dado que eu tenha os seguintes dados do usuario:
      | campo          | valor              |
      | nome           | Ana Silva          |
      | email          | anasilva@email.com |
      | senha          | ana123             |
      | role           | ADMIN              |
    Quando eu enviar a requisição para o endpoint "/usuario/gravar" de cadastro de usuarios
    Então o status code da resposta deve ser 201
    E que o arquivo de contrato esperado é o "Cadastro bem-sucedido de usuario"
    Então a resposta da requisição deve estar em conformidade com o contrato selecionado