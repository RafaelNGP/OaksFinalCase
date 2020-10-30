package com.finalcase.oaks.OaksFinalCase.security;

import com.finalcase.oaks.OaksFinalCase.entity.User;
import com.finalcase.oaks.OaksFinalCase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username);

        if(user == null) {
            throw new UsernameNotFoundException("Usuário não encontrado.");
        }
        return new org.springframework.security.core.userdetails.
                User(user.getUsername(), user.getPassword(), true, true, true, true, user.getAuthorities());
    }

}
