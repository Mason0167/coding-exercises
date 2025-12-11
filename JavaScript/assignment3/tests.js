"use strict";

const chai = window.chai;
const expect = chai.expect;

 describe('Circle Constructor', () =>  {
    it('This function is to calculate the area and the circumference of the circle',  () => {
        expect(new Circle(3).area()).to.deep.equal(28.27);
        expect(new Circle(3).perimeter()).to.deep.equal(18.85);
        expect(new Circle(7).area()).to.deep.equal(153.94);
        expect(new Circle(7).perimeter()).to.deep.equal(43.98);
        expect(new Circle(9).area()).to.deep.equal(254.47);
        expect(new Circle(9).perimeter()).to.deep.equal(56.55);
    })
})

describe('Lucky Seven', () =>  {
    it('This function is to calculate weekly salary',  () => {
        expect(calculateSalary([8,8,8,8,8,0,0])).to.deep.equal(400);
        expect(calculateSalary([10,10,10,0,8,0,0])).to.deep.equal(410);
        expect(calculateSalary([0,0,0,9,8,8,10])).to.deep.equal(555);
        expect(calculateSalary([0,0,0,0,0,12,0])).to.deep.equal(280);
    })
})

describe('Index Multiplier', () =>  {
    it('This function is to calculate the sum of all items in the array and multiplied by its index ',  () => {
        expect(indexMultiplier([1,2,3,4,5])).to.deep.equal(40);
        expect(indexMultiplier([-3,0,8,-6])).to.deep.equal(-2);
        expect(indexMultiplier([15,16,-100,50])).to.deep.equal(-34);
    })
})

describe('Filtered JSON', () =>  {
    it('This function is to filter specific requirements and display a new array',  () => {
        expect(filteredJSON([{id : 1, u : "batman"}])).to.deep.equal([]);
        expect(filteredJSON([{id : 11, u : "spidey"}])).to.deep.equal([{id: 11, u: "spidey"}]);
        expect(filteredJSON([{id : 10, u : "spidey"}])).to.deep.equal([]);
        expect(filteredJSON([{id : 11, u : "batman"}])).to.deep.equal([]);
        expect(filteredJSON([{id : 1, u : "batman"}, {id : 11, u : "spidey"}])).to.deep.equal([{id: 11, u: "spidey"}]);
        expect(filteredJSON([{id : 11, u : "spidey"}, {id : 11, u : "spidey"}])).to.deep.equal([{id : 11, u : "spidey"}, {id: 11, u: "spidey"}]);
    })
})

describe('Break Array', () =>  {
    it('This function is to divides the array into chunks of size n',  () => {
        expect(breakAway([2,3,4,5], 2)).to.deep.equal([[2,3],[4,5]]);
        expect(breakAway([2,3,4,5,6], 2)).to.deep.equal([[2,3], [4,5], [6]]);
        expect(breakAway([2,3,4,5,6,7], 3)).to.deep.equal([[2,3,4], [5,6,7]]);
        expect(breakAway([2,3,4,5], 1)).to.deep.equal([[2],[3],[4],[5]]);
        expect(breakAway([2,3,4,5,6,7], 7)).to.deep.equal([[2,3,4,5,6,7]]);
    })
})









