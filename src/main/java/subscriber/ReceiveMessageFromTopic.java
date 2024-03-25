package subscriber;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class ReceiveMessageFromTopic {
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String topicName = "MESSAGE_TOPIC";

    public static void receivingFromQueue() throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic(topicName);
        
        // messageconsumer is used for receiving
        MessageConsumer consumer = session.createConsumer(topic);
        
        session.createDurableSubscriber(topic,"MESSAGE_TOPIC");
        Message message = consumer.receive();

        if (message instanceof TextMessage testMessage) {
            System.out.println("Received the message ' " + testMessage.getText() + "'");
        }
        else
          System.out.println("its not the text message");
    }
}
