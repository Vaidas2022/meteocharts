package lt.codeacademy.javau5.meteocharts.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Station {
	String code;
	String name;
	
	Coordinates coordinates;
}
