package personnages;

public class Gaulois extends Personnage {
	private int effetPotion = 1;

	public Gaulois(String nom, int force) {
		super(nom, force);
	}

	@Override
	protected String prendreParole() {
		return "Le gaulois " + super.prendreParole();
	}

	@Override
	public String toString() {
		String etatPersonnage = super.toString();
		return "Gaulois "
				+ etatPersonnage.substring(0, etatPersonnage.length() - 1)
				+ ", effetPotion=" + effetPotion + "]";
	}

	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion
				+ " fois décuplée.");
	}
}
