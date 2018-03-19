package org.wecancodeit.reviewsitefullstack;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private long id; // the annotations above apply directly to what follows so @Id and @Generated
						// value are applied to private long and not private string field

	private String name;
	private String description;
	private String imageUrl;
	private String website;
	private String insta;

	@ManyToOne
	private Category category;

	@ManyToMany
	private Collection<Tag> tags;

	@OneToMany(mappedBy = "review")
	private Collection<Comment> comments;

	public Collection<Comment> getComments() {
		return comments;
	}

	public Review() {
	}

	public Review(String name, String imageUrl, String website, String insta, String description, Category category,
			Tag... tags) {
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
		this.website = website;
		this.insta = insta;
		this.category = category;
		this.tags = new HashSet<>(asList(tags));
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getWebsite() {
		return website;
	}

	public String getInsta() {
		return insta;
	}

	@Lob
	public String getDescription() {
		return description;
	}

	public Category getCategory() {
		return category;
	}

	public Collection<Tag> getTags() {
		return tags;
	}
	
	//to check if tagId already exists with review
	public Boolean tagExists(long tagId) {
		boolean tagExists = false;
		for (Tag tag : tags) {
			if (tag.getId() == tagId) {
				tagExists = true;
				break;
			}
		}
		return tagExists;
	}
	//end of tagId checking if already exists
	
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

	public void addTag(Tag tag) {
		tags.add(tag);
	}

	public void removeTag(Tag tag) {
		tags.remove(tag);
	}

}
