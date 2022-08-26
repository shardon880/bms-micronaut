package bms.micronaut;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import io.micronaut.core.annotation.TypeHint;
import lombok.extern.slf4j.Slf4j;
import io.micronaut.runtime.Micronaut;

@Slf4j
@TypeHint(typeNames = {"org.h2.driver", "org.h2.mystore.db.MVTableEngine"})
public class Application {
    public static void main(String[] args) {

       log.info("Simple log statement with inputs {},{} and {}",1,2,3);
        Micronaut.run(Application.class, args);
    }
}
