package latice.model;

public class Joueur {
	private final String nom;
	private Integer points;
	private Integer nombreActionRestanteAJouer;
	private Integer nbTuilesPosees;
	private Rack rack;
	private Pioche pioche;
	
	//constructors
	public Joueur(String nom, Integer points, Integer actionsRestante, Integer nbTuilesPosees, Rack rack,
			Pioche pioche) {
		this.nom = nom;
		this.points = points;
		this.nombreActionRestanteAJouer = actionsRestante;
		this.nbTuilesPosees = nbTuilesPosees;
		this.rack = rack;
		this.pioche = pioche;
	}
	
	public Joueur(String nom,Pioche pioche) {
		this(nom, 0, 0, 0, new Rack(), pioche);
	}
	
	public Joueur(String nom) {
		this(nom, 0, 0, 0, new Rack(), new Pioche());
	}

	//comportement	
	public Joueur jouer() { //TODO joueur un tour
		boolean aJouer = false;
		Joueur suivant;	
		while (aJouer != true) {
				/* regarde actions
				 * lance en fonction des action 
				 * /!\ ne pas faire aJouer = this.acheterAction() */
		}
		suivant = finAction();
		return suivant;
	}
	
	public boolean poserTuile(int indiceTuileRack, Position positionDestination, PlateauDeCase plateauDeCases, PlateauTuiles plateauDeTuiles) {
//		Position positionPose = Position.position(indiceDestination);
		Tuile tuileAPoser = this.rack.obtenirTuile(indiceTuileRack);
		int nbTuilesAutour = plateauDeTuiles.combienDeTuileAutour(positionDestination);
		if (plateauDeTuiles.siTuilePosableIci(tuileAPoser, positionDestination)){
			this.nbTuilesPosees++;
			plateauDeTuiles.poser(positionDestination, this.rack.enlever(indiceTuileRack));
			
			if (plateauDeCases.donnerLaCaseAPosition(positionDestination).equals(new Case(Type.SOLEIL))) this.points++;
			if ( nbTuilesAutour == 2) this.points++;
			if ( nbTuilesAutour == 3) this.points = this.points + 2;
			if ( nbTuilesAutour == 4) this.points = this.points + 4;
			return true;
		} else { 
			return false;
		}
	}
	
	public boolean echangerRack() {
		if (this.pioche.taille()<5) return false; // TODO verifier ça fonctionne
		int i;
		for (i=0 ; i<this.pioche.taille() && i<5 ; i++) this.pioche.ajouter(this.rack.enlever(0));
		this.rack.remplirLeRack(this.pioche);
		this.pioche.melanger();
		return true;
	}
	
	public Boolean acheterAction() {
		if (this.points > 1) {
			this.nombreActionRestanteAJouer++;
			this.points = this.points - 2;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean passerAction() {
		return true;
	}
	
	public Joueur finAction() { //tous ce qu'on doit faire après qu'un joueur ait joué une action (à compléter)
		this.nombreActionRestanteAJouer--;
		if (this.nombreActionRestanteAJouer == 0) {
				//à l'autre joueur de jouer
			return null;
		} else {
			//le joueur continue
			return this;
		}
		
	}
	
	public void remplirSonRack() {
		this.rack.remplirLeRack(this.pioche);
	}

	//getter et setter
	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Rack getRack() {
		return rack;
	}

	public void setRack(Rack rack) {
		this.rack = rack;
	}

	public Pioche getPioche() {
		return pioche;
	}

	public void setPioche(Pioche pioche) {
		this.pioche = pioche;
	}
	
	public Integer getNombreActionRestanteAJouer() {
		return nombreActionRestanteAJouer;
	}

	public void setNombreActionRestanteAJouer(Integer nombreActionRestanteAJouer) {
		this.nombreActionRestanteAJouer = nombreActionRestanteAJouer;
	}

	public Integer getNbTuilesPosees() {
		return nbTuilesPosees;
	}

	public void setNbTuilesPosees(Integer nbTuilesPosees) {
		this.nbTuilesPosees = nbTuilesPosees;
	}

	public String getNom() {
		return nom;
	}

}
