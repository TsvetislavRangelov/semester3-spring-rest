package sem3.its.ReReddit.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sem3.its.ReReddit.business.CreateUserUseCase;
import sem3.its.ReReddit.business.GetUserUseCase;
import sem3.its.ReReddit.business.GetUsersUseCase;
import sem3.its.ReReddit.domain.CreateUserRequest;
import sem3.its.ReReddit.domain.CreateUserResponse;
import sem3.its.ReReddit.domain.GetUsersResponse;
import sem3.its.ReReddit.domain.User;
import javax.validation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final GetUsersUseCase getUsersUseCase;
    private final GetUserUseCase getUserUseCase;
    private final CreateUserUseCase createUserUseCase;

    @GetMapping
    public ResponseEntity<GetUsersResponse> getAllUsers(){
    GetUsersResponse res = getUsersUseCase.getUsers();
    return ResponseEntity.ok(res);
    }
    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable(value = "id") final long id){
        final Optional<User> userOptional = getUserUseCase.getUser(id);
        if(userOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(userOptional.get());
    }

    @PostMapping()
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody @Valid CreateUserRequest request){
        CreateUserResponse res = createUserUseCase.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }
}
