package kr.co.domain;

public class sPageTO extends pageTO{
	private String searchType;
	private String keyword;
	
	public sPageTO() {
		// TODO Auto-generated constructor stub
	}
	
	public sPageTO(int curPage, String searchType, String keyword) {
		super(curPage);
		this.searchType=searchType;
		this.keyword=keyword;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
