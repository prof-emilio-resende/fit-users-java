package br.edu.impact.authn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Private")
public class SampleController {

    @GetMapping("/Hello")
    public String hello() {
        return "hello!";
    }

}
