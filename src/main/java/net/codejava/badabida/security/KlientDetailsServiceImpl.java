package net.codejava.badabida.security;

import net.codejava.badabida.repos.KlientRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class KlientDetailsServiceImpl implements UserDetailsService {


    private final KlientRepository klientRepository;

    public KlientDetailsServiceImpl(KlientRepository klientRepository) {
        this.klientRepository = klientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return klientRepository.findByUsername(s).get();
    }
}
