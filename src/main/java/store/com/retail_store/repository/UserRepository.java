package store.com.retail_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import store.com.retail_store.model.User;







public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    //void save(User user);
}
