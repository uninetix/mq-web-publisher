package pl.ciszemar.mqwebpublisher.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.ciszemar.mqwebpublisher.impl.RegisterImpl;

@Controller
@RequestMapping("/api")
public class ApiController {

    @Autowired
    RegisterImpl register;

    @RequestMapping(value ="/sendForm",method = {RequestMethod.POST})
    public @ResponseBody
    Object sendForm(@RequestParam(name = "firstName") String firstName,
                    @RequestParam(name = "lastName") String lastName,
                    @RequestParam(name = "city") String city,
                    @RequestParam(name = "birthDate") String birthDate){
        register.sendForm(firstName, lastName, city, birthDate);
        return "Odpowiedz";
    }
}
