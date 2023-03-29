function win(){
    const entry = document.getElementById("entry").value;
    const winNum = Math.floor(Math.random()*entry)+1;
    document.getElementById("result").innerHTML = `${winNum}`;
}