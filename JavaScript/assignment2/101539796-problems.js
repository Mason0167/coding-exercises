"use strict";

function _findNumOfDigits(digits){
    console.log(digits);
    let str = String(digits);
    let count = 0;
    for (let i = 0 ; i < str.length; i++){
        if(str[i] >= "0" && str[i] <= "9"){
            count++;
        }
    }
    console.log(count);
    return count;
}

function _surplus(text){
    function inner(){
        return text;
    }
    console.log(text);
    return inner;
}

function _strNumbers(arr){
    console.log(arr);
    let pattern = /\d/;
    let result;
    let output = [];
    for (let i = 0, j = 0; i < arr.length; i++){
        result = pattern.test(arr[i]);
        if (result === true){
            output[j] = arr[i];
            console.log(output);
            j++;
        }
    }
    return output;
}

function _determineClassGrading(arr){
    console.log(arr);
    let sum = 0;
    let pass = 0;
    let grade = 0;
    for (let i = 0; i < arr.length; i++){
        grade = parseInt(arr[i]);
        sum += grade;
        if (grade >= 50){
            pass++;
        }
    }
    let avg = Math.round(sum / arr.length * 10) / 10;
    let failed = arr.length - pass;
    return [pass, failed, avg];
}

const  _moveCapitalLetters = (text) => {


    let capitalText = "";
    let lowerCaseText = "";
    for (let i = 0; i < text.length; i++){
        if('A' <= text[i] && text[i] <= 'Z'){
            capitalText += text[i];
        }
        else lowerCaseText += text[i];
    }
    console.log(capitalText);
    console.log(lowerCaseText);
    return capitalText+lowerCaseText;
}













