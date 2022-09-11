package sem3.its.ReReddit.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sem3.its.ReReddit.business.GetPostsUseCase;
import sem3.its.ReReddit.domain.GetPostsResponse;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {
    private final GetPostsUseCase getPostsUseCase;

    @GetMapping
    public ResponseEntity<GetPostsResponse> getPosts(){
        GetPostsResponse res = getPostsUseCase.getPosts();
        return ResponseEntity.ok(res);
    }
}
