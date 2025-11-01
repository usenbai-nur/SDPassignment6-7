package builder;

public class News {
    private String title;
    private String content;
    private String category;
    private String author;

    private News(Builder builder) {
        this.title = builder.title;
        this.content = builder.content;
        this.category = builder.category;
        this.author = builder.author;
    }

    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public String getCategory() {
        return category;
    }
    public String getAuthor() {
        return author;
    }

    public static class Builder {
        private String title;
        private String content;
        private String category;
        private String author;

        public Builder(String title) {
            this.title = title;
        }
        public Builder setContent(String content) {
            this.content = content;
            return this;
        }
        public Builder setCategory(String category) {
            this.category = category;
            return this;
        }
        public Builder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public News build() {
            return new News(this);
        }
    }
}
