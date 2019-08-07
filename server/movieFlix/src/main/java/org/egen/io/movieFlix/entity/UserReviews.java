package org.egen.io.movieFlix.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "UserReviews.findAll", query = "SELECT u from UserReviews u "),
	@NamedQuery(name = "UserReview.findMovieReview", query = "SELECT u from UserReviews u  where u.imdbid =:imdbid"),
	@NamedQuery(name = "UserReview.findUserReview", query = "SELECT u from UserReviews u  where u.userid =:userid"),
	@NamedQuery(name = "UserReview.findOne", query = "SELECT u from UserReviews u  where u.userid =:userid and u.imdbid =:imdbid")
})
public class UserReviews {
	

	
	@JoinColumn(name = "userid")
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	private User usr;

	@Id
	@Column(name = "USERID", insertable = false, updatable = false)
	private String userid;
	
	@JoinColumn(name = "imdbid")
	@ManyToOne(targetEntity = MediaList.class, fetch = FetchType.LAZY)
	private MediaList mdl;
	
	@Id
	@Column(name = "IMDBID", insertable = false, updatable = false)
	private String imdbid;
	
	private int	    rating; 
	private String	comment;
	

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


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public String getComment() {
		return comment;
	}


//	public User getUsr() {
//		return usr;
//	}


	public void setUsr(User usr) {
		this.usr = usr;
	}


//	public MediaList getMdl() {
//		return mdl;
//	}


	public void setMdl(MediaList mdl) {
		this.mdl = mdl;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	@Override
	public String toString() {
		
		return "UserReviews [usr=" + usr+ ", userid=" + userid + ", mdl=" + mdl + ", imdbid=" + imdbid + ", rating="
				+ rating + ", comment=" + comment + "]";
	}


	
	
}
