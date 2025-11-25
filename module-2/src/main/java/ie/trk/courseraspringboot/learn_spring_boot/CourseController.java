package ie.trk.courseraspringboot.learn_spring_boot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CourseController {
    CurrencyServiceConfiguration currencyServiceConfiguration;

    public CourseController(CurrencyServiceConfiguration currencyServiceConfiguration) {
        this.currencyServiceConfiguration = currencyServiceConfiguration;
    }

    @GetMapping("/courses")
    public List<Course>getCourses() {
        return Arrays.asList(
            new Course(1, "Learn AWS", "aronrodrigues"),
            new Course(2, "DevOps", "aquacarol"),
            new Course(3, "Docker", "aronrodrigues"),
            new Course(4, this.currencyServiceConfiguration.getKey(), this.currencyServiceConfiguration.getUsername())
        );
    }

}
