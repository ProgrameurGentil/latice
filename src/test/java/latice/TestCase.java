package latice;

import org.junit.jupiter.api.Test;

import latice.model.Case;
import latice.model.Type;

import static org.junit.jupiter.api.Assertions.*;

public class TestCase {

    @Test
    public void testConstructeurAvecType() {
        Case c = new Case(Type.LUNE);
        assertEquals(Type.LUNE, c.getType());
    }

    @Test
    public void testConstructeurParDefaut() {
        Case c = new Case();
        assertEquals(Type.NORMAL, c.getType());
    }

    @Test
    public void testEcrireCaseEnUneLettreLune() {
        Case c = new Case(Type.LUNE);
        assertEquals("L", c.ecrireCaseEnUneLettre());
    }

    @Test
    public void testEcrireCaseEnUneLettreSoleil() {
        Case c = new Case(Type.SOLEIL);
        assertEquals("S", c.ecrireCaseEnUneLettre());
    }

    @Test
    public void testEcrireCaseEnUneLettreNormal() {
        Case c = new Case(Type.NORMAL);
        assertEquals("N", c.ecrireCaseEnUneLettre());
    }

    @Test
    public void testEcrireCaseEnUneLettreTypeInconnu() {
        Case c = new Case(null);
        assertEquals("erreur", c.ecrireCaseEnUneLettre());
    }

    @Test
    public void testEqualsAvecNullEtAutresTypes() {
        Case c = new Case(Type.NORMAL);
        assertNotEquals(c, null);
        assertNotEquals(c, "pas une case");
    }
}


