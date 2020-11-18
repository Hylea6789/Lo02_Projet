package Source;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Scanner;

import Source.Carte.Couleur;
import Source.Carte.Forme;

public class Partie implements ScoreInterface {
	// pattern strat�gie pour forme plateau
	private Map<List<Integer>,Carte> plateau = new HashMap<List<Integer>,Carte>(); // plateau de jeu qui lie position et carte
	private Map<List<Integer>,Boolean> plateauBool = new HashMap<List<Integer>,Boolean>(); // plateau contenant les posititons ou on peut mettre des cartes
	
	private Map<List<Integer>,Boolean> plateauBoolCarte = new HashMap<List<Integer>,Boolean>(); // plateau contenant les emplacement o� on on peut BOUGER UNE carte
	private Carte carteABouger;
	
	private Scanner clavier = new Scanner(System.in);
	
	// Joueurs de la partie
	private Joueur[] joueur = new Joueur[3];
	
	private ContextPlateau context; // Stock strat�gie utilis�e
	
	
	private int nbrJoueur;
	private boolean modeAvance = false; //provisoire, pas de mode avanc� pour l'instant
	private Carte carteCachee; // Stock carte cach�e
	
	
	
	public Partie() {
		this.context = new ContextPlateau(new PlateauRectangle());// Pour l'instant que des plateaux rectangles
		
		//initialisation position de la 1er carte en (0,0)
		List<Integer> position = new ArrayList<Integer>();
		position.add(0,0);
		position.add(1,0);
		
		//intialisation plateau bool�en
		this.plateauBool.put(position,true);
		this.context.getBorne(this.plateau);
		
		//initialisation pioche
		Pioche pioche = new Pioche();
		this.carteCachee = pioche.piocherCarte();
		
		//initialisation joueurs
		/*
		do {
			System.out.println("combien de joueurs (2 ou 3) :");
			this.nbrJoueur = clavier.nextInt();
			
			if(this.nbrJoueur == 2) {
				//rajouter possibilit� cr�er joueur IA
				this.joueur1 = new Joueur (pioche,1,true,this);
				this.joueur2 = new Joueur (pioche,2,true,this);
			}
			else if(this.nbrJoueur == 3) {
				//rajouter possibilit� cr�er joueur IA
				this.joueur1 = new Joueur (pioche,1,true,this);
				this.joueur2 = new Joueur (pioche,2,true,this);
				this.joueur3 = new Joueur (pioche,3,true,this);
			}
		}while(this.nbrJoueur =! 2 && this.nbrJoueur =! 3);
		
		*/
	}
	
	
	//Ses 2 m�thodes seront �crite via un pattern strategy
	
	// Prend en entr�e le plateau et en sortie donne un autre plateau de booleen avec o� rajouter carte
	public void ouAjouterCarte() {
		this.plateauBool = context.ouAjouterCarte(this.plateau);
	}
	
	// Prend en entr�e le plateau et en sortie donne un autre plateau de booleen avec o� bougerCarte carte
	// donne en sortie vraie si on peux bouger la carte
	public Boolean ouBougerCarte(List<Integer> position) {
		
		if (plateau.get(position)==null){
			return false;
		}
		else {
			this.plateauBool = context.ouBougerCarte(this.plateau,position);
			this.carteABouger = plateau.get(position);
			return true;
		}
	}
	
	
	
	public Boolean ajouterCarte(List<Integer> position, Carte carte) {
		
		if (this.plateauBool.containsKey(position)) {
			this.plateau.put(position,carte); // rajout de carte dans plateau
			return true; // retourne que la care a �t� ajout�e
		}
		else {
			System.out.println("impossible de rajouter la carte ici");
			return false; // retourne que la carte n'a pas �t� ajout�e
		}
			
		/*
		// utilisateur rentre valeur
		System.out.println("");
		System.out.print("PositionX = ");
		position.add(clavier.nextInt());
		System.out.print("PositionY = ");
		position.add(clavier.nextInt());
		
		while (plateauBool.containsKey(position)==false) {
			System.out.println("impossible de poser une carte sur cette case");
			System.out.print("PositionX = ");
			position.set(0,clavier.nextInt());
			System.out.print("PositionY = ");
			position.set(1,clavier.nextInt());
		}
		Carte carte = new Carte(Couleur.rouge,Forme.carre,true); // place carte de couleur rouge carr� pleine
		this.plateauBool.put(position,true);
		
		//ajout de la valeur
		
		*/
	}
	
