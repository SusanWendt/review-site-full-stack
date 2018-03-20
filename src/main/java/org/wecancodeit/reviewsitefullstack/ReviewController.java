package org.wecancodeit.reviewsitefullstack;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {

	@Resource
	private CategoryRepository catRepo;

	@Resource
	private ReviewRepository reviewRepo;
	
	@Resource
	private TagRepository tagRepo;
	
	@Resource
	private CommentRepository commentRepo;

	@RequestMapping("/categories")
	public String getAllCategories(Model model) {
		model.addAttribute("categories", catRepo.findAll());
		return "categoriesView";
	}

	@RequestMapping("/category/{categoryId}")
	public String getSingleCategory(@PathVariable Long categoryId, Model model) {
		Category category = catRepo.findOne(categoryId);
		model.addAttribute("category", category);
		model.addAttribute("reviews", reviewRepo.findByCategory(category));
		return "singleCategoryView";
	}

	@RequestMapping("/review/{reviewId}")
	public String getSingleReview(@PathVariable Long reviewId, Model model) {
		model.addAttribute("review", reviewRepo.findOne(reviewId));
		return "reviewView";
	}

	@RequestMapping("/tags")
	public String showAllTags(Long id, Model model) {
		model.addAttribute("allTags", tagRepo.findAll());
		return "tagsView";
	}

	@RequestMapping("/tag/{tagId}")
	public String showSingleTag(@PathVariable Long tagId, Model model) {
		model.addAttribute("currentTag", tagRepo.findOne(tagId));
		return "tagView";
	}

	@RequestMapping("/review/{reviewId}/addcomment")
	public String addComment(String commentText, String userName, @PathVariable Long reviewId) {
		Date date = new Date();
		Review review = reviewRepo.findOne(reviewId);
		Comment comment = new Comment(commentText, userName, date, review);
		comment = commentRepo.save(comment);
		return "redirect:/review/{reviewId}";
	}
}
