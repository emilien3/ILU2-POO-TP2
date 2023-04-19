package personnages;

import villagegaulois.Village;

public class Chef extends Gaulois {
	private Village village;

	public Chef(String nom, int force, Village village) {
		super(nom, force);
		this.village = village;
	}

	@Override
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	@Override
	protected String prendreParole() {
		return "Le chef " + nom + " du village " + village.getNom() + " : ";
	}
}
