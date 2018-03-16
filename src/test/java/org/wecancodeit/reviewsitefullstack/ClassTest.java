package org.wecancodeit.reviewsitefullstack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;

public class ClassTest {

	@Test
	public void ShouldSetUpReviewClass() {
		Category category = new Category("CatType", null, null);
		Review review = new Review("Name", "image", "website", "insta", "Description", category);
		String check = review.getName();
		assertThat(check, is("Name"));
	}

	@Test
	public void ShouldSetUpCategoryClass() {
		Category category = new Category("Type", null, null);
		String check = category.getType();
		assertThat(check, is("Type"));
	}

	@Test
	public void ShouldSetUpCommentClass() {
		Date date = new Date();
		Comment comment = new Comment("comment", "userName", date, null);
		String check = comment.getCommentText();
		String check2 = comment.getUserName();
		Date check3 = comment.getDate();
		assertThat(check, is("comment"));
		assertThat(check2, is("userName"));
		assertThat(check3, is(date));
	}
}
