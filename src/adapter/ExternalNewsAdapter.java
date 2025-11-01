package adapter;

public class ExternalNewsAdapter implements NewsSource {
    private ExternalFeed feed;

    public ExternalNewsAdapter(ExternalFeed feed) {
        this.feed = feed;
    }

    @Override
    public String getHeadline() {
        return feed.fetchTitle();
    }

    @Override
    public String getCategory() {
        return feed.fetchTopic();
    }
}
