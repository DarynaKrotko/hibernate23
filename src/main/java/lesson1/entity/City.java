package lesson1.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "city")

@NoArgsConstructor
@Getter
@Setter
@ToString
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int city_id;

    private String city;

    private int country_id;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date last_update;

    public City(String city, int country_id) {
        this.city = city;
        this.country_id = country_id;
    }
}
