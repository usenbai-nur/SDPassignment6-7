package strategy;

import builder.News;

public interface NotificationStrategy {
    void send(News news, String userName);
}
