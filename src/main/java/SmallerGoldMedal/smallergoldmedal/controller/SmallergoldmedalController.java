package SmallerGoldMedal.smallergoldmedal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping("/countries")
public class SmallergoldmedalController {
    
    public SmallergoldmedalController() {
    }

    @GetMapping("/test")
    public String test() {
        return "Test test";
    }

}
