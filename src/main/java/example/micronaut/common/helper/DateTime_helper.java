package example.micronaut.common.helper;

import java.time.LocalDateTime;

public class DateTime_helper {
    public LocalDateTime getCurrentDate()
    {
        return java.time.LocalDateTime.now();
    }
}
