package sem3.its.ReReddit.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import sem3.its.ReReddit.persistence.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

}
