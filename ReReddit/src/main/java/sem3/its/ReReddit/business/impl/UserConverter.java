package sem3.its.ReReddit.business.impl;


import sem3.its.ReReddit.domain.User;
import sem3.its.ReReddit.persistence.entity.UserEntity;

import java.util.Collections;

public class UserConverter {
    private UserConverter(){

    }

    public static User convert(UserEntity entity){
        if(entity.getPosts() == null){
            entity.setPosts(Collections.emptyList());
        }
        return User.builder()
                .id(entity.getId())
                .posts(PostConverter.convertList(entity.getPosts()))
                .username(entity.getUsername())
                .build();
    }
}
