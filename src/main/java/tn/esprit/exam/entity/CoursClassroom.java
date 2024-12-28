package tn.esprit.exam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CoursClassroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCours;
    private String name;
    private boolean archive;
    private Integer nbHeures;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    private Classe classe;



}
