package steps;

import com.networknt.schema.ValidationMessage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import services.CadastroUsuarioService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CadastroUsuarioSteps {
    CadastroUsuarioService cadastroUsuarioService = new CadastroUsuarioService();

    @Dado("que eu tenha os seguintes dados do usuario:")
    public void queEuTenhaOsSeguintesDadosDoUsuario(List<Map<String, String>> rows) {
        for(Map<String, String> columns : rows) {
            cadastroUsuarioService.setFieldsDelivery(columns.get("campo"), columns.get("valor"));
        }
    }

    @Quando("eu enviar a requisição para o endpoint {string} de cadastro de usuarios")
    public void euEnviarARequisiçãoParaOEndpointDeCadastroDeUsuarios(String endPoint) {
        cadastroUsuarioService.createDelivery(endPoint);
    }

    @Então("o status code da resposta deve ser {int}")
    public void oStatusCodeDaRespostaDeveSer(int statusCode) {
        Assert.assertEquals(statusCode, cadastroUsuarioService.response.statusCode());
    }

    private void setFields(DataTable dataTable, CadastroUsuarioService service) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            service.setFieldsDelivery(columns.get("campo"), columns.get("valor"));
        }
    }

    @E("que o arquivo de contrato esperado é o {string}")
    public void queOArquivoDeContratoEsperadoÉO(String contract) throws IOException {
        cadastroUsuarioService.setContract(contract);
    }

    @Então("a resposta da requisição deve estar em conformidade com o contrato selecionado")
    public void aRespostaDaRequisiçãoDeveEstarEmConformidadeComOContratoSelecionado() throws IOException {
        Set<ValidationMessage> validateResponse = cadastroUsuarioService.validateResponseAgainstSchema();
        System.out.println("Conteúdo da resposta: " + cadastroUsuarioService.response.getBody().asString());
        Assert.assertTrue("O contrato está inválido. Erros encontrados: " + validateResponse, validateResponse.isEmpty());
    }
}

