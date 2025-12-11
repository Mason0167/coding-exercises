"use strict";


function Circle(radius) {

    this.perimeter = function(){
        return Math.round(radius * 2 * Math.PI * 100) / 100;
    };

    this.area = function(){
        return Math.round(radius * radius * Math.PI * 100) / 100;
    };
}



const calculateSalary = array =>
    array.reduce((accumulator, currentValue, index) => {
            const weekdayBaseSalary = 10;
            const overtimeSalary = 15;
            const firstHours = 8;

            accumulator += (index <= 4)
                ? currentValue <= 8
                    ? currentValue * weekdayBaseSalary
                    : (currentValue - firstHours) * overtimeSalary + 80
                : currentValue <= 8
                    ? currentValue * weekdayBaseSalary * 2
                    : (currentValue - firstHours) * 30 + 160;

            return accumulator;
            }, 0
    );



const indexMultiplier = array =>
    array.reduce((acc, cur, index) => {
        acc += cur * index;
        return acc;
        }, 0
    );



const filteredJSON = array =>
    array.filter(a => a.id > 10 && 'm' <= a.u[0] && a.u[0] <= 'z');



const breakAway = function (array, size) {
    const arr2D = [];

    for(let i = 0; i < array.length; i += size) {
        arr2D.push(array.slice(i, i + size));
    }
    console.log(arr2D);
/*
    for(let i = 0, j = 0; i < array.length / size; i++, j += size) {
        arr2D[i] = array.slice(j, j + size);
    }
    console.log(arr2D);

    const arr2D = [];
    let a = 0;

    for(let i = 0; i < array.length / size; i++) {
        arr2D[i] = [];

        for(let j = 0; j < size; j++, a++) {
            if(array[a] !== undefined)
            {
                arr2D[i][j] = array[a];
            }
        }
    }*/
    return arr2D;
}

























