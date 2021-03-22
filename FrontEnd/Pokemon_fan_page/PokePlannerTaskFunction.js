'use strict'

// Eliminate looping problem 
const readTasks = document.querySelector("#submit_ptbutton");
readTasks.addEventListener("click", (submit_ptbutton) => {
  submit_ptbutton.preventDefault()
  pokeTaskPostRequest();
});


// Create Functionality

const pokeTaskPostRequest = () => {
  let pokeTask = document.querySelector("#poketask").value;
  console.log(pokeTask);

  let pokeTaskDescription = document.querySelector("#description").value;
  console.log(pokeTaskDescription);

  let difficulty = document.querySelector("#difficulty").value;
  console.log(difficulty);

  let date = document.querySelector("#date").value;
  console.log(date);

  let completedTickBox= document.querySelector("#completed").value;
  console.log(completedTickBox);

  let pokeListId = parseInt(document.querySelector("#pokeListSelect").value);
  console.log(pokeListId);
  
  const obj =
  {
      "pokeTask": pokeTask,
      "pokeTaskDescription": pokeTaskDescription,
      "difficulty": difficulty,
      "date": date,
      "completedTickBox" : completedTickBox,
      "pokeList" : {"pokeListId" : pokeListId}
      
  }

  fetch("http://localhost:8080/poketask", {
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

// Update Functionality


const pokeTaskPutRequest = () => {

let pokeTask = parseInt(document.querySelector("#poketask").value);
console.log("PokeTask ID: " + pokeTask);

let pokeTaskDescription = document.querySelector("#description").value;
console.log("Tasks: " + pokeTaskDescription);

let difficulty = document.querySelector("#difficulty").value;
console.log("Due Date: " + difficulty);

let date = document.querySelector("#date").value;
console.log("Status: " + date);

let completedTickBox = document.querySelector("#completed").value;
console.log("Completed on time: " + completedTickBox);

let pokeListId = parseInt(document.querySelector("#pokeListSelect").value);
console.log(pokeListId);


const updatedTask = {

    "pokeTask": pokeTask,
    "pokeTaskDescription": pokeTaskDescription,
    "difficulty": difficulty,
    "date": date,
    "completedTickBox" : completedTickBox,
    "pokeList" : {"pokeListId" : pokeListId}
    
};

fetch(`http://localhost:8080/tasks/id/${taskId}`, {
  method: "PUT",
  headers: {
    "Content-type": "application/json",
  },
  body: JSON.stringify(updatedTask),
})
  .then((res) => res.json())
  .then((data) => console.log(`Request succeeded with JSON response ${data}`))
  .catch((error) => console.log(`Request failed ${error}`));
};


// Delete 
let pokeTaskDeleteRequest = async (taskId) => {
  
  var taskId = parseInt(document.querySelector("#taskId").value);
  const response = await fetch(`http://localhost:8080/poketasks/taskId/${taskId}`, {
      method: "DELETE"
  });
  if (response.status != 204) {
      alert('The Delete Denied, PokeTaskId must be valid');
      console.error(`Error: Status code ${response.status}\n${response.json}`);
      return response.status; 
  }
  alert('Task deleted');
  console.log('PokeTask ID:' + taskId + 'deleted')
};