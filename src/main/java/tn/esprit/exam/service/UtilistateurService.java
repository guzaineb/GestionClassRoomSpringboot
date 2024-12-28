package tn.esprit.exam.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.exam.entity.Classe;
import tn.esprit.exam.entity.Niveau;
import tn.esprit.exam.entity.Utilisateur;
import tn.esprit.exam.repository.ClasseRepository;
import tn.esprit.exam.repository.UtilisateurRepository;


@Service
@AllArgsConstructor
@Slf4j

public class UtilistateurService implements IUtilisateurImp{
    UtilisateurRepository userrepository;
    ClasseRepository classrepository;
    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
        return userrepository.save(utilisateur) ;
    }
    public void affecterUtilisateurClasse (Integer idUtilisateur, Integer codeClasse){
        Utilisateur utilisateur = userrepository.findById(idUtilisateur).get();
        Classe classe = classrepository.findById(codeClasse).get();
        utilisateur.setClasse(classe);
        userrepository.save(utilisateur);


    }

    @Override
    public Integer nbUtilisateursParNiveau(Niveau n) {
        return userrepository.nbUtilisateurParNiveau(n);
    }

}
