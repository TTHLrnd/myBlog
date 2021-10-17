package com.examplemyBlog.myBlog.author;



import com.examplemyBlog.myBlog.home.LoginForm;
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

    public String signUpAuthor(Author author) {
        boolean authorExist = authorRepository.findByEmail(author.getEmail()).isPresent();
        if (authorExist){
            //TODO check attributes of same user
            //TODO if email not confirmed send confirmation email
            throw new IllegalStateException("Email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(author.getPassword());
        author.setPassword(encodedPassword);
        authorRepository.save(author);

        String token =  UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                author
        );
        confirmationTokenRepository.save(confirmationToken);

        return token;
    }

    public void enableAuthor(String email) {
        authorRepository.findByEmail(email).
                orElseThrow(() -> new IllegalStateException("user not found"))
                .setEnabled(true);
    }

    public String loginAuthor(LoginForm loginForm){
        Optional<Author> author =  authorRepository.findByEmail(loginForm.getEmail());
        if (author.isEmpty()){
            throw  new IllegalStateException("User not found");
        }
        if (!bCryptPasswordEncoder.matches(loginForm.getPassword(), author.get().getPassword())){
            throw new IllegalStateException("Wrong password");
        }
        return "homepage";
    }
}
