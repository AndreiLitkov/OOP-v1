package org.skypro.skyshop.search;

import org.skypro.skyshop.product.BestResultNotFound;

public class SearchEngine {
    private Searchable[] searchables;

    public SearchEngine(int size) {
        searchables = new Searchable[size];
    }

    public void add(Searchable searchable) {

        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                searchables[i] = searchable;
                return;
            }
        }
    }

    public Searchable[] search(String searchTerm) {

        Searchable[] results = new Searchable[5];
        int resultIndex = 0;

        for (Searchable searchable : searchables) {

            if (searchable == null) {
                continue;
            }

            if (searchable.getSearchTerm().contains(searchTerm)) {
                results[resultIndex] = searchable;
                resultIndex++;

                if (resultIndex == 5) {
                    break;
                }
            }
        }

        return results;
    }
    public Searchable findBestMatch(String search) throws BestResultNotFound {

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
