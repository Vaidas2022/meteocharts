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
		
		List<Double> temperaturos = duomenys
				.getObservations()
				.stream()
				.map( d -> d.getAirTemperature())
				.toList();

		List<Integer> valandos = duomenys
				.getObservations()
				.stream()
				.map( d -> Integer.parseInt(d.getObservationTimeUtc().substring(11,13) ))
				.toList();
				
        
        model.addAttribute("xData", valandos);
        model.addAttribute("yData", temperaturos);
        
		return "home";
	}
		
}
