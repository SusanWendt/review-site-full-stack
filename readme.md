# Reviews, The Next Generation

A new version of my reviews application with Forms allowing user input to interact with the site and Ajax. 

![Preview](./src/main/resources/static/images/reviewsfullstack.png)


## Review Tags

- [X] If you didn't include tags before, add them. These should have a many-to-many relationship with reviews.
- [X] Clicking on a tag should take the user to a page which displays the reviews associated with that tag.
- [ ] Using appropriate HTML elements and AJAX, allow the user to add and remove tags from reviews. 
- [ ] Be careful not to create a new tag if a tag with that name already exists.

## Review Comments

- [X] Add comments to reviews. Comments should be listed on a review's page after the review's content.
- [X] Create a form on a review's page that adds a comment to a review. Perform an old school form submission rather than using AJAX. 
- [X] After submitting a comment, the user should be returned to the review page, now including the comment that was just submitted.

### Things to ponder

- What is the relationship between a review and its comments from the relational database perspective? 
- Does a review or its comment own the relationship?
- How can we best semantically represent review comments from an HTML perspective?

## Stretch tasks

- Create snazzy confirmation prompts for removing tags
- Use ES6 syntax
- Oh, you've already thought of a few things. Do those, but keep them simple.

## Rubric

Category|Max Score
---|---
create `Tag` class and map its entity relationship with `Review` |x/10
create a controller with methods that allow for manipulation of tags via AJAX |x/10
create a view that lists the reviews associated with a selected tag |x/10
create `Comment` class and map its entity relationship with `Review` |x/10
create form and controller method(s) to allow for creation of comments |x/10
update individual review page to display comments |x/10
create appropriate Spring Data repositories |x/10
TDD |x/10
style/formatting/code quality |x/10
**total points**|**x/100**