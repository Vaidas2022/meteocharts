package lt.codeacademy.javau5.meteocharts.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="observations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Observation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	String observationTimeUtc;
    double airTemperature;
    double feelsLikeTemperature;
    double windSpeed;
    double windGust;
    double windDirection;
    double cloudCover;
    double seaLevelPressure;
    double relativeHumidity;
    double precipitation;
    String conditionCode;
    
}
