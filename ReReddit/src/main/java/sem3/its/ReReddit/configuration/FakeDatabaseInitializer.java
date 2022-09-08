package sem3.its.ReReddit.configuration;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import sem3.its.ReReddit.persistence.UserRepository;
import sem3.its.ReReddit.persistence.entity.UserEntity;

@Component
@AllArgsConstructor
public class FakeDatabaseInitializer {
    private UserRepository userRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initializeFakeData(){
        if(userRepository.count() == 0){
        userRepository.save(UserEntity.builder().id(1L).password("123").username("user1").build());
            userRepository.save(UserEntity.builder().id(2L).password("hehexd").username("user2").build());
            userRepository.save(UserEntity.builder().id(3L).password("$ickPa$$word").username("user3").build());
            userRepository.save(UserEntity.builder().id(4L).password("abc").username("user4").build());
            userRepository.save(UserEntity.builder().id(5L).password("abcdef").username("user5").build());
            userRepository.save(UserEntity.builder().id(6L).password("unh4ck4blePa$$word").username("user6").build());
            userRepository.save(UserEntity.builder().id(7L).password("12345").username("user7").build());
            userRepository.save(UserEntity.builder().id(8L).password("12345678").username("user8").build());

        }
    }
}
