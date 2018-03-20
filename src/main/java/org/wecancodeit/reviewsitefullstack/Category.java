package org.wecancodeit.reviewsitefullstack;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private long id; 
	private String type;
	private String imageUrl;
	private String description;
	
	public Category() {
	}
	
	public Category(String type, String description, String imageUrl) {
		this.type = type;
		this.description = description;
		this.imageUrl = imageUrl;
	}

	public String getType() {
		return type;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public String getDescription() {
		return description;
	}

	public long getId() {
		return id;
	}
	
	@OneToMany(mappedBy = "category")
	private Collection<Review> reviews; 
	
	public Collection<Review> getReviews() {
		return reviews;
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
		return id == ((Category) obj).id;
	}

}
