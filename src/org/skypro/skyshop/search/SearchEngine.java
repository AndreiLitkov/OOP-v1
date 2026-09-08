package org.skypro.skyshop.search;

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
}
