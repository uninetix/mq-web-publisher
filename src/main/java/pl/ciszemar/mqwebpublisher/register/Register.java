package pl.ciszemar.mqwebpublisher.register;

import pl.ciszemar.mqwebpublisher.model.RegisterForm;

public interface Register {
    public void sendRegisterForm(RegisterForm registerForm);
}
