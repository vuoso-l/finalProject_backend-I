package com.example.finalProject_backendI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
@Getter
@Setter
@ToString
@Entity
@Table(name = "dentists")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String registrationNumber;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "dentist")
    @JsonIgnore
    @ToString.Exclude
    private Set<DentistShift> dentistShifts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Dentist dentist = (Dentist) o;
        return id != null && Objects.equals(id, dentist.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
