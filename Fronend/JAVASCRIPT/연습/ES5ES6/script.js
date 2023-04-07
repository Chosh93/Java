// Array 메소드 : ES5에서 추가 되었으며, 코드를 간결하고 효율적으로 만들어줌
// 원본 데이터를 변형하지 않는다.
// forEach() : 배열의 각 요소를 순회하며, 요소에 대해 지정된 함수를 실행하는 메소드
// map() : 배열의 모든 요소를 순회하면서 새로운 배열을 만듭니다.
// filter() : 배열의 요소 중에서 조건을 만족하는 요소만 추출하여 새로운 배열을 만듬
// reduce() : 배열의 모든 요소를 순회하여, 순회 과정에서 누적값을 사용하여 하나의 결과 값을 만듬

let numbers = [1,2,3,4,5,6,7,8,9,10];
numbers.forEach(num => console.log(num));

let squares = numbers.map(num => num*num);
console.log(squares);

let evenNumbers = numbers.filter(num => num%2==0);
console.log(evenNumbers);

let sum = numbers.reduce((tot, num) => tot + num, 0);
console.log(sum);

// let : 변경 가능
// const : 변경 불가능
// const x = 100;
// x = 200;
// console.log(x);

// ES6 : 자바스크립트의 6번째 버전으로, 2015년에 발표
// 자바스크립트도 기본타입과 객체 타입으로 나누어지며, 객체타입의 경우 주소를 가짐

const arr = [1,2,3];
arr[0] = 100;
arr[1] = 200;
arr[2] = 300;
console.log(arr);
// arr = [4,5,6];
// console.log(arr); // 값을 변경하지 못함.

const arr1 = [1,2,3];
const arr2 = [4,5,6];
const newArr = arr1.concat(arr2);
console.log(newArr);


// 화살표 함수 : 화살표 함수는 간단하고 간결한 코드를 작성하는데 유용
const add = function(x,y){
    return x+y;
}
const add1 = (x,y) => x+y;

// 화살표 함수 사용시 this 문제 해결
// 기존의 함수 정의 방식에서 함수 내부에서 this 키워드를 사용 할 때,
// 호출되는 위치에 따라 참조하는 객체가 다르게 결정되는 문제가 있음.
// 하지만 화살표 함수에서는 함수 내부에서 this. 키워드를 사용할 때, 자신이 속한 객체를 참조함 이를 Lexical this라고 부름.


const obj = {
    name : "곰돌이",
    func1(){
        const func2 = () => {//     const func2 = function() { 
        console.log(this.name);//         console.log(this.name); // this.name을 참조하지 않음 
        }//     }
        func2();
    }
};
obj.func1();

// const btn = document.getElementById("myButton");
// btn.addEventListener("click", () =>{
//     console.log(this); // Window
// });
// const btn = document.getElementById("myButton");
// btn.addEventListener("click", function() {
//     console.log(this); // Window
// });
// const pEls = document.querySelectorAll("p");
// pEls.forEach(e => e.addEventListener("click", function(){
//     console.log(this);
// }));


// 템플릿 리터럴 : 백틱(``)으로 묶는 문자열을 템플릿 리터럴이라고 합니다.
// 템플릿 리터럴은 변수를 쉽게 포함할 수 있고 여러줄의 문자열을 쉽게 표시
const name = "곰돌이";
const seasonMsg = "봄";
const message = "안녕하세요.";

console.log(`${message}, ${name}!, 화창한 ${seasonMsg}날 입니다.`);

// 전개 연산자(Spread operator) : 배열이나 객체를 개별 요소로 분리
const arr10 = [1,2,3];
const arr20 = [4,5,6];
const newArr2 = [...arr10, ...arr20];
console.log(newArr2);
const arr30 = [1,2,3,4,5,6,7,8,9,10];
const arr40 = [...arr30];
console.log(arr40);


// 전개 연산자를 이용한 가변 인수 함수 만들기
function sum2(...numbers){
    return numbers.reduce((tot, num) => tot+num, 0);
};
console.log(sum2(1,2,3,4,5,6,7,8,9,10));