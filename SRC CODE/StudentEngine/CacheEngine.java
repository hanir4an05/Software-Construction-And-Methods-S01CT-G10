package SLMSWORKG10;

import java.util.*;

/**
 * CacheEngine API Implementation
 * Handles caching of searches and form data (textfields) and provides auto-suggestions.
 * Built for the SLMS (Student Management System) project.
 */
public class CacheEngine {
    // Cache for searches (stores limited number of unique recent searches)
    private final LinkedHashSet<String> searchHistory;
    private final Map<String, String> formDataCache;
    private final int maxHistorySize;
    
    // Global static instance for shared caching across the module
    private static CacheEngine instance;

    public CacheEngine(int maxHistorySize) {
        this.maxHistorySize = maxHistorySize;
        this.searchHistory = new LinkedHashSet<>();
        this.formDataCache = new HashMap<>();
    }

    public static synchronized CacheEngine getInstance() {
        if (instance == null) {
            instance = new CacheEngine(20); // Default shared cache size
        }
        return instance;
    }

    // --- Search Caching Logic (Requirement a) ---

    /**
     * Cache a new search query.
     * @param query The search string to cache (e.g., student ID or name).
     */
    public void cacheSearch(String query) {
        if (query == null || query.trim().isEmpty()) return;
        
        // Remove existing to re-insert at the end (MRU order)
        searchHistory.remove(query);
        if (searchHistory.size() >= maxHistorySize) {
            // Remove oldest entry
            Iterator<String> it = searchHistory.iterator();
            it.next();
            it.remove();
        }
        searchHistory.add(query);
    }

    /**
     * Cache data entered into a form/textfield.
     * @param fieldName The name of the field (e.g., "StudentName" or "Gmail").
     * @param value The value entered by the user.
     */
    public void cacheFormField(String fieldName, String value) {
        if (fieldName == null || value == null || value.trim().isEmpty()) return;
        formDataCache.put(fieldName, value);
    }

    // --- Auto-Suggestion Logic (Requirement b) ---

    /**
     * Provides auto-suggestions based on cached data for a given prefix.
     * @param prefix The current prefix the user has typed.
     * @return A list of matching strings from the search history.
     */
    public List<String> getSuggestions(String prefix) {
        if (prefix == null || prefix.trim().isEmpty()) return Collections.emptyList();
        
        List<String> matches = new ArrayList<>();
        String lowerPrefix = prefix.toLowerCase();
        
        // Iterate backwards from most recent searches
        List<String> reversed = new ArrayList<>(searchHistory);
        Collections.reverse(reversed);
        
        for (String item : reversed) {
            if (item.toLowerCase().startsWith(lowerPrefix)) {
                matches.add(item);
            }
        }
        return matches;
    }

    /**
     * Suggests a previous value for a form field.
     * @param fieldName The name of the field to get a suggestion for.
     * @return The most recent value filled in for that field, or null if none.
     */
    public String getFieldSuggestion(String fieldName) {
        return formDataCache.get(fieldName);
    }

    /**
     * Clear caches
     */
    public void clearCache() {
        searchHistory.clear();
        formDataCache.clear();
    }

    // --- Debug Helper ---
    public void displayCacheState() {
        System.out.println("\n>> CACHE ENGINE STATE <<");
        System.out.println("History: " + searchHistory);
        System.out.println("Form Data: " + formDataCache);
    }
}
