package sem3.its.ReReddit.business.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sem3.its.ReReddit.business.CreateUserUseCase;
import sem3.its.ReReddit.business.exception.InvalidRequestBodyException;
import sem3.its.ReReddit.business.exception.UsernameAlreadyExistsException;
import sem3.its.ReReddit.domain.CreateUserRequest;
import sem3.its.ReReddit.domain.CreateUserResponse;
import sem3.its.ReReddit.persistence.UserRepository;
import sem3.its.ReReddit.persistence.entity.UserEntity;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@Service
@AllArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private UserRepository userRepository;

    @Override
    public CreateUserResponse createUser(CreateUserRequest request){
        if(userRepository.existsByUsername(request.getUsername()) ||
                userRepository.existsByEmail(request.getEmail())){
            throw new UsernameAlreadyExistsException();
        }

        UserEntity createdUser = saveNewUser(request);

        return CreateUserResponse.builder()
                .id(createdUser.getId())
                .build();
    }

    private UserEntity saveNewUser(CreateUserRequest request){

        Argon2 argon2 = Argon2Factory.create();
        char[] pwd = request.getPassword().toCharArray();
        if(pwd.length == 0){
            throw new InvalidRequestBodyException();
        }
        try{
            String hash = argon2.hash(10, 65536, 1, pwd);

            if(argon2.verify(hash, pwd)){
                UserEntity userEntity = UserEntity.builder()
                        .username(request.getUsername())
                        .password(hash)
                        .email(request.getEmail())
                        .role(request.getRole())
                        .build();
                return userRepository.save(userEntity);
            }
            else{
                throw new InvalidRequestBodyException();
            }
        }
        finally{
            argon2.wipeArray(pwd);
        }
    }
}
