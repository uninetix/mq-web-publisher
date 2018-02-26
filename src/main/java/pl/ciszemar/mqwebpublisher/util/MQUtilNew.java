package pl.ciszemar.mqwebpublisher.util;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Component;

import javax.jms.*;

@Component
public class MQUtilNew {

    ActiveMQConnectionFactory activeMQConnectionFactory = null;
    Connection connection = null;
    MessageProducer producer = null;
    MessageConsumer messageConsumer = null;
    Destination destination = null;
    Session session = null;

    public void mqSendMessage(String uri, String queueName, String body) {

        mqConfigure(uri, queueName);

        TextMessage message = null;
        try {
            message = session.createTextMessage(body);
            producer.send(message);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    private void mqConfigure(String uri, String queueName) {
        activeMQConnectionFactory = new ActiveMQConnectionFactory(uri);

        try {
            connection = activeMQConnectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue(queueName);
            producer = session.createProducer(destination);
            messageConsumer = session.createConsumer(destination);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
