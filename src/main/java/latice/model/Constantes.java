package latice.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Constantes {
	public static final int COLONNES = 9;
	public static final int LIGNES = 9;
	public static final ArrayList<Position> POSITION_SOLEIL = new ArrayList<>(Arrays.asList(
			new Position(0,0),new Position(1,1),new Position(2,2),
			new Position(0,8),new Position(1,7),new Position(2,6),
			new Position(8,8),new Position(7,7),new Position(6,6),
			new Position(8,0),new Position(7,1),new Position(6,2),
			new Position(0,4),new Position(4,0),new Position(8,4),new Position(4,8)));
	
	public static final Position CENTRE = new Position(4,4);
	
	public static final  Case CASENORMALE = new Case();
}
