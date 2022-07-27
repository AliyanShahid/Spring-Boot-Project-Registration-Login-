package com.example.loginregisterationapp.config;

import com.example.loginregisterationapp.entity.UserData;
import com.example.loginregisterationapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserdtlsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;
    @Override
    public UserDetails loadUserByUsername(String em) throws UsernameNotFoundException {
        try {
            UserData u = repo.findByEmail(em);

            if(u==null)
            {
                throw new UsernameNotFoundException("User Not Found");
            }
            else

                return new CustomUserDtls(u);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        return null;
    }


}
