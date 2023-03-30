package lesson1.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "actor")

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actor_id;

    @Column(name ="first_name")
    private String firstName;

    @Column(name ="last_name")
    private String lastName;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date last_update;

    public Actor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
