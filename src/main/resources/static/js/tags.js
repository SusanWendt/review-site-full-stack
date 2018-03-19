const xhr = new XMLHttpRequest();


xhr.onreadystatechange = function() {
	if (xhr.readyState === 4 && xhr.status === 200) {
		const res = JSON.parse(xhr.response);
		console.log(res);
	}
};

const addBtn = document.querySelector('.addButton');

addBtn.addEventListener('click', function(event) {
	event.preventDefault();
	const tag = document.querySelector('#tagInput').value;
	console.log(tag);
	const reviewId = addBtn.dataset.reviewId;
	console.log(reviewId);
	xhr.open('POST', 'http://localhost:8080/add-tag?reviewId=' + reviewId + '&addTag='+ tag, true);
	xhr.send();
	
	const deleteButton = document.querySelector(".deleteButton");
	const tagList = document.querySelector(".tags");
	appendElement(tagList, createElement('p', tag));
	appendElement(tagList, createElement('button', deleteButton));
});


const delBtn = document.querySelectorAll('.deleteButton');
delBtn.addEventListener('click', () => {
	const reviewId = delBtn.dataset.delId;
	const tagId = delBtn.dataset.tagId;
	console.log(reviewId);
	console.log(tagId);
	xhr.open('DELETE', 'http://localhost:8080/del-tag?reviewId=' + reviewId + '&tagId=' + tagId, true);
	xhr.send();
});

function createElement (elem, textValue) {
	const newElem = document.createElement(elem);
	newElem.innerText = textValue;
	return newElem;
}

function appendElement(parent, child) {
	parent.appendChild(child);
}