package ie.trk.springboot.myfirstapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import ie.trk.springboot.myfirstapp.AuthService;

@Controller
@RequestMapping("/login")
@SessionAttributes("name")
public class LoginController {
    
    private final AuthService authService;

    public LoginController(AuthService authService) {
        super();
        this.authService = authService;
    }

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping({"/", ""})
    public String showLoginPage() {
        return "login";
    } 

    @GetMapping({"/welcome"})
    public String showWelcomePage() {
        return "welcome";
    } 

    @PostMapping({"/", ""})
    public String handlePost(
        //@RequestBody 
        @RequestParam String name,
        @RequestParam String password,
        ModelMap model
    ) {
        logger.info("User(name:{}, password: {})", name, password);
        if (authService.authenticate(name, password)) {
            model.put("name", name);
            return "welcome";
        }

        model.put("error", "Invalid credentials");        
        return "login";

    } 
}
