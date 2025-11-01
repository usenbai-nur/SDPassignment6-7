package observer;

import builder.News;

public interface Subscriber {
    void update(News news);
    String getName();
}
