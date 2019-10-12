package ru.igor.task;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

    public static Authentication getUser() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
