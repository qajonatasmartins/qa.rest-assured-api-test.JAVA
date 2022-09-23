package constants;

import static property.PropertyLoader.propertyLoader;

public class EnvironmentConstants {
    public EnvironmentConstants(){}

    public static final String BASE_URL_REPORTS_SERVICE = propertyLoader().getProperty().urlReportsService();
    public static final String AUTHORIZATION = propertyLoader().getProperty().authorizationAPI();

}
