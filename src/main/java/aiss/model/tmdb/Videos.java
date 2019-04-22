
package aiss.model.tmdb;

import java.util.List;

public class Videos {

    
    private int id;
    
    private List<VideoResult> results = null;
    
    
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    
    public List<VideoResult> getResults() {
        return results;
    }

    
    public void setResults(List<VideoResult> videoResults) {
        this.results = videoResults;
    }

    
}
