package property;

import env.CurrentEnvironmentLoader;
import org.aeonbits.owner.ConfigFactory;

public class PropertyLoader {

    public static PropertyLoader propertyLoader(){
        return new PropertyLoader();
    }

    /**
     * O método getProperty() pega o env retornado pelo método setProperty() e
     * retorna para a class GeneralConfig.
     * @return - Retorna o env do ambiente a ser executado o test.
     */
    public GeneralConfig getProperty(){
        ConfigFactory.setProperty("env", CurrentEnvironmentLoader.get());
        return ConfigFactory.create(GeneralConfig.class);
    }
}
