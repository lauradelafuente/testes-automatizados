# language: pt
Funcionalidade: Validar o contrato ao realizar um cadastro bem-sucedido de cliente
  Como usuario da API
  Quero cadastrar um novo cliente bem-sucedido
  Para que eu consiga validar se o cliente está conforme o esperado
  Cenário: Validar contrato do cadastro bem-sucedido de cliente
    Dado que eu tenha os seguintes dados do cliente:
      | campo     | valor                   |
      | nome      | João da Silva           |
      | cpf       | 12345678900             |
      | cep       | 12345-678               |
      | endereco  | Rua das Flores, 123     |
      | telefone  | 9876543210              |
      | email     | joaodasilva@email.com   |
      | senha     | joao123                 |
    Quando eu enviar a requisição para o endpoint "/cliente/gravar" de cadastro de clientes
    Então o status code da resposta deve ser - 201
    E que o arquivo de contrato de cliente esperado é o "Cadastro bem-sucedido de cliente"
    Então a resposta da requisição de cliente deve estar em conformidade com o contrato selecionado