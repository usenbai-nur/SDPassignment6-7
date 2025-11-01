package strategy;

import builder.News;

public class EmailNotification implements NotificationStrategy {
    @Override
    public void send(News news, String userName){
        System.out.println("email " +  userName + " received " + news.getTitle());
    }
}
