// 함수 표현식은 변수에 함수를 할당해서 사용하는 방식 입니다.
// 함수 표현식은 변수에 할당하는 함수에 식별자가 있으면 네이밍함수, 없으면 익명함수 하고 구분합니다.
// 호이스팅이 적용되지 않음
// const 변수명 = function(){}

const gugudan = function(){
    for(let i = 1; i < 10; i++){
        console.log(`3 * ${i} = ${3*i}`);
    }
}
console.log(gugudan());

// 화살표 함수로 정의하기
// 화살표 ES6에서 추가된 새로운 함수 선언 방식이며, 함수 선언식 보다 간결하고 가독성이 좋다.

const hi = function(){
    return "안녕하세요?";
}
console.log(hi());

const hi2 = () => "안녕하세요?";
console.log(hi2());

// 화살표 함수에서 매개변수 정의
const sum = num1 => console.log(num1);
sum(100)

const sum2 = (num1, num2) => console.log(num1 * num2);
sum2(10,20);


// 기본값 할당 : 디폴트 매개변수 값을 주는 방법
// function sum3(a=10, b=20){
//     console.log(a,b);
// }

const sum3 = (a = 10, b = 20)=> console.log(a, b);
sum3();

// return 문 : 함수 외부로 결과를 반환할 때 사용
console.log(sum4(100));
function sum4(a = 10, b =20){
    return a + b;
}

const sum5 = (num1, num2) => num1 + num2;
console.log("결과 : " + sum5(100, 200));


// 함수 스코프 : 함수에서 정의한 블록문만 스코프의 유효 범위로 인정
// 블록 스코프 : {}로 구성된 블록문 기주으로 스코프의 유효 범위
// let a = 10;
// {
//     let b = 20;
//     console.log(`코드 블록 내부 : a : ${a}`);
//     console.log(`코드 블록 내부 : b : ${b}`);
// }
// console.log(`코드 블록 내부 : a : ${a}`);
// console.log(`코드 블록 내부 : b : ${b}`);

// var 키워드 : 블록 스코프를 따르지 않고 호이스팅이 발생 함
var a = 10;
{
    var b = 20;
    console.log(`코드 블록 내부 : a : ${a}`);
    console.log(`코드 블록 내부 : b : ${b}`);
}
console.log(`코드 블록 내부 : a : ${a}`);
console.log(`코드 블록 내부 : b : ${b}`);


// 즉시 실행 함수 : 함수를 정의하자마자 바로 실행하는 것을 의미

(function(){
    let message = "Hello, world !!!";
    console.log(message);
})();