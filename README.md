# 🎟️ BookMyShow - Concurrency Simulation (Java)

## 📌 About the Project
This is a console-based multiplex ticket booking application built using **Core Java**. The core focus of this project is to demonstrate **Multithreading** and **Thread Synchronization** in a real-world scenario. It simulates a situation where multiple users (threads) attempt to book the exact same movie ticket at the exact same time, and safely handles the "Race Condition" using Java's `synchronized` keyword.

## ⚙️ Key Concepts Implemented
* **Multithreading:** Created separate threads (`UserThread`) to simulate concurrent users.
* **Thread Synchronization:** Used the `synchronized` keyword on the `bookSeat` method to lock the shared resource (Theatre object) and prevent data inconsistency.
* **Object Composition / Dependency Injection:** Passed the shared `Theatre` object to the `UserThread` via its constructor to ensure multiple threads operate on the exact same instance.
* **Core Java Fundamentals:** Object-Oriented Programming (OOP), Static variables, Arrays, Exception Handling (`Thread.sleep()`), and Scanner for dynamic I/O.

## 🚀 Features
1. **View Available Seats:** Checks the static array for unbooked seats.
2. **Book a Seat (Singular):** Normal booking simulation for a single user.
3. **Simulate Concurrent Booking (Clash):** The core feature. Prompts details for two users trying to book the exact same seat. It triggers two threads simultaneously to demonstrate how the locking mechanism grants the seat to the first thread and safely rejects the second.

## 💻 How to Run the Project
1. Make sure you have Java installed on your system.
2. Clone this repository to your local machine.
3. Open your terminal or command prompt.
4. Compile the code:
   ```bash
   javac Main.java
5. Execute the code:
   ```bash
   java Main

