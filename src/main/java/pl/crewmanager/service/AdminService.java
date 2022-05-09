package pl.crewmanager.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.crewmanager.entity.Admin;
import pl.crewmanager.repository.AdminRepository;
import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void addAdmin(Admin admin){

        adminRepository.save(admin);
    }

    @Transactional
    public void editAdmin(String firstName, String lastName, String email){

        Admin admin = adminRepository.findByEmail(email);
        admin.setFirstName(firstName);
        admin.setLastName(lastName);
        adminRepository.save(admin);
    }

    @Transactional
    public void editPassword(String password, String email){

        Admin admin = adminRepository.findByEmail(email);
        admin.setPassword(passwordEncoder.encode(password));
        adminRepository.save(admin);
    }

    @Transactional
    public void deleteAdmin(String email){

        Admin admin = adminRepository.findByEmail(email);
        adminRepository.delete(admin);
    }

    public Admin findByEmail(String email){

        return adminRepository.findByEmail(email);
    }

    public List<Admin> findAllAdmins(){

        List<Admin> adminList = new LinkedList<>();
        adminList = adminRepository.findAll();
        return adminList.stream()
                .sorted(Comparator.comparing(Admin::getLastName)
                .thenComparing(Admin::getFirstName))
                .collect(Collectors.toList());
    }
}
