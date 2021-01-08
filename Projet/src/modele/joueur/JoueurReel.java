package modele.joueur;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import modele.Carte;
import modele.Partie;

public class JoueurReel implements StrategyJoueur{
	
	private int numCarteJouee = -1;
	private Joueur joueur;
	private Partie partie;
	
	private Scanner entreeJoueur = new Scanner(System.in);
	
	public JoueurReel(Partie partie) {
		this.partie = partie;
	}
	
	public void jouer(Joueur joueur,Partie partie) {
		
	}
	
	
	public void placerCarte(Joueur joueur) {
		int action;
		int i = 1;
		Iterator<Carte> it = joueur.getMain().iterator();
		while (it.hasNext()) {
			System.out.print(i + ": " + it.next() +"  ");
			i++;
		}
		System.out.print("Choix du num�ro de la carte � jouer :");
		
		do {
			action = this.entreeJoueur.nextInt();
		} while(action > joueur.tailleMain()||action<=0);
		
		numCarteJouee = action-1;
		
		Carte carte = (Carte) joueur.getMain().get(numCarteJouee);

		Map<List<Integer>,Boolean> plateauAjout = partie.ouAjouterCarte();
		Set<List<Integer>> listeDeCl�Libre = plateauAjout.keySet();
		Iterator<List<Integer>> it2 = listeDeCl�Libre.iterator();
	
		i=1;
		while (it2.hasNext()) {
			System.out.print(i + ": " + it2.next() +"  ");
			i++;
		}
		
		action=0;
		System.out.print("Choix de l'emplacement o� sera jou� la carte : ");
		do {
			action = this.entreeJoueur.nextInt();
		} while(action > listeDeCl�Libre.size()||action<=0);

		List<Integer> position =  (List<Integer>) listeDeCl�Libre.toArray()[action-1];
		
		
		joueur.placerCarteJoueur(carte, position);
	}
	
	
	public void bougerCarte(Joueur joueur) {
		Map<List<Integer>,Carte> plateau = partie.getPlateau();
		List<Integer>[] listeDeCl�Utilis� = (List<Integer>[]) plateau.keySet().toArray(new List[0]);
		int action;
		
		
		for (int i=0; i <listeDeCl�Utilis�.length;i++) {
			System.out.print((i+1) + ":" + listeDeCl�Utilis�[i]+"   ");
		}
		
		System.out.print("Emplacement de la carte � d�placer");
		
		do {
			action = this.entreeJoueur.nextInt();
		} while(action > listeDeCl�Utilis�.length||action<=0);

		List<Integer>Cl�CarteADeplacer = listeDeCl�Utilis�[action-1];			
		
		
		
		Map<List<Integer>,Boolean> EmplacementValide = partie.ouBougerCarte(Cl�CarteADeplacer);
		Set<List<Integer>> Cl�EmplacementValide = EmplacementValide.keySet();
		Iterator<List<Integer>>  it4 = Cl�EmplacementValide.iterator();
		
		int i = 1;
		while (it4.hasNext()) {
			System.out.print(i + ": " + it4.next()+"  ");
			i++;
		}
		
		
		System.out.print("Choix de l'emplacement o� sera d�plac� la carte");
		
		do {
			action = this.entreeJoueur.nextInt();
		} while(action > listeDeCl�Utilis�.length||action<=0);

		List<Integer> positionFinale =  (List<Integer>) Cl�EmplacementValide.toArray()[action-1];
		joueur.bougerCarteJoueur(Cl�CarteADeplacer, positionFinale);
	}
	
	@Override
	public int getDerniereCarte() {
		return this.numCarteJouee;
	}
}
