package pl.crewmanager.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.crewmanager.entity.Admin;
import pl.crewmanager.service.AdminService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@SessionAttributes("loggedAdmin")
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/addAdmin")
    public String addAdminView(Model model){

        model.addAttribute("admin", new Admin());
        return "addAdmin";
    }

    @PostMapping("/addAdmin")
    public String addAdmin(@ModelAttribute("admin") @Valid Admin admin, BindingResult result,
                           @RequestParam String repassword){
        if(result.hasErrors()){
            return "addAdmin";
        }
        if(repassword.equals(admin.getPassword())){
            admin.setPassword(passwordEncoder.encode(admin.getPassword()));
            adminService.addAdmin(admin);
            return "redirect:/crewManager/login";
        }
        String password = repassword;
        return "home";
    }

    @GetMapping("/editAdmin")
    public String editAdminView(Model model, HttpSession session){

        Admin admin = (Admin) session.getAttribute("loggedAdmin");
        model.addAttribute("admin", admin);
        return "editAdmin";
    }

    @PostMapping("/editAdmin")
    public String editAdmin(@RequestParam String firstName, @RequestParam String lastName, HttpSession session){

        Admin admin = (Admin) session.getAttribute("loggedAdmin");
        adminService.editAdmin(firstName, lastName, admin.getEmail());
        return "redirect:/admin/home";
    }

    @GetMapping("/editPassword")
    public String editPasswordView(Model model, HttpSession session){

        Admin admin = (Admin) session.getAttribute("loggedAdmin");
        model.addAttribute("admin", admin);
        return "editPassword";
    }

    @PostMapping("/editPassword")
    public String editPassword(@RequestParam("password") String password, @RequestParam("repassword") String repassword, HttpSession session){

        Admin admin = (Admin) session.getAttribute("loggedAdmin");
        if(password.equals(repassword)) {
            adminService.findByEmail(admin.getEmail());
            adminService.editPassword(password, admin.getEmail());
            return "redirect:/admin/home";
        }
        return "editPassword";
    }

    @GetMapping("/showAdmin")
    public String showAdminView(HttpSession session, Model model){

        Admin admin = (Admin) session.getAttribute("loggedAdmin");
        model.addAttribute("admin", admin);
        return "showAdmin";
    }

    @GetMapping("/deleteAdmin")
    public String deleteAdminView(HttpSession session, Model model){

        Admin admin = (Admin) session.getAttribute("loggedAdmin");
        model.addAttribute("admin", admin);
        return "deleteAdmin";
    }

    @GetMapping("/delete")
    public String deleteAdmin(HttpSession session){

        Admin admin = (Admin) session.getAttribute("loggedAdmin");
        adminService.deleteAdmin(admin.getEmail());
        return "redirect:/crewManager/login";
    }

    @GetMapping("/home")
    public String homeAdmin(HttpSession session, @AuthenticationPrincipal UserDetails user,
                            Model model){

        String email = user.getUsername();
        Admin admin = adminService.findByEmail(email);
        session.setAttribute("loggedAdmin", admin);
        model.addAttribute("admin", admin);
        return "home";
    }
}
