// 함수 선언문 : function 키워드로 선언하며 함수 이름을 가짐. 호이스팅에 영향을 받음.
// 호이스팅 : 함수나 변수가 해당 스코프의 최상단으로 끌어 올려진 것 같은 현상을 말한다.
// 호이스팅의 영향을 받는다는 건 함수가 선언된 위치에 상관 없이 호출하여 실행 할 수 있음을 의미


function sum(p1, p2){
    let sum = p1 + p2;
    return sum;
}

let sum1 = sum(21, 24);
let sum2 = sum(100,200);
console.log(sum1, sum2);

// 함수와 switch문 사용
console.log("덧셈 : " + calculator(10,20,"+"));
console.log("뺄셈 : " + calculator(10,20,"-"));
console.log("곱셈 : " + calculator(10,20,"*"));
console.log("나눗셈 : " + calculator(10,20,"/"));




function calculator(n1, n2, op){
    switch(op){
        case "+" : return add(n1, n2); // add 함수의 결과 값이 반환됨
        case "-" : return sub(n1, n2);
        case "*" : return mul(n1, n2);
        case "/" : return div(n1, n2);
    }
}
function add(a, b){
    return a+b;
}
function sub(a, b){
    return a-b;
}
function mul(a, b){
    return a*b;
}
function div(a, b){
    return a/b;
}

