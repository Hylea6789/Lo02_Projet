package Source;

import java.util.List;
import java.util.Map;

public class ContextPlateau {
	   private StrategyPlateau strategy;

	   public ContextPlateau(StrategyPlateau strategy){
	      this.strategy = strategy;
	   }
	   
	   public void getBorne(Map<List<Integer>, Carte> plateau) {
		   strategy.getBorne(plateau);
	   }

	   public Map<List<Integer>, Boolean> ouAjouterCarte(Map<List<Integer>, Carte> plateau){
	      return strategy.ouAjouterCarte(plateau);
	   }
	   
	   public Map<List<Integer>, Boolean> ouBougerCarte(Map<List<Integer>, Carte> plateau, List<Integer> positionCarte){
		      return strategy.ouBougerCarte(plateau, positionCarte);
	   }
	   
	   public void afficherPlateau(Map<List<Integer>,Carte> plateau, Map<List<Integer>,Boolean> plateauBool) {
		   strategy.afficherPlateau(plateau,plateauBool);
	   }

	   public void initialiserPosition(List<Integer> position) {
		 strategy.initialiserPosition(position);
		
	}
}
