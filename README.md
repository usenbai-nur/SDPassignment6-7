#  News Portal – Design Patterns Project

##  Overview
This project is a **Java console application** that simulates a small **News Portal System**.  
It demonstrates how different **Software Design Patterns (SDP)** can work together in a real-world scenario.  

The main idea:  
- A **News Agency** publishes news updates.  
- **Subscribers** automatically receive notifications (Observer pattern).  
- Each subscriber can choose **how** to receive the news (Strategy pattern).  
- The system can import news from an **external source** (Adapter pattern).  
- Each news article is built using the **Builder pattern** for flexibility.  

---

## Implemented Design Patterns

###  **Observer Pattern**
- Used for managing the relationship between the **News Agency** and its **Subscribers**.  
- When new news is published, all registered subscribers are automatically notified.

**Classes:**
- `observer.NewsAgency` – Subject  
- `observer.Subscriber` – Observer Interface  
- `observer.RegularSubscriber` – Concrete Observer  

Strategy Pattern

Used for choosing how each subscriber receives notifications.
Each user can pick between:

- Email

- SMS

- Push Notification

Classes:

- strategy.NotificationStrategy

- strategy.EmailNotification

- strategy.SMSNotification

- strategy.PushNotification

Adapter Pattern

- Used to integrate external news feeds that have a different data format or method names.
- The adapter converts an incompatible interface (ExternalFeed) into one compatible with our system (NewsSource).

Classes:

- adapter.ExternalFeed – external API simulation

- adapter.NewsSource – target interface

- adapter.ExternalNewsAdapter – adapter class

Builder Pattern

- Used to create complex News objects step by step with optional fields.

Class:

- builder.News (with inner Builder class)

- src/
- ├── observer/
- │   ├── NewsAgency.java
- │   ├── Subscriber.java
- │   └── RegularSubscriber.java
- ├── strategy/
- │   ├── NotificationStrategy.java
- │   ├── EmailNotification.java
- │   ├── SMSNotification.java
- │   └── PushNotification.java
- ├── adapter/
- │   ├── NewsSource.java
- │   ├── ExternalNewsAdapter.java
- │   └── ExternalFeed.java
- ├── builder/
- │   └── News.java
- └── Main.java

How It Works (Console Version)

You can manage the news portal directly from the console.

## Available Actions:
Option	Description
- 1	Add subscriber (choose name and notification type)
- 2	Remove subscriber
- 3	Change subscriber’s notification method
- 4	Publish your own news article
- 5	Import random SpaceX news (via Adapter)
- 6	View current subscribers
- 0	Exit program
