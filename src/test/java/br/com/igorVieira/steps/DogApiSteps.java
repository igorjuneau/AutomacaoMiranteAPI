package br.com.igorVieira.steps;

import br.com.igorVieira.api.client.DogApiClient;
import io.cucumber.java.pt.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Assert;

public class DogApiSteps {

    private Response response;
    private String racaSelecionada;
    private final DogApiClient dogApi = new DogApiClient();

    @Dado("que a Dog API está disponível")
    public void apiDisponivel() {
        dogApi.listarTodasRacas().then().statusCode(200);
    }

    @Quando("eu consulto a lista de todas as raças")
    public void consultarTodasRacas() {
        response = dogApi.listarTodasRacas();
    }

    @Então("o status code deve ser {int}")
    public void validarStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @E("a resposta deve conter a estrutura de raças válida")
    public void validarEstruturaRacas() {
        response.then()
                .body("status", is("success"))
                .body("message", is(notNullValue()));
    }

    @E("a lista não deve estar vazia")
    public void validarListaNaoVazia() {
        int racaCount = response.path("message.size()");
        Assert.assertTrue("A lista de raças está vazia!", racaCount > 0);
    }

    @Dado("que eu escolho a raça {string}")
    public void escolherRaca(String raca) {
        this.racaSelecionada = raca;
    }

    @Quando("eu solicito as imagens dessa raça")
    public void solicitarImagensRaca() {
        response = dogApi.buscarImagensPorRaca(racaSelecionada);
    }

    @E("a lista de imagens deve conter URLs válidas")
    public void validarUrlsImagens() {
        response.then().body("message", everyItem(containsString("http")));
    }

    @Quando("eu solicito uma imagem aleatória de um cão")
    public void solicitarImagemAleatoria() {
        response = dogApi.buscarImagemAleatoria();
    }

    @E("o campo {string} deve retornar {string}")
    public void validarCampoStatus(String campo, String valor) {
        response.then().body(campo, is(valor));
    }

    @E("a mensagem deve conter o link de uma imagem \\(.jpg, .jpeg ou .png)")
    public void validarLinkImagem() {
        String mensagem = response.path("message");
        Assert.assertTrue("O link não parece ser uma imagem válida!",
                mensagem.toLowerCase().matches(".*\\.(jpg|jpeg|png)$"));
    }

    @E("a mensagem de erro deve ser {string}")
    public void validarMensagemErro(String msgErro) {
        response.then().body("message", containsString(msgErro));
    }
}