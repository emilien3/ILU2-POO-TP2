package controleur;

import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

public class ControlEmmenager {
	private Village village;

	public ControlEmmenager(Village village) {
		this.village = village;
	}

	public boolean isHabitant(String nom) {
		return village.trouverHabitant(nom) != null;
	}

	public void ajouterDuide(String nom, int force, int effetPotionMin,
			int effetPotionMax) {
		Druide druide = new Druide(nom, force, effetPotionMin, effetPotionMax);
		village.ajouterHabitant(druide);

	}

	public void ajouterGaulois(String nom, int force) {
		Gaulois gaulois = new Gaulois(nom, force);
		village.ajouterHabitant(gaulois);
	}

}
