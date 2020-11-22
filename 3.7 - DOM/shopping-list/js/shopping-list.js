// add pageTitle
const pageTitle = 'My Shopping List';
// add groceries
const groceries = [
  { id: 1, name: 'Bread'},
  { id: 2, name: 'Tofu'},
  { id: 3, name: 'Bananas'},
  { id: 4, name: 'Milk'},
  { id: 5, name: 'Brownies'},
  { id: 6, name: 'Cabbage'},
  { id: 7, name: 'Pasta'},
  { id: 8, name: 'Clementines'},
  { id: 9, name: 'Lettuce'},
  { id: 10, name: 'Coffee'}
]

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const title = document.getElementById('title');
  title.innerText = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const ul = document.getElementById('groceries');
  groceries.forEach((item) => {
    const li = document.createElement('li');
    li.innerText = item.name;
    ul.appendChild(li);
  });
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  let allItems = [];
  const groceryList = document.getElementById('groceries');
  allItems = groceryList.children;
  
  for(let i = 0; i < allItems.length; i++) {
    allItems[i].setAttribute('class', 'completed');
  }
}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
