package jm.task.core.jdbc.model;

import lombok.*;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@ToString
@NoArgsConstructor
@Getter
//@Setter

@Entity
@Immutable
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="last_name")
    private String lastName;

    @Column(name="age")
    private Byte age;

    public User(String name, String lastName, Byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
}
