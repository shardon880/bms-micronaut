package bms.micronaut.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Decoder {
    public static String decode(String encoded){
        byte[] decoded = Base64.getDecoder().decode(encoded);
        return new String(decoded, StandardCharsets.UTF_8);
    }
}
