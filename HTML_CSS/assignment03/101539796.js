function part1(){
    // Start your code here for first part. There is no need to return any value.
    let StudentID = '101539796';
    let FullName='Cheng Yeh Tsai';
    let LabProfessor='Azzad Kara';
    let LabSessionDay='Thursday';
    let Semester='Fall';


    let IDresult = "";
    for (let i = 0; i < StudentID.length; i++) {
        let ID2 = StudentID.charCodeAt(i);
        if (ID2 === 57){
            IDresult += '0';
        } else {
            let newID = ID2 + 1;
            IDresult += String.fromCharCode(newID);
        }
    }
    let result2 = parseInt(IDresult);

    let Nameresult = "";
    for (let i = 0; i < FullName.length; i++) {
        let ID2 = FullName.charCodeAt(i);
        let newID2 = ID2 + 1;
        Nameresult += String.fromCharCode(newID2);
    }

    let profresult = "";
    for (let i = 0; i < LabProfessor.length; i++) {
        let ID2 = LabProfessor.charCodeAt(i);
        if (ID2 === 122){
            profresult += 'a';
        } else {
            let newID2 = ID2 + 1;
            profresult += String.fromCharCode(newID2);
        }
    }

    let dayresult = "";
    for (let i = 0; i < LabSessionDay.length; i++) {
        let ID2 = LabSessionDay.charCodeAt(i);
        let newID2 = ID2 + 1;
        dayresult += String.fromCharCode(newID2);
    }

    let semesterresult = "";
    for (let i = 0; i < Semester.length; i++) {
        let ID2 = Semester.charCodeAt(i);
        let newID2 = ID2 + 1;
        semesterresult += String.fromCharCode(newID2);
    }

    document.write('<div style="position: absolute; bottom: 70px; right: 0;" >');
    document.write("<strong>Student ID:</strong> " + StudentID + "  " + "<strong>Full Name:</strong> " + FullName + "<br>" );
    document.write("<strong>Lab Professor:</strong>" + LabProfessor + "  " + '<strong>Lab Session Day:</strong> ' + LabSessionDay + "  " + '<strong>Semester:</strong> ' + Semester + "<br>");
    document.write("<br>");
    document.write("<strong>Encoded Student ID:</strong> " + IDresult + "  " + "<strong>Encoded Full Name:</strong> " + Nameresult + "<br>" );
    document.write('<strong>Encoded Lab Professor:</strong> ' + profresult + "  " + '<strong>Encoded Lab Session Day:</strong> ' + semesterresult + "  " + '<strong>Encoded Semester:</strong> ' + semesterresult);
    document.write('</div>');
}

function part2(num1, num2) {
    // Assign the return value to a variable named _return
    let _return = '';
    // Your code should start here

    num1 = num1 + 5;
    num2 = num2 - 3;
    if (num1 < num2){
        _return = -1;}
    else if (num1 > num2){
        _return = 1;}
    else if (num1 === num2){
        _return = 0;}

    /* Your code ends here.
       Don't add or change anything after this line.*/
    return _return;
}


function part3(startNum, endNum) {
    // Assign the return value to a variable named _return
    let _return = '';
    // To hold the sum of numbers for the divisibility condition

    if (startNum < endNum){
		endNum = endNum + 1;
		for(let i = startNum; i < endNum; i++){
			_return += i;
		}
	}
	else if (startNum > endNum){
		endNum = endNum - 1;
		for(let i = startNum; i > endNum; i--){
			_return += i;
		}
	}
    else if (startNum === endNum){
		let sum = startNum + endNum;
		_return = String(sum);
	}	
	
	let _return2 = _return % 3;
	if (_return2 === 0){
		_return = 'Magic' + _return;
	}

    /* Your code ends here.
       Don't add or change anything after this line.*/
       return _return;      
}




function part4(array_index, array) {
    // Assign the return value to a variable named _return
    let _return = '';
    // Your code should start here

    if (array_index >= 0 && array_index < array.length){
        let modulus = array[array_index] % 2;
        if (array[array_index] === 0) {
            _return = true;
        }
        else if (modulus === 0) {
            let evenresult = 0;
            let array_index2 = array_index - 1;
            for (let i = 0; i < array_index; i++) {
                evenresult = array[array_index2] + evenresult;
                array_index2 = array_index2 - 1;
            }
            _return = evenresult;
        }
        else if (modulus !== 0) {
            let oddresult = 0;
            let array_index2 = array_index + 1;
            for (let i = array_index2; i < array.length; i++) {
                oddresult = array[i] + oddresult;
                array_index2 = array_index2 + 1;
            }
            _return = oddresult;
        }
        else {
            _return = false;
        }
    }
    else{
        _return = false;
    }

    /* Your code ends here.
       Don't add or change anything after this line.*/
    return _return;
}


function part5(array) {
    // Assign the return value to a variable named _return
    let _return = '';
    // Your code should start here
    console.log(array)

    const evenarray = [];
    const oddarray = [];
    let evensum = 0;
    let oddsum = 0;
    let j = 0;
    let k = 0;

    if (array.length > 0) {
        for (let i = 0; i < array.length; i++) {
            let modulus = array[i] % 2;
            if (modulus !== 0) {
                oddsum += array[i];
                oddarray[j] = array[i];
                j++;
            } else {
                evensum += array[i];
                evenarray[k] = array[i];
                k++;
            }
        }
        for (let i = 0; i < evenarray.length; i++) {
            oddarray[j] = evenarray[i];
            j++;
        }
        let newarray = [oddsum, evensum];
        let l = oddarray.length;
        for (let i = 0; i < newarray.length; i++) {
            oddarray[l] = newarray[i];
            l++;
        }
        _return = oddarray;
        console.log(oddarray);
    }
    else{
            _return = [evensum, oddsum];
    }


























    /* Your code ends here.
       Don't add or change anything after this line.*/
    return _return;
}


