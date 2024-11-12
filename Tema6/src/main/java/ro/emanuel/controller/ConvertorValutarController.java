package ro.emanuel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertorValutarController {

    @GetMapping("/convert")
    public String convertCurrency(
        @RequestParam("suma") double suma,
        @RequestParam("from") String from,
        @RequestParam("to") String to,
        @RequestParam("rate") double rate,
        Model model) {

        double result;
        String currency;

        if (from.equalsIgnoreCase("RON") && to.equalsIgnoreCase("EUR")) {
            result = suma / rate;
            currency = "EURO";
        } else if (from.equalsIgnoreCase("EUR") && to.equalsIgnoreCase("RON")) {
            result = suma * rate;
            currency = "RON";
        } else {
            result = suma;
            currency = from;
        }

        model.addAttribute("result", result);
        model.addAttribute("currency", currency);

        return "convertPage";
    }
}