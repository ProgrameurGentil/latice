package latice;

import org.junit.jupiter.api.Test;

import latice.model.Case;
import latice.model.Constantes;
import latice.model.PlateauDeCase;
import latice.model.Position;
import latice.model.Type;

import static org.junit.jupiter.api.Assertions.*;

public class TestPlateauDeCase {

    @Test
    public void testConstructeurCreeMapVide() {
        PlateauDeCase plateau = new PlateauDeCase();
        assertNotNull(plateau.cases());
        assertTrue(plateau.cases().isEmpty());
    }

    @Test
    public void testSiCaseIciEtDonnerLaCase() {
        PlateauDeCase plateau = new PlateauDeCase();
        Position pos = new Position(1, 2);
        Case c = new Case(Type.LUNE);
        plateau.cases().put(pos, c);

        assertTrue(plateau.siCaseIci(pos));
        assertEquals(c, plateau.donnerLaCaseAPosition(pos));
    }

    @Test
    public void testDonnerCaseInexistante() {
        PlateauDeCase plateau = new PlateauDeCase();
        assertNull(plateau.donnerLaCaseAPosition(new Position(0, 0)));
    }

    @Test
    public void testInitialisationPlateau() {
        PlateauDeCase plateau = PlateauDeCase.initialisationPlateauCase();
        for (int i = 0; i < Constantes.COLONNES; i++) {
            for (int j = 0; j < Constantes.LIGNES; j++) {
                Position pos = new Position(i, j);
                assertTrue(plateau.siCaseIci(pos), "Position manquante: " + pos);
                assertNotNull(plateau.donnerLaCaseAPosition(pos), "Case nulle à la position: " + pos);
            }
        }

        for (Position posSoleil : Constantes.POSITION_SOLEIL) {
            Case c = plateau.donnerLaCaseAPosition(posSoleil);
            assertEquals(Type.SOLEIL, c.getType(), "Erreur à la position Soleil : " + posSoleil);
        }

        Case centre = plateau.donnerLaCaseAPosition(Constantes.CENTRE);
        assertEquals(Type.LUNE, centre.getType(), "Erreur au centre");

        for (int i = 0; i < Constantes.COLONNES; i++) {
            for (int j = 0; j < Constantes.LIGNES; j++) {
                Position pos = new Position(i, j);
                if (!Constantes.POSITION_SOLEIL.contains(pos) && !pos.equals(Constantes.CENTRE)) {
                    Case c = plateau.donnerLaCaseAPosition(pos);
                    assertEquals(Type.NORMAL, c.getType(), "Erreur case normale à : " + pos);
                }
            }
        }
    }
}
