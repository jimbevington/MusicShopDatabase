import db.DBHelper;
import models.Guitar;
import models.MusicBook;
import models.MusicStand;
import models.Piano;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Guitar guitar1 = new Guitar("Jazzman", "black", 6, 500, 1000);
        DBHelper.saveOrUpdate(guitar1);
        Guitar guitar2 = new Guitar("Speedster", "blue", 12, 800, 1600);
        DBHelper.saveOrUpdate(guitar2);

        Piano piano1 = new Piano("Steinway", "white", 500, 1000);
        DBHelper.saveOrUpdate(piano1);
        Piano piano2 = new Piano("Kawai", "coral pink", 500, 2000);
        DBHelper.saveOrUpdate(piano2);

        MusicBook book1 = new MusicBook("Songs for Shouting", 5, 10);
        DBHelper.saveOrUpdate(book1);
        MusicBook book2 = new MusicBook("Achingly Awful Airs", 4, 10);
        DBHelper.saveOrUpdate(book2);

        MusicStand stand1 = new MusicStand("white", 5, 10);
        DBHelper.saveOrUpdate(stand1);
        MusicStand stand2 = new MusicStand("ostrich feather black", 4, 8);
        DBHelper.saveOrUpdate(stand2);

        List<Guitar> guitars = DBHelper.getAll(Guitar.class);
        List<Piano> pianos= DBHelper.getAll(Piano.class);
        List<MusicStand> musicStands = DBHelper.getAll(MusicStand.class);
        List<MusicBook> musicBooks = DBHelper.getAll(MusicBook.class);

    }
}
