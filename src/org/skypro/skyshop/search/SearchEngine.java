package org.skypro.skyshop.search;

import org.skypro.skyshop.product.BestResultNotFound;

import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private LinkedList<Searchable> searchables;

    public SearchEngine() {
        searchables = new LinkedList<>();
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public List<Searchable> search(String searchTerm) {
        List<Searchable> results = new LinkedList<>();

        for (Searchable searchable : searchables) {
            if (searchable == null) {
                continue;
            }
            if (searchable.getSearchTerm().contains(searchTerm)) {
                results.add(searchable);
            }
        }
        return results;
    }
    public Searchable findBestMatch(String search)
            throws BestResultNotFound {

        if (search == null || search.isEmpty()) {
            throw new BestResultNotFound(search);
        }
        Searchable bestMatch = null;
        int maxMatches = 0;
        for (Searchable searchable : searchables) {
            if (searchable == null) {
                continue;
            }
            String searchTerm = searchable.getSearchTerm();
            int matches = 0;
            int index = 0;
            int substringIndex = searchTerm.indexOf(search, index);

            while (substringIndex != -1) {
                matches++;
                index = substringIndex + search.length();
                substringIndex = searchTerm.indexOf(search, index);
            }
            if (matches > maxMatches) {
                maxMatches = matches;
                bestMatch = searchable;
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFound(search);
        }
        return bestMatch;
    }
}
