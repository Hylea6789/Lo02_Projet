package Source;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class JoueurReel implements Strat�gieJoueur{
	public void jouer(Joueur joueur,Partie partie) {
		
		Scanner EntreeJoueur = new Scanner(System.in);

		System.out.println("D�roulement de votre tour?");
		 int action = EntreeJoueur.nextInt();
		
		if (action==0) {
				Iterator it = joueur.getMain().iterator();
				while (it.hasNext()) {
					System.out.print(it.next()+"  ");
				}
				System.out.println("Choix du num�ro de la carte � jouer");
				Carte carte = (Carte) joueur.getMain().get(EntreeJoueur.nextInt()-1);

				Map<List<Integer>,Boolean> plateauAjout = partie.ouAjouterCarte();
				Set<List<Integer>> ListeDeCl�Libre = plateauAjout.keySet();
				Iterator it2 = ListeDeCl�Libre.iterator();
				while (it2.hasNext()) {
					System.out.print(it2.next()+"  ");
				}
				System.out.println("Choix de l'emplacement o� sera jou� la carte");

				List<Integer> position =  (List<Integer>) ListeDeCl�Libre.toArray()[EntreeJoueur.nextInt()-1];
				
				
				joueur.placerCarteJoueur(carte, position, partie);
			
		}
		if (action==1) {
			Iterator it = joueur.getMain().iterator();
			while (it.hasNext()) {
				System.out.print(it.next()+"  ");
			}
			System.out.println("Choix du num�ro de la carte � jouer");
			Carte carte = (Carte) joueur.getMain().get(EntreeJoueur.nextInt()-1);

			Map<List<Integer>,Boolean> plateauAjout = partie.ouAjouterCarte();
			Set<List<Integer>> ListeDeCl�Libre = plateauAjout.keySet();
			Iterator it2 = ListeDeCl�Libre.iterator();
			while (it2.hasNext()) {
				System.out.print(it2.next()+"  ");
			}
			System.out.println("Choix de l'emplacement o� sera jou� la carte");

			List<Integer> position =  (List<Integer>) ListeDeCl�Libre.toArray()[EntreeJoueur.nextInt()-1];
			
			
			joueur.placerCarteJoueur(carte, position, partie);
			
			joueur.regarderPlateau(partie);
			

			Map<List<Integer>,Carte> plateau = partie.getPlateau();
			List<Integer>[] ListeDeCl�Utilis� = (List<Integer>[]) plateau.keySet().toArray(new List[0]);
			for (int i=0; i <ListeDeCl�Utilis�.length;i++) {
				System.out.print(ListeDeCl�Utilis�[i]+"   ");
			}
			System.out.println("Emplacement de la carte � d�placer");
			List<Integer>Cl�CarteADeplacer = ListeDeCl�Utilis�[EntreeJoueur.nextInt()-1];			
			
			
			
			Map<List<Integer>,Boolean> EmplacementValide = partie.ouBougerCarte(Cl�CarteADeplacer);
			Set<List<Integer>> Cl�EmplacementValide = EmplacementValide.keySet();
			Iterator it4 = Cl�EmplacementValide.iterator();
			while (it4.hasNext()) {
				System.out.print(it4.next()+"  ");
			}
			System.out.println("Choix de l'emplacement o� sera d�plac� la carte");
			List<Integer> positionFinale =  (List<Integer>) Cl�EmplacementValide.toArray()[EntreeJoueur.nextInt()-1];
			joueur.bougerCarteJoueur(Cl�CarteADeplacer, positionFinale, partie);

		}
		if(action==2) {			

			Map<List<Integer>,Carte> plateau = partie.getPlateau();
			List<Integer>[] ListeDeCl�Utilis� = (List<Integer>[]) plateau.keySet().toArray(new List[0]);
			for (int i=0; i <ListeDeCl�Utilis�.length;i++) {
				System.out.print(ListeDeCl�Utilis�[i]+"   ");
			}
			System.out.println("Emplacement de la carte � d�placer");
			List<Integer>Cl�CarteADeplacer = ListeDeCl�Utilis�[EntreeJoueur.nextInt()-1];			
			
			
			
			Map<List<Integer>,Boolean> EmplacementValide = partie.ouBougerCarte(Cl�CarteADeplacer);
			Set<List<Integer>> Cl�EmplacementValide = EmplacementValide.keySet();
			Iterator it4 = Cl�EmplacementValide.iterator();
			while (it4.hasNext()) {
				System.out.print(it4.next()+"  ");
			}
			System.out.println("Choix de l'emplacement o� sera d�plac� la carte");
			List<Integer> positionFinale =  (List<Integer>) Cl�EmplacementValide.toArray()[EntreeJoueur.nextInt()-1];
			joueur.bougerCarteJoueur(Cl�CarteADeplacer, positionFinale, partie);
			

			joueur.regarderPlateau(partie);
			
			
			Iterator it = joueur.getMain().iterator();
			while (it.hasNext()) {
				System.out.print(it.next()+"  ");
			}
			System.out.println("Choix du num�ro de la carte � jouer");
			Carte carte = (Carte) joueur.getMain().get(EntreeJoueur.nextInt()-1);

			Map<List<Integer>,Boolean> plateauAjout = partie.ouAjouterCarte();
			Set<List<Integer>> ListeDeCl�Libre = plateauAjout.keySet();
			Iterator it2 = ListeDeCl�Libre.iterator();
			while (it2.hasNext()) {
				System.out.print(it2.next()+"  ");
			}
			System.out.println("Choix de l'emplacement o� sera jou� la carte");

			List<Integer> position =  (List<Integer>) ListeDeCl�Libre.toArray()[EntreeJoueur.nextInt()-1];
			
			
			joueur.placerCarteJoueur(carte, position, partie);
		}
		
	}
}
