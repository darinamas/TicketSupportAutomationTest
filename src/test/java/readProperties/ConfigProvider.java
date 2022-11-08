package readProperties;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig(); //interface

    static Config readConfig(){
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("application.conf");
    }

    String URL = readConfig().getString("url");

    String ADMIN_LOGIN = readConfig().getString("usersParams.admin.login");
    String ADMIN_PASSWORD = readConfig().getString("usersParams.admin.password");

    String DEMO_LOGIN = readConfig().getString("usersParams.demo.login");
    String DEMO_PASSWORD = readConfig().getString("usersParams.demo.password");

    String INVALID_LOGIN = readConfig().getString("usersParams.invalid.login");
    String INVALID_PASSWORD = readConfig().getString("usersParams.invalid.password");
}
