# Reviews Site Full Stack Overview


## Description: 
- Project done at We Can Code IT referencing previous Review Site repository. This is my first full stack and pair programming project. 
- Uses Java, Spring Boot, Spring MVC, Spring Initialzr, JPA, SQL DataBase, as well as Front End languages HTML, and CSS. 
- Reviewing work out studios around the city with descriptions and tags all housed in a database.  

## Tasks
- [X] Add the following dependencies to build.gradle (or use Spring Initializr to create a new build.gradle)
	- [X] JPA (spring-boot-starter-data-jpa)
	- [X] H2

- [X] Create a Category class that:
	- [X] is a JPA entity.
	- [X] contains an instance variable referencing the Reviews it contains.
	- [X] configures an appropriate JPA relationship to its reviews.

- [X] Update the Review class such that:
	- [X] it is a JPA entity.
	- [X] configures a JPA relationship to its associated category.
	- [X] allows for a description/content/body longer than 255 characters.

- [X] Update your view (templates/html/css) such that:
	- [X] there is a page that lists review categories, each of which links to the (details) page for a specific category.
	- [X] there is a page that lists the reviews for a chosen category, each of which links to the (details) page for a specific review.
	- [X] each review detail page has a link to the page for its category.

Stretch Tasks
- [X] Tags
	- [X] Create a Tag entity.
	- [X] Update Review so that it can have tags associated with it. (One review, many tags.)
	- [X] Display tags on the review details page.
	- [X] Create a page that displays links to all of the reviews associated with a given tag.

Stretchier
- [] Style your tags list template as a tag cloud, making tags which appear more often larger and/or bolder and those that appear less often smaller and/or lower weight.
- [] Allow creation and deletion of tags from a review using <form> and <button> elements along with the appropriate controller method(s).

Rubric

Category|Max Score
---|---
create and wire entity classes with proper annotations | X/5
create necessary repositories | X/5
create needed database with proper annotations | X/10
controller class setup to allow access to necessary templates | X/10
ThymeLeaf templates that accurately display required information | X/10
HTML semantically marked | X/10
CSS style according to convention | X/10
utilize CSS Grid layout according to conventional practice | X/10
utilize FlexBox according to conventional practice | X/10
TDD | X/10
style/formatting/code quality | X/10
total points | X/100


# Reviews, The Next Generation

We are returning to your reviews application. *Surprise!*

![Preview](./src/main/resources/static/images/reviewsfullstack.png)

You can create a new repository or use the same one. If you'd like to use the same one, but would like to keep track of the previous version of your project, you can create a branch or use an annotated tag.

## Review Tags

If you didn't include tags before, add them. These should have a many-to-many relationship with reviews.

Clicking on a tag should take the user to a page which displays the reviews associated with that tag.

Using appropriate HTML elements and AJAX, allow the user to add and remove tags from reviews. Be careful not to create a new tag if a tag with that name already exists.

## Review Comments

Add comments to reviews. Comments should be listed on a review's page after the review's content.

Create a form on a review's page that adds a comment to a review. Perform an old school form submission rather than using AJAX. After submitting a comment, the user should be returned to the review page, now including the comment that was just submitted.

### Things to ponder

What is the relationship between a review and its comments from the relational database perspective? Does a review or its comment own the relationship?

How can we best semantically represent review comments from an HTML perspective?

## Stretch tasks

- Create snazzy confirmation prompts for removing tags
- Use ES6 syntax
- Oh, you've already thought of a few things. Do those, but keep them simple.

## Rubric

Category|Max Score
---|---
create `Tag` class and map its entity relationship with `Review` |10
create a controller with methods that allow for manipulation of tags via AJAX |10
create a view that lists the reviews associated with a selected tag |10
create `Comment` class and map its entity relationship with `Review` |10
create form and controller method(s) to allow for creation of comments |10
update individual review page to display comments |10
create appropriate Spring Data repositories |10
TDD |10
style/formatting/code quality |10
**total points**|**100**