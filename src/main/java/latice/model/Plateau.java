package latice.model;

public class Plateau {
	private Joueur joueur1;
	private Joueur joueur2;
	private Case cases[][];
	
	public Plateau(Joueur joueur1, Joueur joueur2, Case[][] cases) {
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.cases = cases;
	}
}