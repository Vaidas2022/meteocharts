package lt.codeacademy.javau5.meteocharts.services;

import lt.codeacademy.javau5.meteocharts.entities.Duomenys;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MeteoService {

	private static final String WEATHER_URL = "https://api.meteo.lt/v1/stations/vilniaus-ams/observations/2023-07-04";

    public Duomenys getWeather() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Duomenys> response = restTemplate.getForEntity(WEATHER_URL, Duomenys.class);

        if (response.getStatusCode().is2xxSuccessful()  ) {
            return response.getBody();
        } else {
            // Handle error response
            return null;
        }
    }
	
}
