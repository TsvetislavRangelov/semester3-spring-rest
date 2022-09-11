package sem3.its.ReReddit.configuration;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import sem3.its.ReReddit.persistence.PostRepository;
import sem3.its.ReReddit.persistence.UserRepository;
import sem3.its.ReReddit.persistence.entity.PostEntity;
import sem3.its.ReReddit.persistence.entity.UserEntity;

@Component
@AllArgsConstructor
public class FakeDatabaseInitializer {
    private UserRepository userRepository;
    private PostRepository postRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initializeFakeData(){
        if(userRepository.count() == 0){
        userRepository.save(UserEntity.builder().id(1L).username("user1").build());
            userRepository.save(UserEntity.builder().id(2L).username("user2").build());
            userRepository.save(UserEntity.builder().id(3L).username("user3").build());
            userRepository.save(UserEntity.builder().id(4L).username("user4").build());
            userRepository.save(UserEntity.builder().id(5L).username("user5").build());
            userRepository.save(UserEntity.builder().id(6L).username("user6").build());
            userRepository.save(UserEntity.builder().id(7L).username("user7").build());
            userRepository.save(UserEntity.builder().id(8L).username("user8").build());
            postRepository.save(PostEntity.builder().body("post body xd")
                    .header("post header xd")
                    .ups(10)
                    .downs(1)
                    .author(UserEntity.builder().id(10L).username("user10").build())
                    .id(2L)
                    .build());

        }
    }
}
