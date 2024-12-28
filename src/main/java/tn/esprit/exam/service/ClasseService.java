package tn.esprit.exam.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.exam.entity.Classe;
import tn.esprit.exam.entity.CoursClassroom;
import tn.esprit.exam.entity.Niveau;
import tn.esprit.exam.entity.Specialite;
import tn.esprit.exam.repository.ClasseRepository;
import tn.esprit.exam.repository.CoursClassroomRepository;

import java.util.List;

@Service
@AllArgsConstructor

@Slf4j
@EnableScheduling
public class ClasseService implements IClassImp {
    private ClasseRepository classeRepository;
    private CoursClassroomRepository coursClassroomRepository;


    @Override
    public Classe ajouterClasse(Classe c) {
        return classeRepository.save(c);
    }

    @Override
    public CoursClassroom ajouterCoursClassroom(CoursClassroom cc, Integer codeClasse)
    {   Classe c = classeRepository.findById(codeClasse).get();
        cc.setClasse(c);
        return coursClassroomRepository.save(cc);
    }

    @Override
    public void desaffecterCoursClassroomClasse(Integer idCours) {
        CoursClassroom cc = coursClassroomRepository.findById(idCours).get();
        cc.setClasse(null);
        coursClassroomRepository.save(cc);
    }

    @Override
    public Integer nbHeuresParSpecEtNiv(Specialite sp, Niveau nv) {
        return coursClassroomRepository.nbHeuresParSpecialiteEtdNiveau(sp, nv);
    }

    @Scheduled(fixedRate = 600000)
    public void archiverCoursClassrooms(){
        List<CoursClassroom> ccs= coursClassroomRepository.findAll();

        for (CoursClassroom coursClassroom : ccs) {
            coursClassroom.setArchive(true);
            coursClassroomRepository.save(coursClassroom);

        }


    }


}
