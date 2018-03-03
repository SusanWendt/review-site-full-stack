package org.wecancodeit.reviewsitefullstack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private long id; // the annotations above apply directly to what follows so @Id and @Generated
						// value are applied to private long and not private string field

	private String name;

	private String description;

	@ManyToOne
	private Category category;

	public Review() {
	}

	public Review(String name, String description, Category category) {
		this.name = name;
		this.description = description;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	@Lob
	public String getDescription() {
		return description;
	}

	public Category getCategory() {
		return category;
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
		return id == ((Review) obj).id;
	}

}
