class Vehicle{
    constructor(maker, model, year, color){
        this.maker = maker;
        this.model = model;
        this.year = year;
        this.color = color;
        this.speed = speed;
    }
    getMaker(){
        return this.maker;
    }
    getModel(){
        return this.model;
    }
    getYear(){
        return this.year;
    }
    getColor(){
        return this.color;
    }
    getSpeed(){
        return this.speed;
    }

    accelerate(amount){
        this.speed += amount;
        console.log(`The ${this.maker} ${this.model} is now going ${this.speed} km/h.`);
    }
    break(amount){
        this.speed -= Math.max(0, this.speed - amount);
        console.log(`The ${this.maker} ${this.model} is now going ${this.speed} km/h.`);
    }
}

class Car extends Vehicle{
    constructor(maker, model, year, color, numDoors){
        super(makr, model, year, color);
        this.numDoors = numDoors;
    }
    getNumDoor(){
        return this.numDoors;
    }
}