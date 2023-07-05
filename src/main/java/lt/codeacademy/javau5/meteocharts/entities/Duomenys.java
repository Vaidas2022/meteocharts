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
}
