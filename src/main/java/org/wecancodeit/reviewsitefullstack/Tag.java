package org.wecancodeit.reviewsitefullstack;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tag {
	@Id
	@GeneratedValue
	private long id;
	private String tagWord;

	@JsonIgnore 
	@ManyToMany(mappedBy = "tags")
	private Collection<Review> reviews;
	
	public Collection<Review> getReviews() {
		return reviews;
	}
	
	public long getId() {
		return id;
	}
	
	public String getTagWord() {
		return tagWord;
	}

	public Tag(String tagWord, Review... reviews) {
		this.tagWord = tagWord;
		this.reviews = new HashSet<>(Arrays.asList(reviews));
	}
	
	public Tag() {
	}

	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		return id == ((Tag) obj).id;
	}

	public void addReview(Review review) {
		reviews.add(review);
	}

	public void delReview(Review review) {
		reviews.remove(review);
	}

}
