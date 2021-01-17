package com.kozmapps.cryptolive.user;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Optional.ofNullable;
import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@Service
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
public class UserService {
    @NonNull
    UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.insert(user);
    }

    public Optional<User> findByUsername(String username) {
        return ofNullable(userRepository.findByUsername(username));
    }
}
