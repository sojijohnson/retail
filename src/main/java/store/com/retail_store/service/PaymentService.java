package store.com.retail_store.service;

import store.com.retail_store.model.Payment;

import java.util.List;

public interface PaymentService {

    Payment createPayment(Payment payment);
    List<Payment> getAllPayments();
    List<Payment> getMonthlyReport();
}
