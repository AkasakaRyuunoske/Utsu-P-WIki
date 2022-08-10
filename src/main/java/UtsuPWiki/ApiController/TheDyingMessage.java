package UtsuPWiki.ApiController;

import lombok.extern.log4j.Log4j2;
import netscape.javascript.JSObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
@RestController
public class TheDyingMessage {

    @PostMapping("/test-call")
    public String theDyingMessageReceiver(HttpServletRequest request, HttpServletResponse response){

        log.info(request.getAttribute("user") + " attribute finishes");
        log.info(request.getHeader("user") + " data header finishes");

        response.setStatus(200);
        response.setHeader("data", "sosi");

        log.info("{theDyingMessage\":\"sanman de fuantei na kono sekai\"}");

        return "{\"theDyingMessage\":\"sanman de fuantei na kono sekai\"}";
    }
}
