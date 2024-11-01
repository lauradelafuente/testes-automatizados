package steps;

import com.google.gson.Gson;
import com.networknt.schema.ValidationMessage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import model.ErrorMessageModel;
import org.junit.Assert;
import services.CadastroClienteService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CadastroClienteSteps {
    CadastroClienteService cadastroClienteService = new CadastroClienteService();

    @Dado("que eu tenha os seguintes dados do cliente:")
    public void queEuTenhaOsSeguintesDadosDoCliente(List<Map<String, String>> rows) {
        for (Map<String, String> columns : rows) {
            cadastroClienteService.setFieldsDelivery(columns.get("campo"), columns.get("valor"));
        }
    }

    @Quando("eu enviar a requisição para o endpoint {string} de cadastro de clientes")
    public void euEnviarARequisiçãoParaOEndpointDeCadastroDeClientes(String endPoint) {
        cadastroClienteService.createDelivery(endPoint);
    }

    @Então("o status code da resposta deve ser - {int}")
    public void oStatusCodeDaRespostaDeveSer(int statusCode) {
        Assert.assertEquals(statusCode, cadastroClienteService.response.statusCode());
    }

    @E("que o arquivo de contrato de cliente esperado é o {string}")
    public void queOArquivoDeContratoDeClienteEsperadoÉO(String contract) throws IOException {
        cadastroClienteService.setContract(contract);
    }

    @Então("a resposta da requisição de cliente deve estar em conformidade com o contrato selecionado")
    public void aRespostaDaRequisiçãoDeClienteDeveEstarEmConformidadeComOContratoSelecionado() throws IOException {
        Set<ValidationMessage> validateResponse = cadastroClienteService.validateResponseAgainstSchema();
        System.out.println("Conteúdo da resposta: " + cadastroClienteService.response.getBody().asString());
        Assert.assertTrue("O contrato está inválido. Erros encontrados: " + validateResponse, validateResponse.isEmpty());
    }

    @E("a resposta deve conter a mensagem de erro {string}")
    public void aRespostaDeveConterAMensagemDeErro(String expectedMessage) {
        ErrorMessageModel errorMessage = new Gson().fromJson(cadastroClienteService.response.getBody().asString(), ErrorMessageModel.class);
        Assert.assertEquals(expectedMessage, errorMessage.getMessage());
    }

    @Então("o status code da resposta deve ser = {int}")
    public void oStatusCodeDaRespostaDeveSerIgual(int statusCode) {
        Assert.assertEquals(statusCode, cadastroClienteService.response.statusCode());
    }
}


