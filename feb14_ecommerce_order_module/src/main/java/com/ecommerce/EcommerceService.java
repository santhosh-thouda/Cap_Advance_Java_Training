package com.ecommerce;

import java.util.List;

public class EcommerceService {

    private UserDAO userDAO = new UserDAOImpl();
    private OrderDAO orderDAO = new OrderDAOImpl();
    private PaymentDAO paymentDAO = new PaymentDAOImpl();

    //  Register User with Profile
    public void registerUser(User user) {
        userDAO.saveUser(user);
    }

    // Add Multiple Orders to User
    public void addOrdersToUser(User user) {
        userDAO.updateUser(user);
    }

    //  Add Payment to Order
    public void addPaymentToOrder(Payment payment) {
        paymentDAO.savePayment(payment);
    }

    // Fetch User with Orders
    public User fetchUser(Long id) {
        return userDAO.findUser(id);
    }

    // Delete User
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }

    //  Update Order Amount
    public void updateOrderAmount(Long orderId, double newAmount) {
        PurchaseOrder order = orderDAO.findOrder(orderId);
        if (order != null) {
            order.setTotalAmount(newAmount);
            orderDAO.saveOrder(order);
        }
    }

    // Additional helper
    public List<PurchaseOrder> getOrdersByUser(Long userId) {
        return orderDAO.findOrdersByUser(userId);
    }
}
