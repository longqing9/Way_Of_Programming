package cn.nyist.springmvc.domain;

public class Pagebean {
	
	private int currentpage;//当前页 current page 
	
	private int recordcount;//总记录数 record count 
	
	private int recordpage;//每页的记录数 record page
	
	private int countpage;//总页数
	
	private String url;//用于保存在分页中的条件
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	public int getCountpage() {
		
		countpage = recordcount/recordpage;
		return recordcount % recordpage ==0 ? countpage :countpage + 1;
	}


	public int getRecordcount() {
		return recordcount;
	}

	public void setRecordcount(int recordcount) {
		this.recordcount = recordcount;
	}

	public int getRecordpage() {
		return recordpage;
	}

	public void setRecordpage(int recordpage) {
		this.recordpage = recordpage;
	}
	

}
