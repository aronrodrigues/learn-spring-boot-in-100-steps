package ie.trk.springboot.myfirstapp.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("")
    public String goToHome(ModelMap model) {
        model.put("name", "aronrodrigues");
        return "home";
    }

}
