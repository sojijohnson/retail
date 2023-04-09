package store.com.retail_store.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.com.retail_store.customer.Payment;
import store.com.retail_store.customer.Purchase;
import store.com.retail_store.repository.PaymentRepository;
import store.com.retail_store.service.PaymentService;
import store.com.retail_store.service.PurchaseService;

import java.time.LocalDate;
import java.util.List;


@Service
public class PaymentServiceImp implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }




    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public List<Payment> getMonthlyReport() {
        // get current month and year
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonthValue();

        return paymentRepository.findByYearAndMonth(year, month);
    }

}
