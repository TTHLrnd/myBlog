package com.examplemyBlog.myBlog.author;



import com.examplemyBlog.myBlog.registration.token.ConfirmationToken;
import com.examplemyBlog.myBlog.registration.token.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
@Configuration
@Service
@AllArgsConstructor
public class AuthorService implements UserDetailsService {
    private final static String USER_NOT_FOUND_MSG = "User with email %s not found";
    private final AuthorRepository authorRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenRepository confirmationTokenRepository;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return authorRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    public ConfirmationToken signUpAuthor(Author author) {
        Optional<Author> authorExist = authorRepository.findByEmail(author.getEmail());
        if (authorExist.isPresent()){
            if (authorExist.get().getEnabled()) {
                throw new IllegalStateException("Email already taken");
            } else {
                //TODO email resent message
                return createToken(authorExist.get());
            }
        }

        String encodedPassword = bCryptPasswordEncoder.encode(author.getPassword());
        author.setPassword(encodedPassword);
        authorRepository.save(author);

        return createToken(author);
    }

    private ConfirmationToken createToken(Author author){
        String token =  UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                author
        );
        confirmationTokenRepository.save(confirmationToken);
        return confirmationToken;
    }

    public void enableAuthor(String email) {
        authorRepository.findByEmail(email).
                orElseThrow(() -> new IllegalStateException("user not found"))
                .setEnabled(true);
    }
}
