package lesson1.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user_table")

@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name= "user_id")

    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> skills = new ArrayList<>();

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date lastUpdate;

    public User(String name, List<String> skills, Gender gender) {
        this.name = name;
        this.skills = skills;
        this.gender = gender;
    }
}
