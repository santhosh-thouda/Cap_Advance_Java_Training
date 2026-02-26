package com.fintech.app;

import com.fintech.service.BankingService;

import java.math.BigDecimal;
import java.util.Scanner;

public class FintechApp {

    private static BankingService service = new BankingService();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n========= FINTECH BANKING SYSTEM =========");
            System.out.println("1. Create Customer + Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Issue Card");
            System.out.println("6. Check Balance");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    createCustomer();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    transfer();
                    break;

                case 5:
                    issueCard();
                    break;

                case 6:
                    checkBalance();
                    break;

                case 7:
                    System.out.println("👋 Exiting...");
                    System.exit(0);

                default:
                    System.out.println("❌ Invalid choice");
            }
        }
    }

    // -------------------------------------------------
    private static void createCustomer() {

        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        BigDecimal balance = sc.nextBigDecimal();

        service.createCustomerWithAccount(
                name, email, phone, accNo, balance
        );
    }

    // -------------------------------------------------
    private static void deposit() {

        System.out.print("Enter Account ID: ");
        Long id = sc.nextLong();

        System.out.print("Enter Amount: ");
        BigDecimal amount = sc.nextBigDecimal();

        service.deposit(id, amount);
    }

    // -------------------------------------------------
    private static void withdraw() {

        System.out.print("Enter Account ID: ");
        Long id = sc.nextLong();

        System.out.print("Enter Amount: ");
        BigDecimal amount = sc.nextBigDecimal();

        service.withdraw(id, amount);
    }

    // -------------------------------------------------
    private static void transfer() {

        System.out.print("From Account ID: ");
        Long from = sc.nextLong();

        System.out.print("To Account ID: ");
        Long to = sc.nextLong();

        System.out.print("Enter Amount: ");
        BigDecimal amount = sc.nextBigDecimal();

        service.transfer(from, to, amount);
    }

    // -------------------------------------------------
    private static void issueCard() {

        System.out.print("Enter Account ID: ");
        Long id = sc.nextLong();

        sc.nextLine();

        System.out.print("Enter Card Number: ");
        String cardNo = sc.nextLine();

        System.out.print("Enter Card Type (DEBIT/CREDIT): ");
        String type = sc.nextLine();

        service.issueCard(id, cardNo, type);
    }

    // -------------------------------------------------
    private static void checkBalance() {

        System.out.print("Enter Account ID: ");
        Long id = sc.nextLong();

        service.checkBalance(id);
    }
}