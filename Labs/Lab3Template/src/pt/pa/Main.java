package pt.pa;

import pt.pa.model.BookmarkInvalidOperation;

/**
 *
 * @author brunomnsilva
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ///*     take comments when BookmarkManager is implemented
        try {
            BookmarkManager manager = new BookmarkManager();
            
            manager.addBookmarkFolder("bookmarks", "Jornais");
            manager.addBookmarkFolder("jornais", "Finanças");
            manager.addBookmarkFolder("bookmarks", "Redes Sociais");
            manager.addBookmarkFolder("bookmarks", "Diversos");
            
            manager.addBookmarkEntry("jornais", "Publico", "http://www.publico.pt");
            manager.addBookmarkEntry("jornais", "Expresso", "http://www.expresso.pt");
            manager.addBookmarkEntry("finanças", "Diário Económico", "http://economico.sapo.pt/");
            
            manager.addBookmarkEntry("redes sociais", "Facebook", "http://www.facebook.com");
            manager.addBookmarkEntry("redes sociais", "Instagram", "http://www.instagram.com");
            
            manager.addBookmarkEntry("diversos", "Gmail", "http://www.gmail.com");
            manager.addBookmarkEntry("diversos", "StackOverflow", "http://www.stackoverflow.com");
            
            manager.addBookmarkEntry("bookmarks", "IPS", "http://www.ips.pt");

            System.out.println(manager);

            System.out.println("\n\n1");
            manager.addBookmarkFolder("bookmarks", "Extra");
            System.out.println(manager);
            System.out.println("\n\n2");
            manager.moveEntryToFolder("redes sociais", "Extra");
            System.out.println(manager);
            System.out.println("\n\n3");
            manager.moveEntryToFolder("redes sociais", "IPS");
            System.out.println(manager);
            System.out.println("\n\n4");
            manager.moveEntryToFolder("Extra", "redes sociais");
            System.out.println(manager);
            System.out.println("\n\n");

            System.exit(0);

        } catch (BookmarkInvalidOperation exception) {
            System.err.println(exception.getMessage());
        }

         //*/
    }
    
}
