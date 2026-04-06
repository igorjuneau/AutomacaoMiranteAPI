package br.com.igorVieira.setup;

import java.util.Properties;
import java.io.InputStream;

public class SetupTestRunProperties {

    private static Properties prop;

    private static Properties getProperties() {
        if (prop == null) {
            prop = new Properties();
            try (InputStream input = SetupTestRunProperties.class.getClassLoader()
                    .getResourceAsStream("setuptestrun.properties")) {
                if (input == null) {
                    System.out.println("Arquivo setuptestrun.properties não encontrado!");
                } else {
                    prop.load(input);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return prop;
    }

    public static String getBaseUri() {
        return getProperties().getProperty("api.baseUri");
    }

    public static String getAmbiente() {
        return getProperties().getProperty("ambiente");
    }
}