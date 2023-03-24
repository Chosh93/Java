let num1;
let num2;
let num3;
num1 = prompt("첫번째 정수를 입력하세요 : ");
num2 = prompt("두번째 정수를 입력하세요 : ");
num3 = prompt("세번째 정수를 입력하세요 : ");
if(num1 >= num2){
    if(num1 >= num3){
        document.write(num1+ " " + num2 + " " + num3 + "<br>");
        document.write("가장 큰 수 : " + num1);
    }
} else if(num2 >= num1){
    if(num1 >= num3){
        document.write(num1+ " " + num2 + " " + num3 + "<br>");
        document.write("가장 큰 수 : " + num2);
    }
} else if(num3 >= num1){
    if(num1 >= num2){
        document.write(num1+ " " + num2 + " " + num3 + "<br>");
        document.write("가장 큰 수 : " + num3);
    }
}    