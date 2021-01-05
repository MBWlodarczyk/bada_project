package net.codejava.badabida.security;

import net.codejava.badabida.repos.PracownikRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PracownikDetailServiceImp implements UserDetailsService {

    private final PracownikRepository pracownikRepository;

    public PracownikDetailServiceImp(PracownikRepository pracownikRepository) {
        this.pracownikRepository = pracownikRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return pracownikRepository.findByUsername(s).get();
    }
}
