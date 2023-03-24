function primeMain(){
    let sum = 0;
    let number = document.getElementById('name').value;
    for(let i = 0; i <= number; i++){
        sum += primeNum(i);
    }
    document.write("=" + sum);
    return 0;
}

function primeNum(num){
    let cnt = 0;
    for(let i = 1; i <= num; i++){
        if(num % i == 0) cnt++;
    }
    if(cnt == 2){
        document.write(num + " + ");
        return num;
    } else return 0;
}