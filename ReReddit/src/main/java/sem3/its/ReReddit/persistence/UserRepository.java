package sem3.its.ReReddit.persistence;


import sem3.its.ReReddit.persistence.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    UserEntity save(UserEntity entity);

    List<UserEntity> findAll();

    Optional<UserEntity> findById(Long id);

    int count();

    boolean existsByUsername(String username);


}
