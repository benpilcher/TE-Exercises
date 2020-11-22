let allItemsIncomplete = true;
const pageTitle = 'My Shopping List';
const groceries = [
  { id: 1, name: 'Oatmeal', completed: false },
  { id: 2, name: 'Milk', completed: false },
  { id: 3, name: 'Banana', completed: false },
  { id: 4, name: 'Strawberries', completed: false },
  { id: 5, name: 'Lunch Meat', completed: false },
  { id: 6, name: 'Bread', completed: false },
  { id: 7, name: 'Grapes', completed: false },
  { id: 8, name: 'Steak', completed: false },
  { id: 9, name: 'Salad', completed: false },
  { id: 10, name: 'Tea', completed: false }
];

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
  const ul = document.querySelector('ul');
  groceries.forEach((item) => {
    const li = document.createElement('li');
    li.innerText = item.name;
    const checkCircle = document.createElement('i');
    checkCircle.setAttribute('class', 'far fa-check-circle');
    li.appendChild(checkCircle);
    ul.appendChild(li);
  });
}

document.addEventListener('DOMContentLoaded', () => {
  setPageTitle();
  displayGroceries();

  // When a user clicks on list item to mark it complete or not complete
  
  let boughtItems = [];
  const buySingleItem = document.querySelector('ul');
  boughtItems = buySingleItem.children;

  let childrenNodes = [];

  for(let i = 0; i < boughtItems.length; i++) {

    boughtItems[i].addEventListener('click', (event) => {
      if(boughtItems[i].getAttribute('completed') != 'true') {
        boughtItems[i].setAttribute('class', 'completed');
        childrenNodes = boughtItems[i].children;
        childrenNodes[0].setAttribute('class', 'far fa-check-circle completed');
      }
    });
    
    boughtItems[i].addEventListener('dblclick', (event) => {
      if(boughtItems[i].getAttribute('completed') != 'false') {
        boughtItems[i].classList.remove('completed');
        childrenNodes = boughtItems[i].children;
        childrenNodes[0].classList.remove('completed');
      }
    });

  }

  const toggleButton = document.getElementById('toggleAll');

  toggleButton.addEventListener('click', (event) => {
    if(allItemsIncomplete) {
      for(let i = 0; i < boughtItems.length; i++) {
        boughtItems[i].setAttribute('class', 'completed');
        childrenNodes = boughtItems[i].children;
        childrenNodes[0].setAttribute('class', 'far fa-check-circle completed');
        allItemsIncomplete = false;
        toggleButton.innerText = 'Mark All Incomplete';
      }
    } else {
      for(let i = 0; i < boughtItems.length; i++) {
        boughtItems[i].classList.remove('completed');
        childrenNodes = boughtItems[i].children;
        childrenNodes[0].classList.remove('completed');
        allItemsIncomplete = true;
        toggleButton.innerText = 'Mark All Complete';
      }
    }
  })
});

function markSingleItemComplete(element) {
  if(!Element.classList.contains('.completed')) {
    element.classList.add('.completed');
    element.children.classList('.completed');
  }

}

