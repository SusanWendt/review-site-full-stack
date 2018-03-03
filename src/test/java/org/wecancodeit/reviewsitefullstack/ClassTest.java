package org.wecancodeit.reviewsitefullstack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ClassTest {
	
	@Test
	public void ShouldSetUpReviewClass() {
		Category category = new Category("CatType");
		Review review = new Review("Name", "Description", category); 
		String check = review.getName();  
		assertThat(check, is("Name")); 	
	}
	
	@Test
	public void ShouldSetUpCategoryClass() {
		Category category = new Category("Type"); 
		String check = category.getType();  
		assertThat(check, is("Type")); 	
	}
}
