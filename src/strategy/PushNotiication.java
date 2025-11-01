package strategy;

import builder.News;

public class PushNotiication implements NotificationStrategy {
    @Override
    public void send(News news, String userName) {
        System.out.println("push" +  userName + "received" + news.getTitle());
    }
}
