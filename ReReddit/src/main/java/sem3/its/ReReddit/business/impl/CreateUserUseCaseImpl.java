package sem3.its.ReReddit.business.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sem3.its.ReReddit.business.CreateUserUseCase;
import sem3.its.ReReddit.business.exception.UsernameAlreadyExistsException;
import sem3.its.ReReddit.domain.CreateUserRequest;
import sem3.its.ReReddit.domain.CreateUserResponse;
import sem3.its.ReReddit.persistence.UserRepository;
import sem3.its.ReReddit.persistence.entity.UserEntity;

@Service
@AllArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private UserRepository userRepository;

    @Override
    public CreateUserResponse createUser(CreateUserRequest request){
        if(userRepository.existsByUsername(request.getUsername())){
            throw new UsernameAlreadyExistsException();
        }

        UserEntity createdUser = saveNewUser(request);

        return CreateUserResponse.builder()
                .id(createdUser.getId())
                .build();
    }

    private UserEntity saveNewUser(CreateUserRequest request){
        UserEntity userEntity = UserEntity.builder()
                .username(request.getUsername())
                .build();
        return userRepository.save(userEntity);
    }
}
