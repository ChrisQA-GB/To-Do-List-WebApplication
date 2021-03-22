
'use strict'

// Eliminate looping problem 
const createList = document.querySelector("#submit-plbutton");
createList.addEventListener("click", (event) => {
  event.preventDefault();
  pokeListPostRequest();
});

// Eliminate looping problem 
const updateList = document.querySelector("#update-plbutton");
updateList.addEventListener("click", (event) => {
  event.preventDefault();
  pokeListPutRequest();
});

// Eliminate looping problem 
const deleteList = document.querySelector("#delete-plbutton");
deleteList.addEventListener("click", (event) => {
  event.preventDefault();
  pokeListDeleteRequest();
});


//Creating Create Fucntionality
const pokeListPostRequest = () => {

    let pokeList = document.querySelector("#pokeList").value;
    console.log(pokeList);

    const obj =
    {
        "pokeList": pokeList
    }

    fetch("http://localhost:8080/pokelist" , {
        method: "POST",
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(obj)
    })
        .then(res => res.json())
        .then(data => console.log(data))
        .catch(err => console.err(err))
}

// Creating Update Functionality for PokeList
let pokeListPutRequest = () => {
 
let pokeListID = parseInt((document.querySelector("#pokeListId").value));
console.log("PokeListId " + pokeListID);

let pokeList = document.querySelector("#pokeList").value;
console.log("PokeList: " + pokeList);

const updatedPokeList = {

  "pokeList": pokeList
};


fetch(`http://localhost:8080/pokelist/${pokeListId}`, {
  method: "PUT",
  headers: {
    "Content-type": "application/json",
  },
  body: JSON.stringify(updatedPokeList),
})
  .then((res) => res.json())
  .then((data) => console.log(`Success ${data}`))
  .catch((error) => console.log(`Failure ${error}`));

}
  // Creating Delete Functionality

let pokeListDeleteRequest = async (pokeListId) => {
    
    var pokeListId = parseInt(document.querySelector("#pokeListId").value);
    const response = await fetch(`http://localhost:8080/pokelist/${pokeListId}`, {
        method: "DELETE"
    });
    if (response.status != 204) {
        alert('The Delete Denied, PokeListId must be valid');
        console.error(`Error: Status code ${response.status}\n${response.json}`);
        return response.status; 
    }
    alert('Task deleted');
    console.log('PokeListID:' + pokeListId + 'deleted')
  }

