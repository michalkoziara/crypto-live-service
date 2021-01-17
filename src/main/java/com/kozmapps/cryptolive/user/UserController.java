package com.kozmapps.cryptolive.user;

import com.kozmapps.cryptolive.authentication.UserAuthenticationService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/users")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
final class UserController {
    @NonNull
    UserAuthenticationService userAuthenticationService;

    @GetMapping("/profile")
    User getCurrent(@AuthenticationPrincipal final User user) {
        return user;
    }

    @GetMapping("/logout")
    void logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object token = authentication.getCredentials();
        userAuthenticationService.logout(String.valueOf(token));
    }
}