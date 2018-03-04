package pl.ciszemar.mqwebpublisher.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
                    @RequestParam(name = "birthDate") String birthDate,
                    @RequestParam(name = "quantity") String quantity)
    {
        register.sendForm(firstName, lastName, city, birthDate, quantity);
        return "Odpowiedz";
    }

    @RequestMapping(value ="/receiveData",method = {RequestMethod.POST})
    public @ResponseBody
    Object receiveData(){
        return register.receiveData();
    }
}
