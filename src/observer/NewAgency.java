package observer;

import builder.News;
import java.util.ArrayList;
import java.util.List;

public class NewAgency {
    private List<Subscriber> subscribers = new ArrayList<>();
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
        System.out.println("New subscriber added" +  subscriber.getName());
    }
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
        System.out.println("subscriber removed" +  subscriber.getName());
    }
    public void publishNews(News news){
        System.out.println("publishing News" + news.getTitle());
        notifySubscribers(news);
    }
    private void notifySubscribers(News news){
        for (Subscriber subscriber : subscribers) {
            subscriber.update(news);
        }
    }
}
