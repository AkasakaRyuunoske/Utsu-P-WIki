package UtsuPWiki.utilities;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Provides exact location to front-end user helping movement between pages.
 *
 * */

@Log4j2
@Component
public class Navigation {

    public static void addLocations(Model model, HttpServletRequest request){

        //extract host, in locale it will be => "localhost:port" (port = 8080 in application.properties for this app)
        String host = request.getHeader("Host" );


        //every request contains it's requested url from where protocol is determined (http:// or https://)
        //this part will be extracted and take pos [0]
        String[] protocol = request.getRequestURL().toString().split("(?<=://)");

        //then useless part is replaced by "home" which is root page
        String locations_to_split = request.getRequestURL().toString().replace(protocol[0] + host,"home");

        //Because all Types start with upper case letter
        locations_to_split = locations_to_split.toLowerCase();

        //locations are split into array
        String[] split_currentLocation = locations_to_split.split("(?<=/)");

        ArrayList<String> currentLocation = new ArrayList<>(Arrays.asList(split_currentLocation));

        //finally list of locations is passed to front-end through Thymeleaf where JS will make
        //every "location" clickable. See navigation.js for more info.
        if(!locations_to_split.contains("error")) {

            model.addAttribute("location", currentLocation);

        } else {

            //attribute value is "home/" and not "home/error" or just "/error" because the objects
            //are still clickable on the Front-End, so it's leads to access /error without error
            model.addAttribute("location", "home/");
        }
    }
}
