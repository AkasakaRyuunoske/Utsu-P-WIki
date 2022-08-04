package UtsuPWiki.utilities;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Arrays;

@Log4j2
@Component
public class Navigation {

    public static void addLocations(Model model, String location){
        String[] newLocation1 = location.split("(?<=/)");

        ArrayList<String> newLocation = new ArrayList<>(Arrays.asList(newLocation1));

        model.addAttribute("location", newLocation);
    }
}
