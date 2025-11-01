import observer.*;
import strategy.*;
import builder.*;
import adapter.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NewsAgency agency = new NewsAgency();
        Map<String, RegularSubscriber> subscriberMap = new HashMap<>();

        while (true) {
            System.out.println("\nNews portal menu");
            System.out.println("1) Add subscriber");
            System.out.println("2) Remove subscriber");
            System.out.println("3) Change notification type");
            System.out.println("4) Publish custom news");
            System.out.println("5) Import external news");
            System.out.println("6) List subscribers");
            System.out.println("7) Exit");
            System.out.print("Choose: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input, try again.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter subscriber name: ");
                    String name = scanner.nextLine();

                    System.out.println("Select notification type:");
                    System.out.println("1. Email");
                    System.out.println("2. SMS");
                    System.out.println("3. Push");
                    int type = Integer.parseInt(scanner.nextLine());

                    NotificationStrategy strategy = switch (type) {
                        case 2 -> new SMSNotification();
                        case 3 -> new PushNotification();
                        default -> new EmailNotification();
                    };

                    RegularSubscriber sub = new RegularSubscriber(name, strategy);
                    subscriberMap.put(name, sub);
                    agency.addSubscriber(sub);
                }

                case 2 -> {
                    System.out.print("Enter subscriber name to remove: ");
                    String name = scanner.nextLine();
                    RegularSubscriber sub = subscriberMap.remove(name);
                    if (sub != null) {
                        agency.removeSubscriber(sub);
                    } else {
                        System.out.println("Subscriber not found.");
                    }
                }

                case 3 -> {
                    System.out.print("Enter subscriber name: ");
                    String name = scanner.nextLine();
                    RegularSubscriber sub = subscriberMap.get(name);
                    if (sub == null) {
                        System.out.println("Subscriber not found");
                        break;
                    }

                    System.out.println("Select new notification type:");
                    System.out.println("1. Email");
                    System.out.println("2. SMS");
                    System.out.println("3. Push");
                    int type = Integer.parseInt(scanner.nextLine());

                    NotificationStrategy strategy = switch (type) {
                        case 2 -> new SMSNotification();
                        case 3 -> new PushNotification();
                        default -> new EmailNotification();
                    };
                    sub.setNotificationStrategy(strategy);
                    System.out.println(name + "'s notification type updated");
                }

                case 4 -> {
                    System.out.print("Enter news title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter content: ");
                    String content = scanner.nextLine();

                    News news = new News.Builder(title)
                            .setCategory(category)
                            .setAuthor(author)
                            .setContent(content)
                            .build();

                    agency.publishNews(news);
                }

                case 5 -> {
                    ExternalFeed externalFeed = new ExternalFeed();
                    NewsSource externalNews = new ExternalNewsAdapter(externalFeed);

                    News importedNews = new News.Builder(externalNews.getHeadline())
                            .setCategory(externalNews.getCategory())
                            .setAuthor("External Source")
                            .build();

                    agency.publishNews(importedNews);
                }

                case 6 -> {
                    if (subscriberMap.isEmpty()) {
                        System.out.println("No subscribers found");
                    } else {
                        System.out.println("Current Subscribers:");
                        for (String name : subscriberMap.keySet()) {
                            System.out.println("- " + name);
                        }
                    }
                }

                case 0 -> {
                    System.out.println("Exiting news portal-");
                    return;
                }

                default -> System.out.println("Invalid choice");
            }
        }
    }
}
