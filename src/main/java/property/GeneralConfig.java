package property;

import org.aeonbits.owner.Config;

@Config.Sources({ "classpath:configuration-${env}.properties" })
public interface GeneralConfig extends Config {
    @Key("qa.rest-assured-api-test.JAVA")
    String urlReportsService();

    @Key("authorization")
    String authorizationAPI();
}
