package sem3.its.ReReddit.persistence.impl;

import org.springframework.stereotype.Repository;
import sem3.its.ReReddit.persistence.UserRepository;
import sem3.its.ReReddit.persistence.entity.UserEntity;

import java.util.*;

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
    public Optional<UserEntity> findById(Long id){
        return this.savedUsers
                .stream()
                .filter(userEntity -> Objects.equals(userEntity.getId(), id))
                .findFirst();
    }
    @Override
    public int count(){
        return this.savedUsers.size();
    }
}
