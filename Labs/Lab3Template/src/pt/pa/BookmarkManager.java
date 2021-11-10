package pt.pa;

import pt.pa.adts.Position;
import pt.pa.adts.TreeLinked;
import pt.pa.model.BookmarkEntry;
import pt.pa.model.BookmarkInvalidOperation;

import java.util.*;

public class BookmarkManager {
    private TreeLinked<BookmarkEntry> bookmarks;

    public BookmarkManager() {
        this.bookmarks = new TreeLinked<>(new BookmarkEntry("Bookmarks"));
    }

    private Position<BookmarkEntry> find(String key) {
        key.replaceAll(" ", "");

        for (Position<BookmarkEntry> book:this.bookmarks.positions()) {
            if(book.element().getKey().equalsIgnoreCase(key))
                return book;
        }

        return null;
    }

    private boolean exists(String key) {
        key.replaceAll(" ", "");

        for(BookmarkEntry book:this.bookmarks.elements())
            if(book.getKey().equalsIgnoreCase(key))
                return true;

        return false;
    }

    public void addBookmarkFolder(String keyParent, String keyFolder) throws BookmarkInvalidOperation {
        if(!this.exists(keyParent))
            throw new BookmarkInvalidOperation("Parent doesn't exist");

        if (this.exists(keyFolder))
            throw new BookmarkInvalidOperation("Folder alredy exists");

        Position<BookmarkEntry> position = find(keyParent);

        this.bookmarks.insert(position, new BookmarkEntry(keyFolder));
    }

    public void addBookmarkEntry(String keyParent, String keyEntry, String url) throws BookmarkInvalidOperation {
        if(!this.exists(keyParent))
            throw new BookmarkInvalidOperation("Parent doesn't exist");

        if (this.exists(keyEntry))
            throw new BookmarkInvalidOperation("Entry alredy exists");

        Position<BookmarkEntry> position = find(keyParent);

        this.bookmarks.insert(position, new BookmarkEntry(keyEntry, url));
    }

    public int getTotalFolders() {
        int n = 0;

        for(BookmarkEntry book:this.bookmarks.elements())
            if(book.isFolder())
                n++;

        return n;
    }

    public int getTotalLinks() {
        int n = 0;

        for(BookmarkEntry book:this.bookmarks.elements())
            if(!book.isFolder())
                n++;

        return n;
    }

    public int getTotalEntries() {
        return this.bookmarks.size();
    }

    public String getParentFolder(String keyEntry) throws BookmarkInvalidOperation {
        if (!exists(keyEntry))
            throw new BookmarkInvalidOperation("Entry doesn't exist");

        return this.bookmarks.parent(find(keyEntry)).element().getKey();
    }

    @Override
    public String toString() {
        return "BookmarkManager{" +
                "bookmarks=" + bookmarks +
                '}';
    }

    public void moveEntryToFolder(String origin, String destination) throws BookmarkInvalidOperation {
        Position<BookmarkEntry> d = find(destination);

        if(!d.element().isFolder())
            throw new BookmarkInvalidOperation("Destination isn't Folder");

        Position<BookmarkEntry> o = find(origin);
        if(this.bookmarks.isAncestor(o, d))
            throw new BookmarkInvalidOperation("Origin is Acenstor Destination");

        this.bookmarks.move(o, d);
    }
}
