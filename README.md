# 🎫 Event Booking System (CLI Based)

A command-line based Event Booking System developed in Java with MySQL/MariaDB. This system allows users to sign up, log in, create events, and purchase tickets for approved events. An admin panel handles event approvals and rejections to maintain event quality.

---

## 🔧 Tech Stack

- **Language:** Java (CLI-based interface)
- **Database:** MySQL / MariaDB
- **Database Connection:** JDBC

---
## 🗂️ Database Schema

**Database Name:** `EventBooking`

### Tables:
- `user`
- `events`
- `tickets`

---

## 📊 Tables Description

### 1. `user`

| Column   | Data Type | Key     | Description                             |
|----------|-----------|---------|-----------------------------------------|
| userId   | INT       | PK      | Unique identifier for user              |
| name     | VARCHAR   |         | Full name of the user                   |
| username | VARCHAR   | UNIQUE  | Login username                          |
| password | VARCHAR   |         | Login Password                          |
| isAdmin  | TINYINT   |         | 1 = admin, 0 = regular user (Default=0) |

---

### 2. `events`

| Column           | Data Type | Key         | Description                            |
|------------------|-----------|-------------|----------------------------------------|
| eventId          | INT       | PK          | Unique identifier for event            |
| title            | VARCHAR   |             | Event title                            |
| price            | DOUBLE    |             | Ticket price                            |
| availableTickets | INT       |             | Number of tickets available             |
| issuedUserId     | INT       | FK → user   | Creator of the event                    |
| isApproved       | TINYINT   | NULLABLE    | Approval status: 1 = approved, 0 = rejected, NULL = pending |

---

### 3. `tickets`

| Column   | Data Type | Key         | Description                             |
|----------|-----------|-------------|-----------------------------------------|
| ticketNo | INT       | PK          | Unique ticket number                    |
| userId   | INT       | FK → user   | User who booked the ticket              |
| EventID  | INT       | FK → events | Event for which the ticket is booked    |

---

## ✅ Core Features

### 👤 User Features
- Sign up and log in with credentials.
- Create new events with their details.
- View status of created events (Pending, Approved, Rejected).
- Buy tickets for **approved events**.
- View tickets they have purchased.
- View list of their created events with remarks.

### 🛡️ Admin Features
- Admin account is **hardcoded** and initialized directly through the database.
- View all newly created events awaiting approval.
- Approve or reject events submitted by users.
- Approved events become visible to all users for ticket purchase.

---

## ⚠️ Drawbacks / Limitations

While the system works well for learning and simulation purposes, it has several limitations:

- 💰 **No Payment Integration**  
  Events can have ticket prices, but there is no actual payment or transaction system implemented.


- 📅 **No Event Expiry or Scheduling**  
  Events do not have a valid date or expiration system. Outdated events remain listed indefinitely.


- 🗑️ **No Event Deletion or Archiving**  
  Events cannot be deleted or archived by users or admins, which can lead to a cluttered event list.


- ✏️ **No Event Editing Functionality**  
  Users cannot edit or update an event once submitted, even if it's rejected.


- 🔐 **Hardcoded Admin Account**  
  The admin account must be manually added to the database. There’s no interface to manage or create admin users.


- 🔒 **Unencrypted Passwords**
  Passwords are stored as plain text in the database, which poses a security risk.


- 📬 **No Notifications or Feedback**  
  Users receive no notifications when their event is approved or rejected—they must manually check.


- 💻 **Single-user CLI Limitation**  
  The system runs in a command-line interface and does not support concurrent multi-user sessions or persistent logins.


- **Not Optimized for Large User Base**
    - The application logic and database queries are written for small-scale use.
    - It hasn't been stress-tested for concurrent users or high-volume data.


- **No Automated Testing**
    - There are no unit tests or integration tests for any of the modules.


---

> These limitations are acknowledged to encourage future improvements and contributions. If you're interested in helping improve the project, feel free to open a pull request or issue.

---