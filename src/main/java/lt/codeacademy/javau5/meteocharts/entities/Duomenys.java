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
	
}
