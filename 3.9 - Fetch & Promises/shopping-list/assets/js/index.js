let listNotFetched = true;
let listNotDisplayed = true;
let loadListButton = document.querySelector('.loadingButton');
const list = document.querySelector("ul");

loadListButton.addEventListener('click', (event) => {
    // If the list is not fetched and not displayed (i.e. first time loading page)
    if(listNotFetched && listNotDisplayed) {
        fetch('https://techelevator-pgh-teams.azurewebsites.net/api/techelevator/shoppinglist')
            .then((response) => {
                return response.json();
            })
            .then((groceries) => {
                if('content' in document.createElement('template')) {
                    list.style.display = 'block';
                    groceries.forEach((item) => {
                        let tmpl = document.getElementById('shopping-list-item-template').content.cloneNode(true);
                        tmpl.querySelector("li").insertAdjacentHTML('afterbegin', item.name);
                        if(item.completed) {
                            const circleCheck = tmpl.querySelector('.fa-check-circle');
                            circleCheck.className += " completed";
                        }
                        list.appendChild(tmpl);       
                    });
                    listNotFetched = false;
                    listNotDisplayed = false;
                    // Change the text on the button to indicate how to collapse the list
                    loadListButton.innerText = 'Collapse List';
                } else {
                    console.error('Your browser does not support templates');
                }
            })
            .catch((err) => {console.error(err)});
    // If the list is already fetched but not displayed (i.e. display already fetched list again after previously collapsing it)
    } else if (!listNotFetched && listNotDisplayed) {
        // Display the same list again without fetching it a second time
        list.style.display = 'block';
        listNotFetched = false;
        listNotDisplayed = false;
        // Change the text on the button to indicate how to collapse the list
        loadListButton.innerText = 'Collapse List';
    // If the list is already fetched and already displayed (i.e. collapse list)
    } else {
        // Hide the list from view
        list.style.display = 'none';
        // Change the text on the button to indicate how to display the list again
        loadListButton.innerText = 'Show List';
        listNotFetched = false;
        listNotDisplayed = true;
    }
});