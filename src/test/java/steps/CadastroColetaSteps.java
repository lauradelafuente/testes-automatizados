package steps;

import com.networknt.schema.ValidationMessage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import org.junit.Assert;
import services.CadastroColetaService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CadastroColetaSteps {
    CadastroColetaService cadastroColetaService = new CadastroColetaService();

    @Dado("que eu tenha os seguintes dados da coleta:")
    public void queEuTenhaOsSeguintesDadosDaColeta(DataTable dataTable) {

        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            cadastroColetaService.setFieldsColeta(columns.get("campo"), columns.get("valor"));
        }
    }

    @Quando("eu enviar a requisição para o endpoint {string} de cadastro de coletas")
    public void euEnviarARequisiçãoParaOEndpointDeCadastroDeColetas(String endPoint) {
        cadastroColetaService.createColeta(endPoint);
    }

    @Então("o status code da resposta deve ser: {int}")
    public void oStatusCodeDaRespostaDeveSer(int statusCode) {
        Assert.assertEquals(statusCode, cadastroColetaService.response.getStatusCode());
    }

    @E("o corpo de resposta de erro da API deve retornar a mensagem {string}")
    public void oCorpoDeRespostaDeErroDaAPIDeveRetornarAMensagem(String mensagemEsperada) {
        String mensagemRecebida = cadastroColetaService.response.getBody().asString(); // Obtém o corpo da resposta
        Assert.assertTrue(mensagemRecebida.contains(mensagemEsperada)); // Verifica se a mensagem esperada está presente
    }
    @E("que o arquivo de contrato de coleta esperado é o {string}")
    public void queOArquivoDeContratoDeColetaEsperadoÉO(String contract) throws IOException {
        cadastroColetaService.setContract(contract);
    }

    @Então("a resposta da requisição deve estar em conformidade com o contrato de coleta selecionado")
    public void aRespostaDaRequisiçãoDeveEstarEmConformidadeComOContratoDeColetaSelecionado() throws IOException {
        Set<ValidationMessage> validateResponse = cadastroColetaService.validateResponseAgainstSchema();
        Assert.assertTrue("O contrato está inválido. Erros encontrados: " + validateResponse, validateResponse.isEmpty());
    }
}


