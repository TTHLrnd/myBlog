package com.examplemyBlog.myBlog.services;

import com.examplemyBlog.myBlog.model.ConfirmationToken;
import com.examplemyBlog.myBlog.repositories.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token){
        confirmationTokenRepository.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    public void setConfirmedAt(String token) {
        confirmationTokenRepository.findByToken(token)
                .orElseThrow(() -> new IllegalStateException("token not found"))
                .setConfirmedAt(LocalDateTime.now());
    }
}
