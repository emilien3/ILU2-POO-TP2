package frontiere;

import controleur.ControlAfficherVillage;

public class BoundaryAfficherVillage {
	private ControlAfficherVillage controlAfficherVillage;

	public BoundaryAfficherVillage(
			ControlAfficherVillage controlAfficherVillage) {
		this.controlAfficherVillage = controlAfficherVillage;
	}

	public void afficherVillage() {
		String nomVillage = controlAfficherVillage.donnerNomVillage();
		String[] donneesVillage = controlAfficherVillage.donnerNomsVillageois();
		System.out.println("Bienvenue dans " + nomVillage
				+ " dirigé par le chef " + donneesVillage[0] + ".");
		System.out.println("Ce village possède un joli marché avec "
				+ controlAfficherVillage.donnerNbEtals()
				+ " étals mis à la disposition des villageois afin qu'ils puissent vendre leurs produits.");
		if (donneesVillage.length > 1) {
			System.out.println("En plus du chef, il y a "
					+ (donneesVillage.length - 1) + " habitants : ");
			for (int i = 1; i < donneesVillage.length; i++) {
				String gaulois = donneesVillage[i];
				System.out.println("- " + gaulois);
			}
		} else {
			System.out.println(
					"Pour l'instant, le chef est bien seul dans son village.");
		}
	}

}
