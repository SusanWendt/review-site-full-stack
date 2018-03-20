package org.wecancodeit.reviewsitefullstack;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewRestController {

	@Resource
	ReviewRepository reviewRepo;

	@Resource
	TagRepository tagRepo;

	@RequestMapping("/review/{reviewId}/addtag/{tagWord}")
	public Tag addTagToReview(@PathVariable Long reviewId, @PathVariable String tagWord) {
		Review thisReview = reviewRepo.findOne(reviewId);
		Tag tag = tagRepo.findByTagWordIgnoreCase(tagWord);

		if (tag == null) {
			tag = new Tag(tagWord);
			tagRepo.save(tag);
		}
		String result = thisReview.addTag(tag);
		reviewRepo.save(thisReview);
		if (result.equals("added")) {
			return tag;
		} else {
			return null;
		}
	}

	@RequestMapping("/review/{reviewId}/tag/{tagWord}/deletetag")
	public String deleteTagFromReview(@PathVariable Long reviewId, @PathVariable Long tagId) {
		Review thisReview = reviewRepo.findOne(reviewId);
		Tag thisTag = tagRepo.findOne(tagId);
		thisReview.removeTag(thisTag);
		reviewRepo.save(thisReview);
		if (thisTag.getReviews().size() == 0) {
			tagRepo.delete(thisTag);
		}
		return null;
	}
}