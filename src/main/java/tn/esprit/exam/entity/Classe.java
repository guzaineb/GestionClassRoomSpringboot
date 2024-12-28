package tn.esprit.exam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer codeClasse;
    private String titre;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    @JsonIgnore
    @OneToMany(mappedBy = "classe", cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private Set<CoursClassroom> coursClassrooms;
}
