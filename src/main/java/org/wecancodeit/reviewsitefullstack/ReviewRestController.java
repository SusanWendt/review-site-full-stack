package org.wecancodeit.reviewsitefullstack;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
public class ReviewRestController {
	
	@Resource 
	ReviewRepository reviewRepo;
	
	@Resource 
	TagRepository tagRepo;
	
	@RequestMapping("/add-tag")
	public Review addTagToThisReview(Long reviewId, String addTag) {
		Review thisReview = reviewRepo.findOne(reviewId);
		if (tagRepo.findByTagWord(addTag)!=null) {
			Tag tag = tagRepo.findByTagWord(addTag);
			tag.addReview(thisReview);
			return thisReview;
			
		}
		
		Tag tag = new Tag(addTag);
		tagRepo.save(tag);
		tag.addReview(thisReview);
		tagRepo.save(tag);
		
		return thisReview; 
	}	
	
	@RequestMapping("/del-tag")
	public Review DeleteTagFromThisReview(Long reviewId, Long tagId){
		Review thisReview = reviewRepo.findOne(reviewId);
		Tag thisTag = tagRepo.findOne(tagId);
		thisTag.delReview(thisReview);
		tagRepo.save(thisTag);
		
		
		return thisReview;
	}	
}