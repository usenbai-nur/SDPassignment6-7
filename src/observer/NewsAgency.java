package observer;

import builder.News;
import java.util.ArrayList;
import java.util.List;

public class NewsAgency {
    private List<Subscriber> subscribers = new ArrayList<>();

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
        System.out.println("New subscriber added: " + subscriber.getName());
    }
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
        System.out.println("Subscriber removed: " + subscriber.getName());
    }
    public void publishNews(News news) {
        if (subscribers.isEmpty()) {
            System.out.println("\nNo subscribers to notify. News not sent: " + news.getTitle());
            return;
        }
        System.out.println("\nPublishing news: " + news.getTitle());
        System.out.println("Category: " + news.getCategory());
        System.out.println("Author: " + news.getAuthor());
        notifySubscribers(news);
    }
    private void notifySubscribers(News news) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(news);
        }
    }
    public int getSubscriberCount() {
        return subscribers.size();
    }
}
