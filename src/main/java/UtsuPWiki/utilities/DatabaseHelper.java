package UtsuPWiki.utilities;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class DatabaseHelper {
    public void doSomethingAfterStartup(boolean doPopulateDatabase) {
        if (doPopulateDatabase) {
            System.out.println("hello world, I have just started up: " + doPopulateDatabase);
        }
    }


//    public void populateDatabase(){
//        log.info("Boolean value is: " + doPopulateDatabase);
//    }
}
