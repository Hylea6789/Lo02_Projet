package Source;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Joueur implements ScoreInterface {
	
	private Carte carteVictoire;
	private int numeroJoueur;
	private Strat�gieJoueur strat�gie ;
	private List<Carte> main;
	// Private Partie;
	
	public Joueur(int strategie) { //TODO Juste pour pouvoir initialiser partie (A SUPPRIMER)
		
	}
	
	public Joueur(int numeroJoueur,  Strat�gieJoueur strategie, Partie partie, Pioche pioche) { 
		// Rajouter partie, on en a besoin pour faire les m�thodes
		this.numeroJoueur = numeroJoueur;
		
		this.strat�gie = strategie;	
		this.carteVictoire = pioche.piocherCarte();
		this.main= new ArrayList();
		
		
	}
	
	public List getMain() {
		return this.main;
	}
	
	public void piocherCarte(Pioche pioche) {
		Carte carte = pioche.piocherCarte();
		System.out.println("tu as pioch� : " + carte);
		this.main.add(carte);
	}
	
	public Carte consulterCarteVictoire() {
		return this.carteVictoire;
	}
	
	public void consulterCarteMain(Partie partie) {
		
		if (partie.modeAvance() == false) { // une seule carte � montrer
			
			System.out.print("tu as en main : " + this.main.get(0));
		}
		else { // une � trois cartes
			System.out.print("tu as en main :");
			for (Carte carte : this.main) {
				System.out.print(" " + carte);
			}
		}
	}
	
	public boolean bougerCarteJoueur(List<Integer> positionCarte, List<Integer> positionFinale,Partie partie) {
		return partie.bougerCarte(positionCarte, positionFinale);
	}
	
	public boolean placerCarteJoueur(Carte carte, List<Integer> position, Partie partie) {
		System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
		return partie.ajouterCarte( position, carte);
	}
	
	public void  regarderPlateau(Partie partie) {
		partie.afficherPlateau();
	}
	

	public void tour(Partie partie,Pioche pioche) {
		if (partie.modeAvance()==false) {
			this.piocherCarte(pioche);
		}
		this.regarderPlateau(partie);
		this.consulterCarteVictoire();
		
		strat�gie.jouer(this,partie);
	
		
		this.regarderPlateau(partie);
		
		if (partie.modeAvance()==true) {
			this.piocherCarte(pioche);
		}
		
		partie.changerJoueur();
				
	}

	
	// Visteur

	@Override
	public void accept(ScoreVisitor visitor) {
		 visitor.visit(this);
	}
}


