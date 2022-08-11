package UtsuPWiki.ApiController;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
@RestController
public class TheDyingMessage {

    @PostMapping("/test-call")
    public String theDyingMessageReceiver(HttpServletRequest request, HttpServletResponse response){
        log.info("custom header: " + request.getHeader("user"));

        response.setStatus(200);
        response.setHeader("data", "sosi");

        return "{\"theDyingMessage\":\"sanman de fuantei na kono sekai\"}";
    }
}
