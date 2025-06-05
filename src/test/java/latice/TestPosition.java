package latice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import latice.model.Position;

public class TestPosition {
	/* La positon est definit par Colonne Ligne */
	
	Position pos1 = new Position(5, 4);
	Position pos2 = new Position(7, 5);
	Position pos3 = new Position(5, 4);
	Position pos4 = new Position(5, 5);
	Position pos5 = new Position(0, 0);
	Position pos6 = new Position(1, -7);

	private static final Position POSITION_NULL = new Position(null, null);
	
	@Test
	public void testsDEgalitesSurDesPositions() {
		assertEquals(pos1, pos3);
		assertNotEquals(pos1, pos5);
		assertNotEquals(pos6, pos2);
	}
	
	@Test
	public void testDesPostionsAutourDeLaPositon1() {
		/* la fonction caseAutour retourne les positons comme ceci : Dessus - Droit - Bas - Gauche 
		 * Position 1 : colonne : 5, ligne : 4*/
		
		List<Position> positionsAutourDePos1 = pos1.positionAutour();
		
		assertEquals(positionsAutourDePos1.get(0), new Position(5, 3));
		assertEquals(positionsAutourDePos1.get(1), new Position(6, 4));
		assertEquals(positionsAutourDePos1.get(2), new Position(5, 5));
		assertEquals(positionsAutourDePos1.get(3), new Position(4, 4));
	}
	
	@Test
	public void testDesPostionsAutourDeLaPositon5() {
		/* la fonction caseAutour retourne les positons comme ceci : Dessus - Droit - Bas - Gauche 
		 * Position 5 : colonne : 0, ligne : 0*/
		
		List<Position> positionsAutourDePos5 = pos5.positionAutour();

		assertNull(positionsAutourDePos5.get(0));
		assertEquals(positionsAutourDePos5.get(1), new Position(1, 0));
		assertEquals(positionsAutourDePos5.get(2), new Position(0, 1));
		assertNull(positionsAutourDePos5.get(3));
	}
	
	@Test
	public void testDesPostionsAutourDeLaPositon6() {
		/* la fonction caseAutour retourne les positons comme ceci : Dessus - Droit - Bas - Gauche 
		 * Position 1 : colonne : 1, ligne : -7*/
		
		List<Position> positionsAutourDePos6 = pos6.positionAutour();
		
		assertNull(positionsAutourDePos6.get(0));
		assertNull(positionsAutourDePos6.get(1));
		assertNull(positionsAutourDePos6.get(2));
		assertNull(positionsAutourDePos6.get(3));
	}
}
