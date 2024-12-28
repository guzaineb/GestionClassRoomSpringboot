package tn.esprit.exam.service;

import tn.esprit.exam.entity.Niveau;
import tn.esprit.exam.entity.Utilisateur;

public interface IUtilisateurImp {
    public Utilisateur ajouterUtilisateur (Utilisateur utilisateur);
    public void affecterUtilisateurClasse (Integer idUtilisateur, Integer codeClasse);
    public Integer nbUtilisateursParNiveau(Niveau n);

}
