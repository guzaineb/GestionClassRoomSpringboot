package tn.esprit.exam.control;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.exam.entity.Chambre;
import tn.esprit.exam.entity.Niveau;
import tn.esprit.exam.entity.Utilisateur;
import tn.esprit.exam.service.IUtilisateurImp;

@Tag(name = "Ce Web Service gère le CRUD pour une utilisateur")
@RestController
@AllArgsConstructor
@RequestMapping("/Utilisateur")
public class UtilisateurController {
    private IUtilisateurImp utilisateurImp;
    @PostMapping("/add-utilisateur")
    public Utilisateur addUser(@RequestBody Utilisateur c) {
        Utilisateur utilisateur = utilisateurImp.ajouterUtilisateur(c) ;
        return utilisateur;
    }
    @PutMapping("/affecterUtilisateurClasse/{idUtilisateur}/{codeClasse}")
    public void affecterUtilisateurClasse ( @PathVariable("idUtilisateur")  Integer idUtilisateur, @PathVariable("codeClasse") Integer codeClasse){
        utilisateurImp.affecterUtilisateurClasse(idUtilisateur, codeClasse);
    }
    @GetMapping("/nb-utilisateur-par-niveau/{niveau}")
    public Integer nbUtilisateurParNiveau(@PathVariable("niveau") Niveau niveau) {
        return utilisateurImp.nbUtilisateursParNiveau(niveau);
    }




}
