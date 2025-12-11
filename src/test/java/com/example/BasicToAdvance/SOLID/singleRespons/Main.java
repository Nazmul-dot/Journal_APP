package com.example.BasicToAdvance.SOLID.singleRespons;

// Domain Objects
class User {
    void save() {
        System.out.println("User saved to database");
    }
}

class Mail {
    void send() {
        System.out.println("Email sent successfully");
    }
}

// ✅ GOOD - Each class has single responsibility
class UserService {
    public void saveUser(User user) {
        // Could add validation, logging, transaction management
        System.out.println("Starting user save process...");
        user.save();
        System.out.println("User save completed");
    }
}

class EmailService {
    public void sendMail(Mail mail) {
        // Could add email validation, retry logic, logging
        System.out.println("Preparing to send email...");
        mail.send();
        System.out.println("Email delivery initiated");
    }
}

// ❌ BAD - Mixed responsibilities
class MixedService {
    public void saveUser(User user) {
        user.save();
    }

    public void sendMail(Mail mail) {
        mail.send();
    }
}

public class Main {
    public static void main(String[] args) {
        User user = new User();
        Mail mail = new Mail();

        // ❌ Bad approach - violates SRP
        MixedService mixedService = new MixedService();
        mixedService.saveUser(user);
        mixedService.sendMail(mail);

        System.out.println("\n--- Following SRP ---\n");

        // ✅ Good approach - follows SRP
        UserService userService = new UserService();
        EmailService emailService = new EmailService();

        userService.saveUser(user);
        emailService.sendMail(mail);
    }
}