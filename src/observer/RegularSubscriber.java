package observer;

import builder.News;
import strategy.NotificationStrategy;

public class RegularSubscriber implements Subscriber {
    private String name;
    private NotificationStrategy strategy;

    public RegularSubscriber(String userName, NotificationStrategy strategy) {
        this.name = userName;
        this.strategy = strategy;
    }
    @Override
    public void update(News news){
        strategy.send(news, name);
    }
    @Override
    public String getName(){
        return name;
    }
    public void setNotificationStrategy(NotificationStrategy strategy){
        this.strategy = strategy;
    }
}
