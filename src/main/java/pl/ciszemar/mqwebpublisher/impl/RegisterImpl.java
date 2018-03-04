package pl.ciszemar.mqwebpublisher.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.ciszemar.mqwebpublisher.model.RegisterForm;
import pl.ciszemar.mqwebpublisher.register.Register;

import javax.jms.JMSException;
import java.util.ArrayList;
import java.util.List;

@Component
public class RegisterImpl {

    @Autowired
    Register register;

    public void sendForm(String firstName, String larstName, String city,String birthDate){
        RegisterForm registerForm = new RegisterForm(firstName, larstName, city, birthDate);
        try {
            register.sendRegisterForm(registerForm);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public List<Object> receiveData() {

        List<Object> ol = new ArrayList<>();

        for(Object item : register.receiveData()) {
            ol.add(item);
        }
        //RegisterForm registerForm = (RegisterForm) register.receiveData();

        return ol;
    }
}
