package com.alkemy.ong.security.service.impl;

import com.alkemy.ong.exception.AlreadyExistsException;
import com.alkemy.ong.exception.InvalidTokenException;
import com.alkemy.ong.exception.NoAuthorizationProvidedException;
import com.alkemy.ong.exception.ParameterNotFound;
import com.alkemy.ong.security.dto.AuthRequest;
import com.alkemy.ong.security.dto.AuthResponse;
import com.alkemy.ong.security.dto.UserGetDto;
import com.alkemy.ong.security.dto.UserInformationDto;
import com.alkemy.ong.security.dto.UserPostDto;
import com.alkemy.ong.security.mapper.UserMapper;
import com.alkemy.ong.security.model.User;
import com.alkemy.ong.security.repository.UserRepository;
import com.alkemy.ong.security.service.IAuthService;
import com.alkemy.ong.security.service.IUserService;
import com.alkemy.ong.security.service.JwtUtils;
import com.alkemy.ong.service.IEmailService;
import static com.alkemy.ong.util.Constants.ROLE_USER;
import java.io.IOException;
import java.util.Locale;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@org.springframework.transaction.annotation.Transactional
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IUserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private IEmailService emailService;

    @Autowired
    private MessageSource message;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse authenticate(AuthRequest request) throws ParameterNotFound {

        User user = userRepository.findByEmail(request.getUsername());

        if (user == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        UserDetails userDetails;
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
            userDetails = (UserDetails) auth.getPrincipal();
        } catch (BadCredentialsException e) {
            throw new ParameterNotFound(message.getMessage("credentials.incorrect", null, Locale.US));
        }
        final String jwt = jwtUtils.generateToken(userDetails);
        return new AuthResponse(jwt);
    }

    @Override
    @Transactional
    public UserGetDto registerUser(UserPostDto dto) throws IOException {

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new AlreadyExistsException(
                    message.getMessage("email.exists", null, Locale.US));
        }

        User user = userMapper.userPostDtoToUser(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        User savedUser = userRepository.save(user);

        userService.addRoleToUser(ROLE_USER, savedUser);

        UserGetDto userGetDto = userMapper.userToUserDto(savedUser);

        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword())
        );

        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        final String jwt = jwtUtils.generateToken(userDetails);
        userGetDto.setJwtToken(jwt);

        emailService.sendWelcomeEmail(user.getEmail());

        return userGetDto;
    }

    @Override
    public UserInformationDto getCurrentAuthenticatedUser(Authentication authentication) {
        try {

            User user = getUserAuthenticated(authentication);

            return userMapper.userToUserInformationDto(user);

        } catch (io.jsonwebtoken.SignatureException e) {
            throw new InvalidTokenException(message.getMessage("invalid.token", null, Locale.US));
        }
    }

    public User getUserAuthenticated(Authentication authentication) {
        if (authentication == null) {
            throw new NoAuthorizationProvidedException(message.getMessage("request.authorizationNotProvided", null, Locale.US));
        }
        if (!authentication.isAuthenticated()) {
            throw new BadCredentialsException(message.getMessage("user.notAuthenticated", null, Locale.US));
        }
        User user = userRepository.findByEmail((String) authentication.getPrincipal());

        if (user == null) {
            throw new UsernameNotFoundException(message.getMessage("email.notFound", null, Locale.US));
        }
        return user;
    }
}
