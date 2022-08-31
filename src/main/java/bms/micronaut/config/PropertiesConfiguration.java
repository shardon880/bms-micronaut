package bms.micronaut.config;

import jakarta.inject.Singleton;

@Singleton
public class PropertiesConfiguration {
    public String getConnectionURL() {
        return "jdbc:postgresql://localhost:5432/mydb";
    }
    public String getUsername(){
        return "postgres";
    }

    public String getPassword(){
        return "hellobuddy";
    }
}


