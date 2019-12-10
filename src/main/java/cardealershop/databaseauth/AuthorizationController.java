package cardealershop.databaseauth;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorizationController {

  private CustomUserService customUserService;

  public AuthorizationController(CustomUserService customUserService) {
    this.customUserService = customUserService;
  }

//  @GetMapping("/")
//  public String homePage(Model model) {
//    SecurityContext context = SecurityContextHolder.getContext();
//    model.addAttribute("message", "You are logged in as: " + context.getAuthentication().getName());
//    return "index";
//  }

  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping("/admin")
  public String securedAdminPage() {
    return "admin_secured";
  }

  @PreAuthorize("hasRole('USER')")
  @GetMapping("/user")
  public String securedUserPage() {
    return "user_secured";
  }

  @GetMapping("/login")
  public String loginPage() {
    return "login";
  }

  @GetMapping("/register")
  public String registerPage() {
    return "register";
  }

  @PostMapping("/register")
  public String registerForm(@ModelAttribute UserApp user) {
    customUserService.registerUser(user);
    return "redirect:/";
  }
}
