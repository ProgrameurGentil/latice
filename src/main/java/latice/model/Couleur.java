package latice.model;

public enum Couleur {
	ROUGE("rouge"),
	BLEU("bleu"),
	JAUNE("jaune"),
	ROSE("rose"),
	VERT("vert"),
	BLEU_FONCE("bleu_fonce");
	
	private final String nom;
	
	Couleur(String nom) {
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return this.nom;
	}
}