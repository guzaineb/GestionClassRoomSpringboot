package tn.esprit.exam.service;

import tn.esprit.exam.entity.Classe;
import tn.esprit.exam.entity.CoursClassroom;
import tn.esprit.exam.entity.Niveau;
import tn.esprit.exam.entity.Specialite;

public interface IClassImp {
    public Classe ajouterClasse (Classe c);
    public CoursClassroom ajouterCoursClassroom (CoursClassroom cc, Integer codeClasse);
    public void desaffecterCoursClassroomClasse(Integer idCours);
    public Integer nbHeuresParSpecEtNiv(Specialite sp, Niveau nv);


}
