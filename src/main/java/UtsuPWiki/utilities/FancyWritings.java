package UtsuPWiki.utilities;

import lombok.extern.log4j.Log4j2;

/**
 * Prints some quotes (motivational or just useless).
 * To allow to print and decide what is defined in application.properties.
 *
 * Must not be allowed to print in Production build.
 * */
@Log4j2
public class FancyWritings {

    public void printMotivationalThingOnStartUp(String doPrint) {
        if (doPrint.equals("true")) {
            log.info("\n" + "\n" +
                    "\"Воля может и должна быть предметом гордости гораздо больше, нежели талант.\n" +
                    " Если талант — это развитие природных склонностей, \n" +
                    " то твёрдая воля — это ежеминутно одерживаемая победа над инстинктами,\n" +
                    " над влечениями, которые воля обуздывает и подавляет, над препятствиями\n" +
                    " и преградами, которые она осиливает, над всяческими трудностями,\n" +
                    " которые она героически преодолевает. \" (Оноре де Бальзак)"
                    + "\n");
        }

        if(doPrint.equals("Chaos")) {
            log.info("\n \n" +
                    "\"Distorted by the power of his peers, " +
                    "He accepts his worst enemy: internal chaos.\"(Tempest Double)");
        }

        if (doPrint.equals("Yume?")) {
            log.info("\n \n" +
                    " NEE ANATA WA ITSUMO YUME WO MITE MASU KA?\n" +
                    " OWARI KAKE NO KONO SEKAI DE \n" +
                    " FUSAGA RE TA MICCHI WO HIRAKU MONO NI NARU \n" +
                    " 'MESSEJII' WO DAITAAAAAAA\n");
        }

        if (doPrint.equals("Blaise")) {
            log.info("\n \n" +
                    "\"all humanity's problems stem from mans " +
                    "inability to sit quietly in a room alone\" (Blaise Pascal)");
        }

        if(doPrint.equals("F")){
            log.info("\n \n " +
                    "\"Bakit hindi mo subukan bago mo sabihin na hindi mo kaya\" (A random Girl)");
        }
        
        // Todo add this cringy quote --> one learns when one has to; one learns
        //                                when one needs a way out; one learns at all costs. One stands over oneself with a whip;
        //                                one flays oneself at the slightest opposition.
    }
}
