package sem3.its.ReReddit.persistence;
import sem3.its.ReReddit.persistence.entity.PostEntity;

import java.util.List;

public interface PostRepository {

    PostEntity save(PostEntity entity);

    List<PostEntity> findAll();

    int count();

    PostEntity findById(Long id);

    boolean existsById(Long id);


}
