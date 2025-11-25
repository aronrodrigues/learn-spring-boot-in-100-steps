package ie.trk.springboot.myfirstapp.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class SayHelloController {

      private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/")
    @ResponseBody
    public String sayHello() {
        return "Hello World, Aron!!!";
         
    }

    @GetMapping("/html")
    @ResponseBody
    public String sayHelloHtml() {
        return "<html><head><title>My App</title></head><body><h1>Aron</h1></body></html>";
    }

    @GetMapping("/jsp")
    public String sayHelloJsp(@RequestParam String name, ModelMap model) {
        logger.info("Name({})", name);
        model.addAttribute("name", name);
        return "sayHello";
    }

}

