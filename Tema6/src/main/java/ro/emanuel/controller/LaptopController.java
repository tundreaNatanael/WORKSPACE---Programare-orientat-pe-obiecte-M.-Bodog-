package ro.emanuel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ro.emanuel.pojo.Laptop;

@Controller
public class LaptopController {

    @GetMapping("/laptops")
    public String getLaptopBrand(@RequestParam(name = "brand", required = false, defaultValue = "default") String brand, Model model) {
        int length = brand.length();
        String odd = (length % 2 != 0) ? "odd" : "even";
        
        model.addAttribute("brand", brand);
        model.addAttribute("length", length);
        model.addAttribute("parity", odd);
        
        return "laptopBrand";
    }
    @GetMapping("/laptop")
    public String getLaptop(Model model) {
        
        Laptop laptop = new Laptop("Dell", 2500, 16);

        model.addAttribute("lap", laptop);

        return "laptopDetails";
    }
}