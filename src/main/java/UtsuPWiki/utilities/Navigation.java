package UtsuPWiki.utilities;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;

@Log4j2
@Component
public class Navigation {
    public static void addLocations(Model model, HttpServletRequest request){
        //extract host, in locale it will be => "localhost:8080"
        String host = request.getHeader("Host" );

        //every request contains it's referer from where protocol is determined (http:// or https://)
        //this part will be extracted and take pos [0]
        String[] protocol = request.getHeader("Referer").split("(?<=://)");

        //then useless part is replaced by "home" which is root page
        String locations_to_split = request.getRequestURL().toString().replace(protocol[0] + host,"home");
        String[] split_currentLocation = locations_to_split.split("(?<=/)");

        ArrayList<String> currentLocation = new ArrayList<>(Arrays.asList(split_currentLocation));

        model.addAttribute("location", currentLocation);
    }
}
