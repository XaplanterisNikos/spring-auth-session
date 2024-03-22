package gr.aueb.cf.springauthsession5.controller;


import gr.aueb.cf.springauthsession5.service.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final IUserService userService;

    @GetMapping("/login")
    public String login(Model model, Principal principal, HttpServletRequest request) {

        if(principal == null) return "login";

        var user = userService.getUserByUsername(principal.getName());
        String role = user.getRole().name();

        if(role.equals("TEACHERS")){
            return "redirect:/teachers/dashboard";
        }

        if(role.equals("STUDENTS")){
            return "redirect:/students/dashboard";
        }

        return  "redirect:/dashboard";
    }

    @GetMapping("/")
    public String root(Principal principal) {
        // return "redirect:/"login";
        return principal == null ? "login" : "redirect:/dashboard";
    }
}
