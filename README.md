# Projeto testes-automatizados

### Inicialização do Projeto

Siga os passos abaixo para inicializar e executar o projeto:

1. **Clonar o Repositório**

   ```bash
   git clone https://github.com/lauradelafuente/testes-automatizados

2. **Construir a Imagem Docker**

Navegue até o diretório do projeto e execute o seguinte comando:

	cd testes-automatizados
	docker build -t testes-automatizados .

3. **Visualizar as Imagens do Docker**

Para verificar se a imagem foi criada com sucesso, execute:
	
	docker images

4. **Executar a Aplicação**

Por fim, execute a aplicação com o seguinte comando:

	docker run --rm -it testes-automatizados


### Execução dos testes

Executar através do botão de inicialização de testes da IDE, sob algo como: "Run 'Scenario: Cenario-que-deseja-executar'

### Execução através do Maven

Após a configuração, você também pode executar os testes automatizados usando o Maven. Executando o seguinte comando:

      mvn test


