// 배열 : 자바스크립트의 배열은 자료형을 저장할 수 있다(또 다른 배열도 포함 할 수 있다.)
let score = [80, 99 ,77, 65];
console.log(score);
console.log(score[2]); // 배열은 인덱스로 요소를 접근함(인덱스는 항상 0부터 시작)

// let은 변수를 만드는 키워드. 자바스크립트는 변수를 만들 때 자료형을 지정하지 않으며, 값이 대일될 때 데이터의 형이 결정
// 자바스크립트의 배열은 모든 자료형을 함께 사용 할 수 있음.
let array = ["아이브", "안유진", 21, true, [100, 99, 88], 1010, "1010", ["곰돌이사육사", "수원시", "개발자"]];
console.log(array);
console.log(array[0]);
console.log(array[4]);
console.log(array[4][1]);
console.log(array[0][1]);
console.log(array[6][1]);
console.log(array[7][0][4]);

// 빈 배열 생성 후 동적으로 값을 대입할 수 있음
let arr = [];
arr[0] = 100;
console.log(arr);

// 객체 리터럴 : 중괄호{}를 사용해서 정의하고, 키와 값이 한쌍으로 이루어짐.
let score1 = [80, 99, 77, 65];
let score2 = {
    kor : 80,
    eng : 99,
    mat : 77,
    scn : 87
};
console.log(score1);
console.log(score2);
console.log(score2.kor);        // .(도트)를 사용해서 접근
console.log(score2['mat']);     // 인덱스값을 키값으로 사용해서 접근

const person = {
    name : "곰돌이사육사",
    age : 18,
    city : "seoul",
    // 객체 리터럴에서 함수 사용
    getInfo : function(){
        return `${this.name} is ${this.age} years old and lives in ${this.city}.`;
    }
}
console.log(person.getInfo());

// typeof : 데이터형을 확인하는 예약어
let name = "곰돌이사육사";
console.log(typeof(name));

// toString() : 배열 안의 모든 문자를 쉼표를 이용해 모두 결합해서 하나의 문자열로 반환
let fruits = ["Banana", "Orange", "Apple", "Mange"];
console.log(fruits.toString());
console.log(fruits);

// 산술연산자 : 수학연산을 수행하는 연산자를 의미
let a = 2;
let b = 3;
console.log(a + b);
console.log(a - b);
console.log(a * b);
console.log(b / a);
console.log(a % b);
console.log(a ** b);    // 2*2*2 거듭제곰 a의b제곰
console.log(--a);       // 전위 단항 연산자, 1
console.log(b++);       // 후위 단항 연산자, 3

// 대입 연산자 : 대입연산자와 복합 대입연산자가 있음
let x = 10;
let y = 20;
x += 10;                // x에 10을 더해서 x에 다시 대입
y += x;
console.log(x);
console.log(y);

// 비교 연산자 : 피연산자를 비교한 뒤 참 or 거짓으로 반환하는 연산자
// 비교 연산자는 조건문과 결합외어 사용
// 자바스크립트는 동등연산자 개념과 일치 연산자라는 개념이 있음
// 자바스크립트에서 동등연산자로 두 값을 비교하는 경우, 데이터형이 다르면 자동으로 형변환
console.log(1 == '1');      // 문자열로 변환 후 비교 진행(동등연산자)
console.log(1 === '1');     // 일치연산자, 값과 형이 모두 같은지 비교하는 연산자

let val = '101';
if(val !== 100) console.log("100이 아닙니다.");
else console.log("100 입니다.");

// 논리연산자 : 일반적으로 비교연산자와 결합되어 사용됩니다.
// &&(and), ||(or), !(not)
let aa = 10;
let bb = 5;
let cc = 15;
console.log(aa>bb && aa>cc); //false
console.log(aa>bb || aa>cc); //true
console.log(!(aa>bb && aa>cc)); // true
console.log(!(aa>bb || aa>cc)); // false

// 삼항연산자 : 피연산자가 3개
let num = 7;
const rst = (num % 2 === 0) ? "짝수" : "홀수";
console.log(rst);

let age = 20;
const isAdult = (age>18) ? "성인" : "미성년자";
console.log(isAdult);

// 묵시적 형변환 : 자바스크립트가 자동으로 수행하는 것
let num1 = 10 + "10";
console.log(num1);
if(10=='10') console.log("같음");

// 명시적 형변환 : 개발자가 의도를 가지고 형변환을 하는 것
let num2 = 10;
let num3 = "10";
console.log(10 + Number(num3));
let num4 = 10;
let str = String(num4);
console.log(10 + str);