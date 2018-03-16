package org.wecancodeit.reviewsitefullstack;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

	@Id
	@GeneratedValue
	private long id;
	private String comment;
	private String userName;
	private Date date;

	public Comment() {
	}

	public Comment(String comment, String userName, Date date, Review review) {
		this.comment = comment;
		this.userName = userName;
		this.date = date;
		this.review=review; 
	}
	
	@ManyToOne
	public Review review;
	
	public Review getCommentReview() {
		return review;
	}

	public String getCommentText() {
		return comment;
	}

	public String getUserName() {
		return userName;
	}

	public Date getDate() {
		return date;
	}

	public long getId() {
		return id;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
