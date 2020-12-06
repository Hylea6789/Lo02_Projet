package source;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class IAAleatoire implements Strat�gieJoueur{
	
	int numCarteJouee = -1;
	
	public void jouer(Joueur joueur,Partie partie) {
		
		Random random = new Random();
		

		int Aleatoire = (int) random.nextInt(2);
		
		if (Aleatoire==0) {
			Map<List<Integer>,Boolean> plateauAjout = partie.ouAjouterCarte();
			Set<List<Integer>> ListeDeCl�Libre = plateauAjout.keySet();
			
			this.numCarteJouee = random.nextInt(joueur.getMain().size());
			
			Carte carte = (Carte) joueur.getMain().get(numCarteJouee);
			List<Integer> place =  (List<Integer>) ListeDeCl�Libre.toArray()[random.nextInt(ListeDeCl�Libre.size())];
			
			joueur.placerCarteJoueur(carte,place);
			
		}
		if (Aleatoire==1) {
			Map<List<Integer>,Boolean> plateauAjout = partie.ouAjouterCarte();
			Set<List<Integer>> ListeDeCl�Libre = plateauAjout.keySet();
			
			this.numCarteJouee = random.nextInt(joueur.getMain().size());
			Carte carte = (Carte) joueur.getMain().get(this.numCarteJouee);
			List<Integer> place =  (List<Integer>) ListeDeCl�Libre.toArray()[random.nextInt(ListeDeCl�Libre.size())];
			
			
			joueur.placerCarteJoueur(carte,place);
			
			joueur.affPlateau();
			

			Map<List<Integer>,Carte> plateau = partie.getPlateau();
			List<Integer>[] ListeDeCl�Utilis� = (List<Integer>[]) plateau.keySet().toArray(new List[0]);
			List<Integer>Cl�CarteADeplacer = ListeDeCl�Utilis�[random.nextInt(ListeDeCl�Utilis�.length)];			
			Map<List<Integer>,Boolean> EmplacementValide = partie.ouBougerCarte(Cl�CarteADeplacer);
			Set<List<Integer>> Cl�EmplacementValide = EmplacementValide.keySet();
			List<Integer> positionFinale =  (List<Integer>) Cl�EmplacementValide.toArray()[random.nextInt(Cl�EmplacementValide.size())];
			joueur.bougerCarteJoueur(Cl�CarteADeplacer, positionFinale);



		}
		
		if(Aleatoire==2) {
			List<Integer> positionCarte = new ArrayList<Integer>();
			List<Integer> positionFinale = new ArrayList<Integer>();
			boolean fin1 = false;
			while (fin1 == false) {
				positionCarte.add((int)random.nextInt(),(int)random.nextInt());
				positionFinale.add((int)random.nextInt(),(int)random.nextInt());

				joueur.bougerCarteJoueur(positionCarte, positionFinale);
			}			
			
			
			Map<List<Integer>,Boolean> plateau = partie.ouAjouterCarte();
			Set<List<Integer>> cl� = plateau.keySet();
			
			this.numCarteJouee = random.nextInt(joueur.getMain().size());
			Carte carte = (Carte) joueur.getMain().get(this.numCarteJouee);
			List<Integer> place =  (List<Integer>) cl�.toArray()[random.nextInt(cl�.size())];
			
			
			
			joueur.placerCarteJoueur(carte,place);
			

		}
		
	}
	
	@Override
	public int getDerniereCarte() {
		return this.numCarteJouee;
	}
}