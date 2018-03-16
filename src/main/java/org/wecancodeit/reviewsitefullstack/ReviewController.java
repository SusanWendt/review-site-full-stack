package org.wecancodeit.reviewsitefullstack;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class ReviewController {
	
	@Resource
	private CategoryRepository catRepo;

	@Resource
	private ReviewRepository reviewRepo;	
	
	@RequestMapping("/categories")
	public String getAllCategories(Model model) {
		model.addAttribute("categories", catRepo.findAll());
		return "categoriesView";
	}
	
	@RequestMapping("/category")
	public String getSingleCategory(@RequestParam Long id, Model model) {
		Category category = catRepo.findOne(id);
		model.addAttribute("category", category); 
		model.addAttribute("reviews", reviewRepo.findByCategory(category));
		return "singleCategoryView";
	}
	
	@RequestMapping("/review")
	public String getSingleReview(@RequestParam Long id, Model model) {
		model.addAttribute("review", reviewRepo.findOne(id));
		return "reviewView";
	}

	@Resource
	private TagRepository tagRepo;

	@Resource
	private CommentRepository commentRepo;
	
	@RequestMapping("/tags")
	public String showAllTags(Long id, Model model) {
		model.addAttribute("allTags", tagRepo.findAll());
		return "tagsView";
	}
	
	@RequestMapping("/tag")
	public String showSingleTag(@RequestParam Long id, Model model) {
		model.addAttribute("currentTag", tagRepo.findOne(id));
		return "tagView";
	}
	
	@RequestMapping("/add-comment")
	public String addComment(String commentText, String userName, Long reviewId) {
		Date date = new Date(); 
		Review review = reviewRepo.findOne(reviewId);
		Comment comment = new Comment(commentText, userName, date, review);
		comment = commentRepo.save(comment);
		return "redirect:/review?id" + reviewId; 
	}
}













