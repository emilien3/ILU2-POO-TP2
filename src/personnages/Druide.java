package personnages;

import java.util.Random;

public class Druide extends Gaulois {
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;

	public Druide(String nom, int force, int effetPotionMin,
			int effetPotionMax) {
		super(nom, force);
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom
				+ " et ma potion peut aller d'une force " + effetPotionMin
				+ " à " + effetPotionMax + ".");
	}

	public void preparerPotion() {
		Random random = new Random();
		forcePotion = (random.nextInt(effetPotionMax - effetPotionMin))
				+ effetPotionMin;
		String texte = "";
		if (forcePotion > 7) {
			texte += "J'ai préparé une super potion ";
		} else {
			texte += "Je n'ai pas trouvé tous les ingrédients, ma potion est seulement ";
		}
		parler(texte + "de force " + forcePotion + ".");
	}

	public void booster(Gaulois gaulois) {
		if (gaulois.getNom().equals("Obélix")) {
			parler("Non, Obélix !... Tu n'auras pas de potion magique !");
		} else {
			gaulois.boirePotion(forcePotion);
		}
	}

	@Override
	protected String prendreParole() {
		return "Le druide " + nom + " : ";
	}
}
