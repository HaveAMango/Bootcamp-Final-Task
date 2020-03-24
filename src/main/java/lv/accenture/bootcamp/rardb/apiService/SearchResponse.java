package lv.accenture.bootcamp.rardb.apiService;

import java.util.List;



public class SearchResponse {

    private Long totalResults;

    private Boolean Response;

    private List<SearchResult> Search;

	public List<SearchResult> getSearch() {
		return Search;
	}

	@Override
	public String toString() {
		return "SearchResponse [totalResults=" + totalResults + ", Response=" + Response + ", Search=" + Search + "]";
	}

	public Long getTotalResults() {
		return totalResults;
	}

	public Boolean getResponse() {
		return Response;
	}

    


}