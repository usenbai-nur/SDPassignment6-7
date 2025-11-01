package strategy;

import builder.News;

public class SMSNotification implements NotificationStrategy {
    @Override
    public void send(News news,  String userName) {
        System.out.println("SMS " +  userName + " received " + news.getTitle());
    }
}
