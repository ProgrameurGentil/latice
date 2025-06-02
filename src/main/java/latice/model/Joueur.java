package latice.model;

import java.util.ArrayList;
import java.util.List;

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
	
	public boolean poserTuile(int indiceTuileRack, Position positionDestination, PlateauDeCase plateauDeCases, PlateauTuiles plateauDeTuiles) {
//		Position positionPose = Position.position(indiceDestination);
		Tuile tuileAPoser = this.rack.obtenirTuile(indiceTuileRack);
		int nbTuilesAutour = plateauDeTuiles.combienDeTuileAutour(positionDestination);
		if (plateauDeTuiles.siTuilePosableIci(tuileAPoser, positionDestination) && this.encoreDesActions()){
			this.nbTuilesPosees++;
			plateauDeTuiles.poser(positionDestination, this.rack.enlever(indiceTuileRack));
			
			//System.out.println(positionDestination);
			if (plateauDeCases.donnerLaCaseAPosition(positionDestination).equals(new Case(Type.SOLEIL))) this.points++;
			if ( nbTuilesAutour == 2) this.points++;
			if ( nbTuilesAutour == 3) this.points = this.points + 2;
			if ( nbTuilesAutour == 4) this.points = this.points + 4;
			
			this.nombreActionRestanteAJouer--;
			return true;
		} else { 
			return false;
		}
	}
	
	public boolean echangerRack() {
		if (this.pioche.taille()<5 || this.points < 2) return false; // TODO verifier ça fonctionne
		int i;
		Rack rackDAttente = new Rack(this.rack.tuiles);
		this.points = this.points - 2;
		
		this.rack.enleverTout();
		remplirSonRack();
		
		for (i=0 ; i<this.pioche.taille() && i<rackDAttente.taille() ; i++) this.pioche.ajouter(rackDAttente.enlever(0));
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
	
	public Boolean encoreDesActions() {
		if (this.nombreActionRestanteAJouer == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public Integer verifierSiUnCoupEstPossible(PlateauTuiles plateauDeTuiles) {
		Integer nbTuileQuiPeutEtrePose = 0;
		Tuile tuile;
		Integer colonne=0;
		Integer ligne=0;
		Boolean estPosable = false;
		Position position;
		List<Position> listeDesPositionsDejaPrise = new ArrayList<Position>();
		
		for (int iRack=0 ; iRack < this.rack.taille() ; iRack++ ) {
			tuile = this.rack.obtenirTuile(iRack);
			ligne = 0;
			
			while (ligne < 9 && !estPosable) {
				colonne = 0;
				
				while (colonne < 9 && !estPosable) {
					
					position = new Position(colonne, ligne);
					if (plateauDeTuiles.siTuilePosableIci(tuile, position) && !listeDesPositionsDejaPrise.contains(position)) {
						estPosable = true;
						listeDesPositionsDejaPrise.add(position);
						nbTuileQuiPeutEtrePose++;
					}
					colonne++;
				}
				ligne++;
			}
			estPosable = false;
		}
		return nbTuileQuiPeutEtrePose;
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
	
	public Integer nombreDeTuilesToTal() {
		return getPioche().taille() + getRack().taille();
	}

}
