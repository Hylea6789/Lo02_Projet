package modele.joueur;


import java.util.List;

import modele.Partie;

public interface Strat�gyJoueur {
	public void jouer(Joueur joueur,Partie partie) ;
	public int getDerniereCarte();
}
