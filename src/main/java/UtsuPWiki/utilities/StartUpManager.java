package UtsuPWiki.utilities;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StartUpManager {
    @Value("${database-helper.populate-database}")
    private boolean doPopulateDatabase;

    @Value("${fancy-writings.do-print}")
    private boolean doPrint;

    @Autowired
    FancyWritings fancyWritings;

    @Autowired
    DatabaseHelper databaseHelper;

    @EventListener(ApplicationReadyEvent.class)
    public void manageStartUp(){
        fancyWritings.printMotivationalThingOnStartUp(doPrint);
        databaseHelper.doSomethingAfterStartup(doPopulateDatabase);

    }
}
