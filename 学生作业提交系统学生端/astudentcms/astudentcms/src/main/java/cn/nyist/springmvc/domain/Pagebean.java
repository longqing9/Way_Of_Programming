package cn.nyist.springmvc.domain;

public class Pagebean {
	
	private int currentpage;//��ǰҳ current page 
	
	private int recordcount;//�ܼ�¼�� record count 
	
	private int recordpage;//ÿҳ�ļ�¼�� record page
	
	private int countpage;//��ҳ��
	
	private String url;//���ڱ����ڷ�ҳ�е�����
	
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
