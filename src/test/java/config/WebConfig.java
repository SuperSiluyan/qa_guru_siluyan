package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${type}.properties"
})

public interface WebConfig extends Config{

    @Key("browserName")
    @DefaultValue("chrome")
    String getbrowserName();


    @Key("baseUrl")
    String getbaseUrl();


    @Key("browserVersion")
    String getbrowserVersion();



    @Key("selenoidAddress")
    String getselenoidAddress();

}
