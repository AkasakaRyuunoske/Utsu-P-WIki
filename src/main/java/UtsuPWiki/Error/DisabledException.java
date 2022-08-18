package UtsuPWiki.Error;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class DisabledException extends UsernameNotFoundException {
    public DisabledException(String msg) {
        super(msg);
    }
}
