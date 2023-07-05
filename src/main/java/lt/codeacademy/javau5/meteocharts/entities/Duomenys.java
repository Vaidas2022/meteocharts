package lt.codeacademy.javau5.meteocharts.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Duomenys {
	Station station;
	List<Observation> observations;	
	
	public List<Double> getTemperaturos(){
		return observations
				.stream()
				.map( d -> d.getAirTemperature())
				.toList();
	}
	
	public List<Integer> getValandos(){
		return observations
				.stream()
				.map( d -> Integer.parseInt(d.getObservationTimeUtc().substring(11,13) ))
				.toList();
	}
	
	public List<Double> getFeelsLike(){
		return observations
				.stream()
				.map( d -> d.getFeelsLikeTemperature())
				.toList();
	}
	
	public List<Double> getWindSpeeds(){
		return observations
				.stream()
				.map( d -> d.getWindSpeed())
				.toList();
	}
	
	public List<Double> getClouds(){
		return observations
				.stream()
				.map( d -> d.getCloudCover()/10d)
				.toList();
	}
	
}
