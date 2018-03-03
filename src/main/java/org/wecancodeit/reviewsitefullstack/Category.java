package org.wecancodeit.reviewsitefullstack;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	public Category() {
	}

	@Id
	@GeneratedValue
	private long id; //the annotations above apply directly to what follows so @Id and @Generated value are applied to private long and not private string field 
	
	private String type;

	public Category(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
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
