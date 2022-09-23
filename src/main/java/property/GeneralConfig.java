package property;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:configuration-${env}.properties"})
public interface GeneralConfig extends Config {
    @Key("tangerino.reports.service")
    String urlReportsService();

    @Key("authorization")
    String authorizationAPI();
}
