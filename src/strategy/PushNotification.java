package strategy;

import builder.News;

public class PushNotification implements NotificationStrategy {
    @Override
    public void send(News news, String userName) {
        System.out.println("push " +  userName + " received " + news.getTitle());
    }
}
