package store.com.retail_store.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.com.retail_store.model.Product;
import store.com.retail_store.repository.ProductRepository;
import store.com.retail_store.service.ProductService;

import java.util.List;


@Service
public class ProductServiceImp implements ProductService {

        @Autowired
        private ProductRepository productRepository;



        public Product createProduct(Product product) {



            return productRepository.save(product);
        }

        public List<Product> getAllProducts() {
            return productRepository.findAll();
        }

        public Product getProductById(Long id) {
            return productRepository.findById(id)
                   // .orElseThrow(() -> new NotFoundException("Product not found with id " + id));
                    .orElseThrow(() -> new IllegalArgumentException());

        }
    }







