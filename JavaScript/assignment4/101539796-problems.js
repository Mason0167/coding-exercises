"use strict";

async function getRandomNumber(){
    let promise = new Promise ((resolve, reject) => {
        setTimeout(() => resolve(Math.floor(Math.random() * 5)), 500)
    });

    return await promise;
}

async function getCityData(city){
    let URL = `https://geocode.xyz/${city}?json=1`;

    return await fetch(URL)
        .then(res => res.json())
        .then(data => {
            return data;
        })
}


async function fetchProducts(id){
    let URL = `https://dummyjson.com/products/${id}`;

    try{
        let response = await fetch(URL);
        if (!response.ok) throw new Error(`HTTP error: ${response.status}`);

        let data = await response.json();

        return await data.title;
    }
    catch(err){
        return `Could not get products: ${err}`
    }
}

async function searchStorePrice(product_name) {
    let URL = `https://mdn.github.io/learning-area/javascript/apis/fetching-data/can-store/products.json`;

    try {
        let response = await fetch(URL);
        if (!response.ok) throw new Error(`HTTP error: ${response.status}`);

        let data = await response.json();
        let output = data.find(food => food.name === product_name);
        return await output.price;
    } catch (err) {
        return `Could not get products: ${err}`
    }
}

async function getStarWarsCharacters() {
    try {
        let URL = `https://swapi.dev/api/people/`;
        let response = await fetch(URL);

        if (!response.ok) {
            throw new Error(`HTTP Error: ${response.status}`);
        }

        let data = await response.json();
        let characters = {};
        data.results.forEach((a) => {
            characters[a.name] = a.url;
        });

        return { characters };
    } catch (err) {
        console.log(err);
        return { characters: {} };
    }
}