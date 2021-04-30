package info.jab.microservices.controller;

import info.jab.microservices.model.JwtRequest;
import info.jab.microservices.model.JwtResponse;
import info.jab.microservices.model.UserChangePasswordRequest;
import info.jab.microservices.service.impl.JwtUserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import info.jab.microservices.config.JwtTokenUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsServiceImpl jwtUserDetailsService;

	@PostMapping(value = "/api/login")
	public ResponseEntity<?> login(@Valid @RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = jwtUserDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok().body(new JwtResponse(token));
	}

	@PostMapping("/api/users/update-password")
    public ResponseEntity<String> changePassword(@Valid @RequestBody UserChangePasswordRequest userCPR, @RequestHeader("Authorization") String tokenHeader) {
        String username = null;
        String jwtToken = null;
        // JWT Token is in the form "Bearer token". Remove Bearer word and get only the Token
		if (tokenHeader != null && tokenHeader.startsWith("Bearer ")) {
			jwtToken = tokenHeader.substring(7);
			username = jwtTokenUtil.getUsernameFromToken(jwtToken);
            if (userCPR.getNewPassword().equals(userCPR.getNewPassword2())){
                try {
					authenticate(username, userCPR.getCurrentPassword());
					jwtUserDetailsService.changePassword(username, userCPR.getNewPassword());
				} catch (Exception e) {
					return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
				}
				
            } else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}
        return new ResponseEntity<>(HttpStatus.OK);
    }

	private void authenticate(String username, String password) throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
