package sem3.its.ReReddit.persistence;


import sem3.its.ReReddit.persistence.entity.UserEntity;

import java.util.List;

public interface UserRepository {
    UserEntity save(UserEntity entity);

    List<UserEntity> findAll();

    UserEntity findById(Long id);


}
