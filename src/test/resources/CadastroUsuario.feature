# language: pt
Funcionalidade: Cadastro de novo usuario
  Como usuario da API
  Quero cadastrar um novo usuario
  Para que o registro seja salvo corretamente no sistema
  Cenário: Cadastro bem-sucedido de usuario
    Dado que eu tenha os seguintes dados do usuario:
      | campo          | valor              |
      | nome           | Ana Silva          |
      | email          | anasilva@email.com |
      | senha          | ana123             |
      | role           | ADMIN              |
    Quando eu enviar a requisição para o endpoint "/usuario/gravar" de cadastro de usuarios
    Então o status code da resposta deve ser 201