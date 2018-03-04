package pl.ciszemar.mqwebpublisher.register;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.ciszemar.mqwebpublisher.model.RegisterForm;
import pl.ciszemar.mqwebpublisher.util.MQUtil;
import pl.ciszemar.mqwebpublisher.util.MQUtilNew;

import java.util.ArrayList;
import java.util.List;

@Component
public class RegisterMQ implements Register {

    private static final String URI = "tcp://localhost:61616";
    private static final String QUEUE_NAME = "TEST.QUE";

    @Autowired
    MQUtil mqUtil;

    @Autowired
    MQUtilNew mqUtilNew;

    @Override
    public void sendRegisterForm(RegisterForm registerForm) {
        Gson gson = new Gson();
        String jsonObject = gson.toJson(registerForm);
        //mqUtil.mqSendMessage(URI, QUEUE_NAME, jsonObject);
        mqUtilNew.mqSendMessage(URI, QUEUE_NAME, jsonObject);
    }

    @Override
    public List<Object> receiveData() {
        Gson gson = new Gson();
        List<Object> ol = new ArrayList<>();
        ol.add(gson.fromJson(mqUtilNew.mqReceiveMessage(URI, QUEUE_NAME), RegisterForm.class));
        return ol;
    }
}
