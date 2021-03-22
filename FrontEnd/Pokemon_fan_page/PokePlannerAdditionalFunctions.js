'use strict'

fetch("http://localhost:8080/pokelist").then(response => {
    if(response.status != 200) {
        console.error(response);

    }
    return response.json();
}).then(data => {
    let poke_list = document.querySelector("#pokeListSelect");
    data.forEach(pokeList => {

        let option = document.createElement("option");
        option.value = pokeList.pokeListId;
        option.text = pokeList.pokeListId;
        poke_list.appendChild(option);
        
    });
}).catch(err => console.error(err));

