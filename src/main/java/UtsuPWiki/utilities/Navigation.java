package UtsuPWiki.utilities;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.ArrayList;

@Log4j2
@Component
public class Navigation {

    public void addLocations(Model model, String location){
        ArrayList<String> newLocation = new ArrayList<>();

        String[] newLocation1 = location.split("(?<=/)");
        for (int i = 0; newLocation1.length > i; i++) {
            log.info("Split #" + i + " result : " + newLocation1[i]);
            newLocation.add(newLocation1[i]);
        }

        log.info("newLocation : " + newLocation);
        log.info("location " + location);
        model.addAttribute("location", newLocation);
    }
}
