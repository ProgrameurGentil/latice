package latice;

import org.junit.jupiter.api.Test;

import latice.model.Constantes;
import latice.model.Position;
import latice.model.Type;

import static org.junit.jupiter.api.Assertions.*;

public class TestConstantes {

    @Test
    public void testDimensionsPlateau() {
        assertEquals(9, Constantes.COLONNES);
        assertEquals(9, Constantes.LIGNES);
    }

    @Test
    public void testCentrePlateau() {
        assertEquals(new Position(4, 4), Constantes.CENTRE);
    }

    @Test
    public void testCaseNormale() {
        assertNotNull(Constantes.CASENORMALE);
        assertEquals(Type.NORMAL, Constantes.CASENORMALE.getType());
    }

    @Test
    public void testListePositionSoleilNonVide() {
        assertNotNull(Constantes.POSITION_SOLEIL);
        assertEquals(16, Constantes.POSITION_SOLEIL.size());

        assertTrue(Constantes.POSITION_SOLEIL.contains(new Position(0, 0)));
        assertTrue(Constantes.POSITION_SOLEIL.contains(new Position(4, 0)));
        assertTrue(Constantes.POSITION_SOLEIL.contains(new Position(4, 8)));
        assertFalse(Constantes.POSITION_SOLEIL.contains(new Position(1, 0)));
    }

    @Test
    public void testTouteLesTuilesEstInitialisee() {
        assertNotNull(Constantes.TOUTE_LES_TUILES);
    }
}
