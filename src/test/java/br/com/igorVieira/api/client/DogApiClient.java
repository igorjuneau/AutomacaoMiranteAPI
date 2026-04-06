package br.com.igorVieira.api.client;

import br.com.igorVieira.setup.SetupTestRunProperties;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class DogApiClient {

    private final String BASE_URL = SetupTestRunProperties.getBaseUri();

    public Response listarTodasRacas() {
        return given()
                .when()
                .get(BASE_URL + "/breeds/list/all");
    }

    public Response buscarImagensPorRaca(String raca) {
        return given()
                .pathParam("raca", raca)
                .when()
                .get(BASE_URL + "/breed/{raca}/images");
    }

    public Response buscarImagemAleatoria() {
        return given()
                .when()
                .get(BASE_URL + "/breeds/image/random");
    }
}