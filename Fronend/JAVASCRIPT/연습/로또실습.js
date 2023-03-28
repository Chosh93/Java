function lotto(){
    const numbers = [];
    const container = document.getElementById("container");
    container.innerHTML ="";

    while(numbers.length < 6){
        const number = Math.floor(Math.random() * 45) + 1;
        if(!numbers.includes(number)){
            numbers.push(number);
        }
    }
    for(let num of numbers){
        const div = document.createElement('div');
        div.classList.add('number');
        div.textContent = num;
        container.appendChild(div);
    }
    console.log(numbers);
};