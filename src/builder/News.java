package builder;

public class News {
    private String title;
    private String content;
    private String author;
    private String category;

    private News(Builder builder){
        this.title=builder.title;
        this.content=builder.content;
        this.author=builder.author;
        this.category=builder.category;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public String getAuthor() {
        return author;
    }
    public String getCategory() {
        return category;
    }

    public static class Builder {
        private String title;
        private String content;
        private String author;
        private String category;

        public Builder (String title) {
            this.title = title;
        }
        public Builder setContent(String content) {
            this.content = content;
            return this;
        }
        public Builder setAuthor(String author) {
            this.author = author;
            return this;
        }
        public Builder setCategory(String category) {
            this.category = category;
            return this;
        }
    }
}
