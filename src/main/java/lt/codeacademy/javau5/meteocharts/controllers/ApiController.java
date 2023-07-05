package lt.codeacademy.javau5.meteocharts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.codeacademy.javau5.meteocharts.entities.Duomenys;
import lt.codeacademy.javau5.meteocharts.services.MeteoService;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	MeteoService service;

	@GetMapping("/vilnius")
	public Duomenys getVilniausDuomenys() {

		String url = "https://api.meteo.lt/v1/stations/vilniaus-ams/observations/2023-07-04";

		return service.getWeather(url);
		
	}
}
