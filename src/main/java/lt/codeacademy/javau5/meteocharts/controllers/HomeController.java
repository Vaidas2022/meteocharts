package lt.codeacademy.javau5.meteocharts.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/home")  //localhost:8080/test/orai
public class HomeController {

	@GetMapping("/orai")
	public String getIndex(Model model) {
		// Simuliuojame linijinio grafiko duomenis
        List<Integer> xData = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> yData = Arrays.asList(10, 20, 15, 30, 25);
		
        model.addAttribute("xData", xData);
        model.addAttribute("yData", yData);
        
		return "home";
	}
		
}
