package store.com.retail_store.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.com.retail_store.model.Customer;
import store.com.retail_store.model.Wallet;
import store.com.retail_store.repository.WalletRepository;
import store.com.retail_store.service.WalletService;

import java.time.LocalDate;
import java.util.List;

@Service
public class WalletServiceImp implements WalletService {
    @Autowired
    private WalletRepository walletRepository;

    @Override
    public Wallet createWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public void updateWallet(Wallet wallet) {
        walletRepository.save(wallet);
    }

    @Override
    public Wallet getWalletByCustomer(Customer customer) {
        return walletRepository.findByCustomer(customer);
    }

    @Override
    public void resetCreditLimit() {
        Wallet wall = new Wallet();
        LocalDate now = LocalDate.now();
        int currentMonth = now.getMonthValue();
        if (now.getDayOfMonth() == 1) {
//            // reset the customer's credit limit to zero
//            customer.setCreditLimit(0);
            List<Wallet> wallets = walletRepository.findAll();
            wallets.forEach(wallet -> {
                wallet.setCreditLimit(200);
                wallet.setBalance(200);
                walletRepository.save(wallet);
            });
//        }
//        List<Wallet> wallets = walletRepository.findAll();
//        wallets.forEach(wallet -> {
//            wallet.setCreditLimit(0);
//            walletRepository.save(wallet);
//        });
        }

        // public void resetCreditLimit(Customer customer) {
        //   LocalDate now = LocalDate.now();
        //   int currentMonth = now.getMonthValue();


        //  if (currentMonth != customer.getLastResetMonth()) {
        // reset the credit limit for the customer
//            customer.setCreditLimit(customer.getDefaultCreditLimit());
//            customer.setLastResetMonth(currentMonth);
//            customer.save();
        //  }
        // }

//    public void resetCreditLimit(Customer customer) {
//        // get the current date and check if it is the beginning of the month
//        LocalDate currentDate = LocalDate.now();
//        if (currentDate.getDayOfMonth() == 1) {
//            // reset the customer's credit limit to zero
//            customer.setCreditLimit(0);
//        }
//  }
    }

}
