package com.ecommerce;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EcommerceTest {

    EcommerceService service = new EcommerceService();

    // OneToOne Persist Test
    @Test
    void testOneToOnePersist() {

        Profile profile = new Profile();
        profile.setPhone("9876543210");
        profile.setAddress("Hyderabad");

        User user = new User();
        user.setName("Santhosh");
        user.setEmail("santhosh@gmail.com");
        user.setProfile(profile);

        service.registerUser(user);

        User fetched = service.fetchUser(user.getId());

        assertNotNull(fetched);
        assertNotNull(fetched.getProfile());
        assertEquals("Chennai", fetched.getProfile().getAddress());
    }

    //  OneToMany Persist Test
    @Test
    void testOneToManyPersist() {

        PurchaseOrder o1 = new PurchaseOrder();
        o1.setOrderDate(LocalDate.now());
        o1.setTotalAmount(1000);

        PurchaseOrder o2 = new PurchaseOrder();
        o2.setOrderDate(LocalDate.now());
        o2.setTotalAmount(2000);

        User user = new User();
        user.setName("OrderUser");
        user.setEmail("order@gmail.com");
        user.setOrders(Arrays.asList(o1, o2));

        service.registerUser(user);

        List<PurchaseOrder> orders =
                service.getOrdersByUser(user.getId());

        assertEquals(2, orders.size());
    }

    // ManyToOne Persist Test
    @Test
    void testManyToOnePersist() {

        PurchaseOrder order = new PurchaseOrder();
        order.setOrderDate(LocalDate.now());
        order.setTotalAmount(1500);

        new OrderDAOImpl().saveOrder(order);

        Payment payment = new Payment();
        payment.setMode("Credit Card");
        payment.setAmount(1500);
        payment.setOrder(order);

        service.addPaymentToOrder(payment);

        Payment fetched =
                new PaymentDAOImpl().findPayment(payment.getId());

        assertEquals(1500, fetched.getAmount());
    }

    // DAO Update Test
    @Test
    void testUpdateOrderAmount() {

        PurchaseOrder order = new PurchaseOrder();
        order.setOrderDate(LocalDate.now());
        order.setTotalAmount(3000);

        new OrderDAOImpl().saveOrder(order);

        service.updateOrderAmount(order.getId(), 3000);

        PurchaseOrder updated =
                new OrderDAOImpl().findOrder(order.getId());

        assertEquals(3000, updated.getTotalAmount());
    }

    // DAO Delete Test
    @Test
    void testDeleteUser() {

        User user = new User();
        user.setName("Santhosh");
        user.setEmail("santhosh@gmail.com");

        service.registerUser(user);

        Long id = user.getId();
        service.deleteUser(id);

        User deleted = service.fetchUser(id);

        assertNull(deleted);
    }

    // Service Layer Integration Test
    @Test
    void testFullServiceWorkflow() {

        Profile profile = new Profile();
        profile.setPhone("9999999999");
        profile.setAddress("Bangalore");

        PurchaseOrder order = new PurchaseOrder();
        order.setOrderDate(LocalDate.now());
        order.setTotalAmount(2500);

        User user = new User();
        user.setName("Saurabh");
        user.setEmail("saurabh@gmail.com");
        user.setProfile(profile);
        user.setOrders(Arrays.asList(order));

        service.registerUser(user);

        User fetched = service.fetchUser(user.getId());

        assertNotNull(fetched);
        assertNotNull(fetched.getProfile());
        assertNotNull(fetched.getOrders());
    }
}
