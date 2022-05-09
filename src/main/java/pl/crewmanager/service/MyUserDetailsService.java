package pl.crewmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.crewmanager.entity.Admin;
import java.util.Collections;

public class MyUserDetailsService implements UserDetailsService {

    private AdminService adminService;

    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Admin admin = adminService.findByEmail(email);
        if(admin == null){
            throw new UsernameNotFoundException(email);
        }
        return new User(admin.getEmail(), admin.getPassword(), Collections.emptyList());
    }
}
