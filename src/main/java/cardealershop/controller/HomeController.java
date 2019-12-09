package cardealershop.controller;

import cardealershop.databaseauth.CustomUserService;
import cardealershop.databaseauth.UserApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    private CustomUserService customUserService;

    //@PreAuthorize()   sterowanie w endpoincie
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/user")
    public String getUserPage(){
        return "user";
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/admin")
    public String getAdminPage(){
        return "admin";
    }
    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }
    @GetMapping("/register")
    public String getRegisterPage(){
        return "register";
    }
    @PostMapping("/sign")
    public String getFormLogin(@RequestParam String username, @RequestParam String password){
        System.out.println(username);
        return "redirect:/";
    }
    @PostMapping("/register")
    public String registerForm(@ModelAttribute UserApp user){
        customUserService.registerUser(user);
        return "redirect:/";
    }

}
