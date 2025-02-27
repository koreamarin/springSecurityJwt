package com.auth.springSecurityJwt.config.auth;

import com.auth.springSecurityJwt.model.User;
import com.auth.springSecurityJwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// http://localhost:8080/login 으로 요청이 왔을 때 동작함
// 정확히는 authenticationManager로 로그인을 진행하면 PrincipalDetailsService가 호출됨
@Service
@RequiredArgsConstructor
@Slf4j
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("PrintcipalDetailsService의 loadUserByUsername()");
        User userEntity = userRepository.findByUsername(username);
        log.info("userEntity: " + userEntity);
        return new PrincipalDetails(userEntity);
    }
}
