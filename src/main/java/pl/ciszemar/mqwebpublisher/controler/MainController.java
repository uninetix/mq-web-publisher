package pl.ciszemar.mqwebpublisher.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String start() {
        return "start";
    }

    @RequestMapping("/send")
    public String send() {
        return "send";
    }

    @RequestMapping("/recive")
    public String recive() {
        return "recive";
    }
}
