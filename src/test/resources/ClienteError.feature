# language: pt
Funcionalidade: Validar o cadastro de cliente com dados inválidos
Como usuário da API
Quero tentar cadastrar um cliente sem fornecer o nome
Para que eu consiga verificar se o sistema retorna a mensagem de erro correta

Cenário: Falha ao cadastrar cliente sem nome
Dado que eu tenha os seguintes dados do cliente:
| campo     | valor                |
| cpf       | 12345678900          |
| cep       | 12345-678            |
| endereco  | Rua das Flores, 123  |
| telefone  | 9876543210           |
| email     | joaodasilva@email.com|
| senha     | joao123              |
Quando eu enviar a requisição para o endpoint "/cliente/gravar" de cadastro de clientes
Então o status code da resposta deve ser = 400
E a resposta deve conter a mensagem de erro "Nome é obrigatório."