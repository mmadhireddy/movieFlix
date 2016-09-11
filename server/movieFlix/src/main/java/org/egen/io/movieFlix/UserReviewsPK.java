package org.egen.io.movieFlix;

public class UserReviewsPK {
	private String userid;
	private String imdbid;
	
	public UserReviewsPK(){
		
	}
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getImdbid() {
		return imdbid;
	}

	public void setImdbid(String imdbid) {
		this.imdbid = imdbid;
	}

}
