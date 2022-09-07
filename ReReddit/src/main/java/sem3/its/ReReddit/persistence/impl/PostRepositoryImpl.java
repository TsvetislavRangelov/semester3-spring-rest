package sem3.its.ReReddit.persistence.impl;
import org.springframework.stereotype.Repository;
import sem3.its.ReReddit.persistence.PostRepository;
import sem3.its.ReReddit.persistence.entity.PostEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Repository
public class PostRepositoryImpl implements PostRepository {
    private static long NEXT_ID = 1;
    private final List<PostEntity> savedPosts;

    public PostRepositoryImpl(){
        this.savedPosts = new ArrayList<>();
    }
    @Override
    public PostEntity save(PostEntity entity){
        entity.setId(NEXT_ID);
        NEXT_ID++;
        this.savedPosts.add(entity);
        return entity;

    }
    @Override
    public List<PostEntity> findAll(){
        return Collections.unmodifiableList(savedPosts);
    }
    @Override
    public int count() { return this.savedPosts.size();}

    @Override
    public PostEntity findById(Long id){
        return this.savedPosts
                .stream()
                .filter(postEntity -> Objects.equals(postEntity.getId(), id))
                .findFirst()
                .orElse(null);
    }
    @Override
    public boolean existsById(Long id){
        return this.savedPosts
                .stream()
                .anyMatch(postEntity -> Objects.equals(postEntity.getId(), id));
    }
}
