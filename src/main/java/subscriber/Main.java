package subscriber;

import javax.jms.JMSException;

public class Main {
    public static void main(String[] args) throws JMSException {
        ReceiveMessageFromTopic.receivingFromQueue();
    }
}