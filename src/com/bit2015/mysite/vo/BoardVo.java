package com.bit2015.mysite.vo;

public class BoardVo {
	
	private Long no;
	private String title;
	private String content;
	private Long member_No;
	private String memberName;
	private int viewCount;
	private String regDate;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getMemberNo() {
		return member_No;
	}
	public void setMemberNo(Long memberNo) {
		this.member_No = memberNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "BoradDao [no=" + no + ", title=" + title + ", content="
				+ content + ", memberNo=" + member_No + ", memberName="
				+ memberName + ", viewCount=" + viewCount + ", regDate="
				+ regDate + "]";
	}

}
