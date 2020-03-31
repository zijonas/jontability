package org.jonas.jontability.endpoint;

import lombok.AllArgsConstructor;
import org.jonas.jontability.dto.authentication.AuthenticationRequest;
import org.jonas.jontability.security.UserDetailServiceImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailServiceImpl userDetailService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public String authenticate(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (AuthenticationException e) {
            throw new Exception("Incorrect Authentication", e);
        }

        UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getUsername());

        return null;
    }
}
