package pl.ciszemar.mqwebpublisher.register;

import pl.ciszemar.mqwebpublisher.model.RegisterForm;

import javax.jms.JMSException;
import java.util.List;

public interface Register {
    public void sendRegisterForm(RegisterForm registerForm, int quantity) throws JMSException;

    List<Object> receiveData();
}
