package UtsuPWiki.utilities;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
//@Component
public class FancyWritings {

    public void printMotivationalThingOnStartUp(String doPrint) {
        log.info("is allowed to print? " + doPrint);
        if (doPrint.equals("true")) {
            log.info("\n" + "\n" +
                    "\"Воля может и должна быть предметом гордости гораздо больше, нежели талант.\n" +
                    " Если талант — это развитие природных склонностей, \n" +
                    " то твёрдая воля — это ежеминутно одерживаемая победа над инстинктами,\n" +
                    " над влечениями, которые воля обуздывает и подавляет, над препятствиями\n" +
                    " и преградами, которые она осиливает, над всяческими трудностями,\n" +
                    " которые она героически преодолевает. \" (Оноре де Бальзак)\""
                    + "\n");
        }
    }
}
