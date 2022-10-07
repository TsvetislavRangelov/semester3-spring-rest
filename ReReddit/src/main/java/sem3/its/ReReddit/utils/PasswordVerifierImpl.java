package sem3.its.ReReddit.utils;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PasswordVerifierImpl implements PasswordVerifier {
    @Override
    public boolean verify(String hash, char[] plainText){
        Argon2 argon2 = Argon2Factory.create();

        return argon2.verify(hash, plainText);
    }
}
