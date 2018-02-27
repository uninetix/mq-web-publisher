package pl.ciszemar.mqwebpublisher.util;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQXAConnectionFactory;
import org.springframework.stereotype.Component;

import javax.jms.*;

@Component
public class MQUtilNew {

    private String uri = null;
    private String queueName = null;

    public ConnectionFactory createConnectionFactory() {
        if(uri == null) return null;
        return new ActiveMQConnectionFactory(
                uri
        );
    }

    public XAConnectionFactory createXAConnectionFactory() {
        if(uri == null) return null;
        return new ActiveMQXAConnectionFactory(
                uri
        );
    }

    public QueueConnectionFactory createQueueConnectionFactory() {
        if(uri == null) return null;
        return new ActiveMQConnectionFactory(
                uri
        );
    }

    public XAQueueConnectionFactory createXAQueueConnectionFactory() {
        if(uri == null) return null;
        return new ActiveMQXAConnectionFactory(
                uri
        );
    }

    public TopicConnectionFactory createTopicConnectionFactory() {
        if(uri == null) return null;
        return new ActiveMQConnectionFactory(
                uri
        );
    }

    public XATopicConnectionFactory createXATopicConnectionFactory() {
        if(uri == null) return null;
        return new ActiveMQXAConnectionFactory(
                uri
        );
    }

    public Connection createConnection(ConnectionFactory cf)
            throws JMSException {
        return cf.createConnection();
    }

    public XAConnection createXAConnection(XAConnectionFactory cf)
            throws JMSException {
        return cf.createXAConnection();
    }


    public QueueConnection createQueueConnection(QueueConnectionFactory cf)
            throws JMSException {
        return cf.createQueueConnection();
    }

    public XAQueueConnection createXAQueueConnection(XAQueueConnectionFactory cf)
            throws JMSException {
        return cf.createXAQueueConnection();
    }


    public TopicConnection createTopicConnection(TopicConnectionFactory cf)
            throws JMSException {
        return cf.createTopicConnection();
    }

    public XATopicConnection createXATopicConnection(XATopicConnectionFactory cf)
            throws JMSException {
        return cf.createXATopicConnection();
    }

    public Session createSession(Connection connection)
            throws JMSException {

        return connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    }

    public XASession createXASession(XAConnection connection)
            throws JMSException {
        return connection.createXASession();
    }

    public QueueSession createQueueSession(QueueConnection connection)
            throws JMSException {
        return connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
    }

    public XAQueueSession createXAQueueSession(XAQueueConnection connection)
            throws JMSException {
        return connection.createXAQueueSession();
    }

    public TopicSession createTopicSession(TopicConnection connection)
            throws JMSException {
        return connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
    }

    public XATopicSession createXATopicSession(XATopicConnection connection)
            throws JMSException {
        return connection.createXATopicSession();
    }

    public void sendTextMessageToQueue(String message,
                                       Session session) throws JMSException {
        if(queueName != null) {
            Queue queue = session.createQueue(queueName);
            TextMessage msg = session.createTextMessage(message);
            MessageProducer messageProducer = session.createProducer(queue);
            messageProducer.send(msg);
        }
    }

    public void sendTextMessageToQueue(String message,
                                       QueueSession session) throws JMSException {
        if(queueName != null) {
            Queue queue = session.createQueue(queueName);
            TextMessage msg = session.createTextMessage(message);
            QueueSender messageProducer = session.createSender(queue);
            messageProducer.send(msg);
        }
    }

    public void sendTextMessageToTopic(String message,
                                       Session session) throws JMSException {
        Topic queue = session.createTopic("TEST_TOPIC");
        TextMessage msg = session.createTextMessage(message);
        MessageProducer messageProducer = session.createProducer(queue);
        messageProducer.setPriority(9); //0-9, 9 highest, all messages, 4 default
        messageProducer.setTimeToLive(10000); //milliseconds, 0 default - doesn't expire
        messageProducer.send(msg,
                DeliveryMode.NON_PERSISTENT,
                9, // Per message
                20000); //Per message
    }


    public MessageConsumer consumeFromQueue(Session session,
                                            String destination,
                                            MessageListener messageListener)
            throws JMSException {
        Queue queue = session.createQueue(destination);
        MessageConsumer consumer = session.createConsumer(queue);
        consumer.setMessageListener(messageListener);
        return consumer;
    }

    public TopicSubscriber consumeFromTopic(Session session,
                                            String destination,
                                            MessageListener messageListener)
            throws JMSException {
        Topic topic = session.createTopic(destination);
        TopicSubscriber consumer = session.createDurableSubscriber(topic,
                "test-subscription");
        consumer.setMessageListener(messageListener);
        return consumer;
    }

    public void mqSendMessage(String uri, String queue, String body) {
        this.uri = uri;
        this.queueName = queue;
        ConnectionFactory cf = createConnectionFactory();
        Connection conn = null;
        try {
            conn = createConnection(cf);
            Session session = createSession(conn);
            sendTextMessageToQueue(body, session);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
