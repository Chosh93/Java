function dDay(){
    let selDate = new Date("2023-07-25");
    let today = new Date();
    let remainTime = selDate-today;
    remainTime = Math.round(remainTime/(1000*60*60*24));
    console.log(remainTime);
    
    const container = document.getElementById("container");
    const div = document.createElement('div');
    div.classList.add('Day');
    div.textContent = remainTime;
    container.appendChild(div);
}

