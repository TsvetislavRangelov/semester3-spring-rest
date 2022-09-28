package sem3.its.ReReddit.business.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sem3.its.ReReddit.business.CreatePostUseCase;
import sem3.its.ReReddit.domain.CreatePostRequest;
import sem3.its.ReReddit.domain.CreatePostResponse;
import sem3.its.ReReddit.persistence.PostRepository;
import sem3.its.ReReddit.persistence.entity.PostEntity;

@Service
@AllArgsConstructor
public class CreatePostUseCaseImpl implements CreatePostUseCase {
    private PostRepository postRepository;

    @Override
    public CreatePostResponse createPost(CreatePostRequest request){
        PostEntity createdEntity = saveNewPost(request);

        return CreatePostResponse.builder()
                .id(createdEntity.getId())
                .build();
    }

    private PostEntity saveNewPost(CreatePostRequest request){
        PostEntity postEntity = PostEntity.builder()
                .author(request.getAuthor())
                .body(request.getBody())
                .header(request.getHeader())
                .build();
        return postRepository.save(postEntity);
    }
}
