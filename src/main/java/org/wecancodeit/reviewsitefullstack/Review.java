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
	private long id; 
	private String name;
	private String description;
	private String imageUrl;
	private String website;
	private String insta;

	@JsonIgnore 
	@ManyToOne
	private Category category;

	@JsonIgnore
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
	public String addTag(Tag tag) {
		if (!(tags.contains(tag))) {
			tags.add(tag);
			return "added"; 
		} else {
			return "duplicate";
		}
	}
	//end of tagId checking if already exists

	//delete tag method
	public void removeTag(Tag tag) {
		tags.remove(tag);
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