	public Boolean bougerCarte(List<Integer> positionCarte, List<Integer> positionFinale) {
		
		if (this.plateauBool.containsKey(positionFinale)==false) { //On ne peux pas bouger la carte sur cette case
			System.out.println("la carte ne peux pas �tre boug�e ici");
			return false;
		}
		else {
			this.plateau.remove(positionCarte); // on enl�ve la carte du plateau pour la remettre dans une nouvelle position
			this.plateau.put(positionFinale,carteABouger); 

			ouAjouterCarte();
			return true;
		}

		/*
		boolean carteBougee = false;
		Carte carte;		
		
		while (carteBougee==false)  {
			System.out.println("");
			System.out.print("PositionX = ");
			position.add(clavier.nextInt());
			System.out.print("PositionY = ");
			position.add(clavier.nextInt());
		
			if (!(plateau.containsKey(position))) {
				System.out.println("cette carte n'existe pas");
			}
			else {
				ouBougerCarte(position);
				if (plateauBool.size() == 0) {
					System.out.println("cette carte ne bouge pas");
				}
				else {
					afficherPlateau();
					carte = plateau.get(position);
					plateau.remove(position);
				
					while (carteBougee==false) {
						System.out.print("PositionX = ");
						position.set(0,clavier.nextInt());
						System.out.print("PositionY = ");
						position.set(1,clavier.nextInt());
					
						if (plateauBool.containsKey(position)==false) {
							System.out.println("cette carte ne peux pas bouger sur cette case");
						}
						else {
							plateau.put(position, carte);
							carteBougee = true;					
						}
					}
				}
			} 
		}
		
		*/
	}
	
	
	public void afficherPlateau() {
		context.afficherPlateau(this.plateau, this.plateauBool);
	}
	
	public void changerJoueur() {
		// Rajouter m�thodes pour changer de joueurs
		
		ouAjouterCarte();
	}
	
	public boolean modeAvance() { // joueur a besoin de savoir si on est en mode avanc�
		return this.modeAvance;
	}
	
	public Map<List<Integer>,Carte> getPlateau() {
		return this.plateau;
	}
	
	public Joueur[] getJoueur() {
		return joueur;
	}
	
	//visiteur
	@Override
	public void accept(ScoreVisitor visitor) {
		 visitor.visit(this);
	}
	
	
	//test
	public static void main(String[] args) {
		Partie partie = new Partie();
		Carte carte = new Carte(Couleur.rouge,Forme.carre,true);
		
		//Exemple fonctionnement du code partie
		
		// On ajoute une carte en (0,0)
		List <Integer> position = new ArrayList<Integer>();
		position.add(0,0);
		position.add(1,0);
		partie.afficherPlateau();
		partie.ajouterCarte(position, carte);
		partie.changerJoueur();
		partie.afficherPlateau();
		
		
		// On ajoute une carte en (1,0)
		position = new ArrayList<Integer>();
		position.add(0,1);
		position.add(1,0);
		partie.ajouterCarte(position, carte);
		partie.changerJoueur();
		partie.afficherPlateau();
		
		//on bouge la carte en (1,0)
		System.out.println(partie.ouBougerCarte(position));
		partie.afficherPlateau();
		partie.ouAjouterCarte();
		
		
		// On ajoute une carte en (1,1)
		position = new ArrayList<Integer>();
		position.add(0,1);
		position.add(1,1);
		partie.ajouterCarte(position, carte);
		partie.changerJoueur();
		partie.afficherPlateau();
		
		//on bouge la carte en (1,1) en (0,1)
		System.out.println(partie.ouBougerCarte(position));
		partie.afficherPlateau();
		List <Integer> positionCarte = new ArrayList<Integer>();
		positionCarte.add(0,0);
		positionCarte.add(1,1);
		System.out.println(partie.bougerCarte(position,positionCarte));
		partie.afficherPlateau();

		
		// On ajoute une carte en (2,2) (Impossible)
		position = new ArrayList<Integer>();
		position.add(0,2);
		position.add(1,2);
		partie.ajouterCarte(position, carte);
	}



}
