package pl.ciszemar.mqwebpublisher.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.ciszemar.mqwebpublisher.model.RegisterForm;
import pl.ciszemar.mqwebpublisher.register.Register;

@Component
public class RegisterImpl {

    @Autowired
    Register register;

    public void sendForm(String firstName, String larstName, String city,String birthDate){
        RegisterForm registerForm = new RegisterForm(firstName, larstName, city, birthDate);
        register.sendRegisterForm(registerForm);
    }
}
