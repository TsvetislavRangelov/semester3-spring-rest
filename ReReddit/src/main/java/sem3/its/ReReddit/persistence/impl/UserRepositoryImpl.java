package sem3.its.ReReddit.persistence.impl;

import org.springframework.stereotype.Repository;
import sem3.its.ReReddit.persistence.UserRepository;
import sem3.its.ReReddit.persistence.entity.UserEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static long NEXT_ID = 1;
    private final List<UserEntity> savedUsers;

    public UserRepositoryImpl(){
        this.savedUsers = new ArrayList<>();
    }

    @Override
    public UserEntity save(UserEntity entity){
        entity.setId(NEXT_ID);
        NEXT_ID++;
        this.savedUsers.add(entity);
        return entity;
    }

    @Override
    public List<UserEntity> findAll() {return Collections.unmodifiableList(savedUsers);}

    @Override
    public UserEntity findById(Long id){
        return this.savedUsers
                .stream()
                .filter(userEntity -> Objects.equals(userEntity.getId(), id))
                .findFirst()
                .orElse(null);
    }
}
