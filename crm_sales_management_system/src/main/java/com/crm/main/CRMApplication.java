package com.crm.main;

import com.crm.config.JPAUtil;
import com.crm.entity.Address;
import com.crm.service.*;

import javax.persistence.EntityManager;
import java.util.*;

public class CRMApplication {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        CustomerService customerService = new CustomerService(em);
        LeadService leadService = new LeadService(em);
        ProductService productService = new ProductService(em);
        OrderService orderService = new OrderService(em);
        TicketService ticketService = new TicketService(em);
        ReportService reportService = new ReportService(em);

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== CRM MENU =====");
            System.out.println("1. Register Customer");
            System.out.println("2. Add Address");
            System.out.println("3. Create Lead");
            System.out.println("4. Assign Lead");
            System.out.println("5. Convert Lead");
            System.out.println("6. Add Product");
            System.out.println("7. Place Order");
            System.out.println("8. Raise Ticket");
            System.out.println("9. View Employee Performance");
            System.out.println("10. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.println("Enter Name:");
                    String name = sc.nextLine();

                    System.out.println("Enter Email:");
                    String email = sc.nextLine();

                    System.out.println("Enter Phone:");
                    String phone = sc.nextLine();

                    customerService.registerCustomer(name, email, phone);
                    break;

                case 2:
                    System.out.println("Enter Customer ID:");
                    Long custId = sc.nextLong();
                    sc.nextLine();

                    Address address = new Address();

                    System.out.println("Enter Street:");
                    address.setStreet(sc.nextLine());

                    System.out.println("Enter City:");
                    address.setCity(sc.nextLine());

                    System.out.println("Enter State:");
                    address.setState(sc.nextLine());

                    System.out.println("Enter ZipCode:");
                    address.setZipCode(sc.nextLine());

                    customerService.addAddressToCustomer(custId, address);
                    break;

                case 3:
                    System.out.println("Enter Lead Name:");
                    String leadName = sc.nextLine();

                    System.out.println("Enter Source:");
                    String source = sc.nextLine();

                    System.out.println("Enter Contact Info:");
                    String contact = sc.nextLine();

                    leadService.createLead(leadName, source, contact);
                    break;

                case 4:
                    System.out.println("Enter Lead ID:");
                    Long leadId = sc.nextLong();

                    System.out.println("Enter Employee ID:");
                    Long empId = sc.nextLong();
                    sc.nextLine();

                    leadService.assignLeadToEmployee(leadId, empId);
                    break;

                case 5:
                    System.out.println("Enter Lead ID to Convert:");
                    Long convertId = sc.nextLong();
                    sc.nextLine();

                    leadService.convertLeadToCustomer(convertId);
                    break;

                case 6:
                    System.out.println("Enter Product Name:");
                    String productName = sc.nextLine();

                    System.out.println("Enter Price:");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    productService.addProduct(productName, price);
                    break;

                case 7:
                    System.out.println("Enter Customer ID:");
                    Long customerId = sc.nextLong();
                    sc.nextLine();

                    System.out.println("Enter Product IDs (comma separated):");
                    String[] ids = sc.nextLine().split(",");

                    List<Long> productIds = new ArrayList<>();
                    for (String id : ids) {
                        productIds.add(Long.parseLong(id.trim()));
                    }

                    orderService.placeOrder(customerId, productIds);
                    break;

                case 8:
                    System.out.println("Enter Order ID:");
                    Long orderId = sc.nextLong();
                    sc.nextLine();

                    System.out.println("Enter Issue Description:");
                    String issue = sc.nextLine();

                    ticketService.raiseTicket(orderId, issue);
                    break;

                case 9:
                    System.out.println("Enter Employee ID:");
                    Long empPerformanceId = sc.nextLong();
                    sc.nextLine();

                    reportService.getEmployeePerformance(empPerformanceId);
                    break;

                case 10:
                    em.close();
                    JPAUtil.close();
                    System.out.println("Application Closed.");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}