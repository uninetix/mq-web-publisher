package pl.ciszemar.mqwebpublisher.register;

import pl.ciszemar.mqwebpublisher.model.RegisterForm;

import javax.jms.JMSException;

public interface Register {
    public void sendRegisterForm(RegisterForm registerForm) throws JMSException;
}
