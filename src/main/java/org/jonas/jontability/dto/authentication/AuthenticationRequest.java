package org.jonas.jontability.dto.authentication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class AuthenticationRequest {
    private final String username;
    private final String password;
}
