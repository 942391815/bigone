package test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@SpringBootApplication
@PropertySource({"classpath:application-constom.properties"})
public class App {

    @Value("${person}")
    private String person;
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    @ResponseBody
    public String home(@RequestParam Map param, String name) {
        System.out.println(param);
        System.out.println(name);
        return "hello world!!" + person;
    }

    @RequestMapping("/put")
    public String home(@RequestBody Map param) {
        System.out.println(param);
        return "hello world!!";
    }

    public static void main(String[] args) {
        System.out.println("hello word!");
        SpringApplication.run(App.class, args);

    }

    @GetMapping("/get")
    @ResponseBody
    public List<User> getALibrarianInfo() {
        return userService.selectLibrarian(1);
    }
}
