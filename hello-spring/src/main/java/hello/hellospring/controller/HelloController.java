package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
@GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data",  "spring!!");
        return "hello"; // teamplates/hello.html로 찾아가라는 뜻(렌더링 하라는 뜻)
    }
}
