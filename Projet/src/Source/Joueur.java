package Source;

public class Joueur {
	
	private Carte carteVictoire;
	private int numeroJoueur;
	private int action;
	private boolean human;
	private Pioche pioche;
	private Carte[] main = new Carte[3]; // Utiliser collection pour mode avanc� ?
	// Private Partie;
	
	public Joueur(Pioche pioche, int numeroJoueur, boolean human) { 
		// Rajouter partie, on en a besoin pour faire les m�thodes
		this.numeroJoueur = numeroJoueur;
		this.human = human;	
		this.pioche = pioche;
		this.carteVictoire = pioche.piocherCarte();
		// this.partie = partie
		
		//Si en mode avanc� pioche 3 cartes
		piocherCarte();
	}
	
	public void piocherCarte() {
		Carte carte = pioche.piocherCarte();
		System.out.println("tu as pioch� : " + carte);
		main[1] = carte;		
	}
	
	public Carte consulterCarteVictoire() {
		return this.carteVictoire;
	}
	
	public void consulterCarteMain() {
		System.out.println("tu as en main : " + this.main[1]);
		
		// a modifier pour mode avanc�
	}
	
	// M�thodes n�cessitant partie
	public void placerCarte() {
		
	}
	
	public void bougerCarte() {
		
	}
	
	public void regarderPlateau() {
		
	}
	
	
	// Visteur
	public void accepterVisiteur() {
		
	}
	
	
	public static void main(String[] args) {
		Pioche pioche = new Pioche();
		Joueur joueur = new Joueur(pioche,1,true);
		System.out.println(joueur.carteVictoire);
	}
}
