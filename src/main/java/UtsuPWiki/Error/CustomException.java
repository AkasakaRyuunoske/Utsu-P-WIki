package UtsuPWiki.Error;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomException extends UsernameNotFoundException {
    public CustomException(String msg) {
        super(msg);
    }
}
