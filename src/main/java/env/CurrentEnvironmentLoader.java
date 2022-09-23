package env;

import org.apache.commons.lang3.StringUtils;
import static java.lang.System.getProperty;

public class CurrentEnvironmentLoader {

    private CurrentEnvironmentLoader(){}

    public static String get(){
        String env = getProperty("env");
        if(StringUtils.isEmpty(env)){
            System.setProperty("env", "hml");
            return "hml";
        } else {
            return env;
        }

    }
}
