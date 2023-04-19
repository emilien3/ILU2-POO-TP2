package controleur;

import villagegaulois.Village;

public class ControlAfficherVillage {
	private Village village;

	public ControlAfficherVillage(Village village) {
		this.village = village;
	}
	
	

	public String[] donnerNomsVillageois() {
		return village.donnerVillageois();
	}

	public String donnerNomVillage() {
		return village.getNom();
	}

	public int donnerNbEtals() {
		return village.donnerNbEtal();
	}
}
