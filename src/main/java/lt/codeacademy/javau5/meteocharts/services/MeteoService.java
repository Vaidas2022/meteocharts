package lt.codeacademy.javau5.meteocharts.services;

import lt.codeacademy.javau5.meteocharts.entities.Duomenys;

import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpEntity;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class MeteoService {

    public Duomenys getWeather(String weatherUrl) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));   
        
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        
        ResponseEntity<Duomenys> response = restTemplate.exchange(weatherUrl, HttpMethod.GET, entity, Duomenys.class);
        
        
        if (response.getStatusCode() == HttpStatus.OK ) {
            return response.getBody();
        } else {
            // Handle error response
            return null;
        }
    }
	
}
