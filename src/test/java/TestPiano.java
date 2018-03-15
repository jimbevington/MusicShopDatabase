import db.DBHelper;
import models.Piano;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestPiano {

    private Piano piano;

    @Before
    public void setUp() throws Exception {
        piano = new Piano("Yamaha", "HotPink", 500, 1000);
        DBHelper.saveOrUpdate(piano);
    }

    @Test
    public void canSave() {
        Piano foundPiano = DBHelper.find(Piano.class, piano.getId());
        assertEquals("Yamaha", piano.getManufacturer());
    }

    @Test
    public void canUpdate() {
        Piano foundPiano = DBHelper.find(Piano.class, piano.getId());
        foundPiano.setManufacturer("Steinway");
        DBHelper.saveOrUpdate(foundPiano);
        foundPiano = DBHelper.find(Piano.class, foundPiano.getId());
        assertEquals("Steinway", foundPiano.getManufacturer());
    }

}
