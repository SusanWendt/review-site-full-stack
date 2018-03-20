const xhr = new XMLHttpRequest();

const reviewIdElement = document.querySelector('#review-id')
const reviewId = reviewIdElement.value

//delete tag

const tagDeleteButtonList = document.querySelectorAll('.tag-delete-x')
tagDeleteButtonList.forEach(function(xButton){
	addTagDeleteListener(xButton)
})

function addTagDeleteListener(element) {
	element.addEventListener('click', function() {
		const response = confirm("Are you sure you want to delete this tag?")
		
		if (response) {
			const currentTagId = element.nextElementSibling.value
			const deleteRequestUrl = `/review/${reviewId}/tag/${tagId}/deletetag`

			xhr.open('DELETE', deleteRequestUrl, true)
			xhr.send()

			xhr.onreadystatechange = function() {
				if (this.readyState === 4 && this.status === 200) {
					element.parentNode.remove();	
				}
			}
		}
	})
}

//add tag

const tagAddButton = document.querySelector('.tag-add-button')
tagAddButton.addEventListener('click', function() {
	const tagNameBox = document.querySelector('#tagWord')
	const tagName = tagWordBox.value

	if (tagWord) {
		tagWordBox.value = ''
		const addRequestUrl = `/review/${reviewId}/addtag/${tagWord}`
		xhr.open('PUT', addRequestUrl, true)
		xhr.send()
	} else {
		alert("Please enter a tag word.")
	}

	xhr.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			if (xhr.response) {
				const res = JSON.parse(xhr.response)

				const newTag = document.createElement('span')
				newTag.classList.add('review-tag')
				newTag.innerHTML = `
					<a href="/tag/${res.id}">${res.name}</a>
					<a class="tag-delete-x"> x</a>
					<input type="hidden" value="${res.id}" />`
				const tagList = document.querySelector('.tagContainer')
				tagList.appendChild(newTag)

				const newXButton = tagList.lastChild.children[1]
				addTagDeleteListener(newXButton)
			} else {
				alert("A tag with that name already exists in this review.")
			}
		}
	}
})