package lt.codeacademy.javau5.meteocharts.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lt.codeacademy.javau5.meteocharts.entities.Duomenys;
import lt.codeacademy.javau5.meteocharts.services.MeteoService;


@Controller
@RequestMapping("/home")  //localhost:8080/test/orai
public class HomeController {

	@Autowired
	MeteoService service;
	
	@GetMapping("/orai")
	public String getIndex(Model model) {
		// Simuliuojame linijinio grafiko duomenis
        List<Integer> xData = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> yData = Arrays.asList(10, 20, 15, 30, 25);
		
        model.addAttribute("xData", xData);
        model.addAttribute("yData", yData);
        
		return "home";
	}
	
	@GetMapping("/vilnius")
	public String getVilnius(Model model) {
		
		String url = "https://api.meteo.lt/v1/stations/vilniaus-ams/observations/latest";

		Duomenys duomenys = service.getWeather(url);		
        
        model.addAttribute("xData", duomenys.getValandos());
        model.addAttribute("yData", duomenys.getTemperaturos());
        model.addAttribute("tData", duomenys.getFeelsLike());
        model.addAttribute("wData", duomenys.getClouds());
        
		return "home";
	}
		
	@GetMapping("/kaunas")
	public String getKaunas(Model model) {
		
		String url = "https://api.meteo.lt/v1/stations/kauno-ams/observations/latest";

		Duomenys duomenys = service.getWeather(url);		
        
        model.addAttribute("xData", duomenys.getValandos());
        model.addAttribute("yData", duomenys.getTemperaturos());
        model.addAttribute("tData", duomenys.getFeelsLike());
        model.addAttribute("wData", duomenys.getClouds());
        
		return "home";
	}
}
