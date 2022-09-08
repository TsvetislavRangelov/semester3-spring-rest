package sem3.its.ReReddit.business.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sem3.its.ReReddit.business.GetUserUseCase;
import sem3.its.ReReddit.domain.User;
import sem3.its.ReReddit.persistence.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetUserUseCaseImpl implements GetUserUseCase {
    private UserRepository userRepository;

    @Override
    public Optional<User> getUser(long id){
        return userRepository.findById(id).map(UserConverter::convert);
    }
}
