package tn.esprit.exam.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.exam.entity.Classe;
import tn.esprit.exam.entity.CoursClassroom;
import tn.esprit.exam.entity.Niveau;
import tn.esprit.exam.entity.Specialite;
import tn.esprit.exam.service.ClasseService;
import tn.esprit.exam.service.IClassImp;

@Tag(name = "classe")
@RestController
@AllArgsConstructor
@RequestMapping("/classe")
public class ClasseController {
    private IClassImp classImp;
    @PostMapping("/addclasse")
    public Classe ajouterClasse (Classe c){
        return classImp.ajouterClasse(c);

    }
@PostMapping("/classroom/{id}")
    public CoursClassroom ajouterCoursClassroom(@RequestBody CoursClassroom cc,@PathVariable("id") Integer codeClasse)
    {
        return classImp.ajouterCoursClassroom(cc, codeClasse);
    }
@DeleteMapping("/desaffecterCoursClassroomClasse/{idCours}")
    public void desaffecterCoursClassroomClasse(@PathVariable ("idCours") Integer idCours) {
        classImp.desaffecterCoursClassroomClasse(idCours);
    }


    @GetMapping("nbHeuresParSpecEtNiv/{sp}/{nv}")
    public Integer nbHeuresParSpecEtNiv(@PathVariable("sp")  Specialite sp,@PathVariable("nv") Niveau nv) {
    return classImp.nbHeuresParSpecEtNiv(sp, nv);
    }
}
