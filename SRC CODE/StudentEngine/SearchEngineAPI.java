package SLMSWORKG10;

import java.util.List;

/**
 * SearchEngineAPI Implementation 
 * 
 * Requirement a: Caches searches and data filled in textfields/forms.
 * Requirement b: Provides auto-suggestions based on cached data in input fields.
 * 
 * This class serves as the 'API layer' for managing search history 
 * and input suggestions in the Student Engine module.
 */
public class SearchEngineAPI {
    private final CacheEngine cache;
    private final DeleteStudent studentManager;

    public SearchEngineAPI(DeleteStudent studentManager) {
        this.studentManager = studentManager;
        // The CacheEngine stores up to 15 unique searches and latest values for form fields
        this.cache = new CacheEngine(15);
    }

    /**
     * Search for a student by ID and cache the search term.
     * (Requirement a: Cache searches)
     */
    public Student search(String studentID) {
        if (studentID != null && !studentID.trim().isEmpty()) {
            cache.cacheSearch(studentID);
        }
        return studentManager.searchStudent(studentID);
    }

    /**
     * Suggest potential search terms based on input prefix.
     * (Requirement b: Auto suggestion)
     */
    public List<String> autoSuggestSearch(String prefix) {
        return cache.getSuggestions(prefix);
    }

    /**
     * Suggest a value for an input field based on previous entries.
     * (Requirement b: Auto suggestion in input fields)
     */
    public String autoSuggestFormField(String fieldName) {
        return cache.getFieldSuggestion(fieldName);
    }

    /**
     * Explicitly cache data from a form field.
     * (Requirement a: Cache data filled in forms)
     */
    public void recordFormFieldInput(String fieldName, String value) {
        cache.cacheFormField(fieldName, value);
    }

    public CacheEngine getInternalCache() {
        return cache;
    }
}
