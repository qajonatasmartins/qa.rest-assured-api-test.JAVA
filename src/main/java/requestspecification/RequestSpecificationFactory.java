package requestspecification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestSpecificationFactory {
    private RequestSpecificationFactory(){}

    private static RequestSpecBuilder getRequestBuilder(){
        return new RequestSpecBuilder()
                .setConfig(RestAssuredConfig.config()
                .logConfig(LogConfig.logConfig().enablePrettyPrinting(true)
                        .enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL)))
                .setRelaxedHTTPSValidation().setContentType(ContentType.JSON).setAccept(ContentType.JSON)
                .log(LogDetail.ALL);
    }

    /**
     * O método do requestSpecification seta o base URL do serviço
     * @param baseUrlService - Constante BaseUrl do serviço
     * @return - Retorna o baseUrl
     */
      public static RequestSpecification requestSpecification(String baseUrlService){
        return getRequestBuilder().setBaseUri(baseUrlService).build();
    }

    /**
     * Imprime no console o response do request realizado.
     * @return - Retorna o response da requisição
     */
    public static ResponseSpecification responseSpecification(){
          return new ResponseSpecBuilder().log(LogDetail.ALL).build();
    }
}
