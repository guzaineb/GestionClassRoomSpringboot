package tn.esprit.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.exam.entity.Classe;
import tn.esprit.exam.entity.Niveau;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Integer> {
     }
