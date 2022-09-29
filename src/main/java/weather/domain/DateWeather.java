package weather.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name ="date_weather")
public class DateWeather {
    @Id
    private LocalDate date;

    private String weather;
    private String icon;
    private Double temperature;
}
