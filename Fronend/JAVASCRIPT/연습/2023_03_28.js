// 문자열의 길이 체크 : length

const pw = "124";
if(pw.length < 4){
    console.log("비밀번호는 최소 4자리 이상 입력 해주세요.");
}

// 특정 문자열의 포함 여부 확인 : includes
const email = "abc!gmail.com";
if(email.includes("@") === false){
    console.log("올바른 이메일 형식이 아닙니다.");
}

const email2 = "abc!gmail.com";
if(email2.indexOf("@") === -1){
    console.log("올바른 이메일 형식이 아닙니다.");
}


// 찾고자 하는 문자열이 둘 이상 발견되면 제일 마지막에 발견된 문자열의 index를 반환 하는 함수
const email3 = "@abc@gmail.com@";
console.log(email3.lastIndexOf("@"));


// slice() : 시작 위치와 종료 위치를 주면 문자열에서 해당 부분을 잘라내서 반환
let str = "Apple, Banana, Kiwi";
let res = str.slice(7,-1); // 7~13 7이상 13미만
console.log(res);


// subString() : 시작 위치와 종료 위치를 주면 문자열에서 해당 부분을 잘라내서 나머지 반환
let str2 = "Apple, Banana, Kiwi";
let res2 = str2.substring(7, -1); // 7~13 7이상 13이하
console.log(res2);

// replace() : 문자열 내의 특정 문자열을 지정한 문자열로 바꾸는 함수
let str3 = "지구오락실, 이영지, 안유진, 미미, 이은지, 안유진";
let newStr = str3.replace("안유진", "나영석");
console.log(newStr);

// replaceAll() : 문자열 내의 특정 문자열을 지정한 문자열로 모두 바꾸는 함수
console.log(str3);
let newStr2 = str3.replaceAll("안유진", "나영석");
console.log(newStr2);

// toUpperCase / toLowerCase 문자열을 모두 대문자 및 소문자로 변경
let alpha = "Better late than never.";
console.log(alpha.toUpperCase());
console.log(alpha.toLowerCase());

// concat() : 2개 이상의 문자열을 하나의 문자열로 합치는 함수
// 기존 문자열을 변경하지 않고 합쳐진 새로운 문자열을 생성(불변성)
let text1 = "Hello";
let text2 = "World";
let text3 = text1.concat(" ", text2);
console.log(text3);

// trim() : 문자열 앞, 뒤 공백을 제거
let str5 = " Hello JavaScript!!! ";
console.log(str5.trim());

// padStart(), padEnd() : 문자열 앞과 뒤에 지정된 길이만큼 추가하는 함수
let str6 = "5";
str6 = str6.padStart(4, 0); // 총 길이, 자리가 비는경우 0으로 채움
console.log(str6);
str6 = str6.padEnd(10, 1);
console.log(str6);

// chatAt() : 문자열에서 특정 인덱스에 해당하는 문자 하나를 반환하는 함수
let addr = "서울시 강남구 역삼동 H정보교육원";
console.log(addr.charAt(5));

// charCodeAt() : 문자열에 특정 인덱스에 해당하는 문자 하나의 유니코드 반환
let uniCode = "HELLO WORLD";
console.log(uniCode.charCodeAt(1));

// split() : 특정 문자 기준으로 문자열을 잘라서 새로운 문자열로 이루어진 배열 생성
let birthDay = "1997-06-12";
let arr2 = birthDay.split("-");
console.log(arr2);


// Number 객체 : 객체에 정의되어 있는 수자와 관련된 작업을 할 때 사용되는 메소드
// Number.parseFloat() : 문자열에 포함된 숫자 부분을 실수 형태로 반환

let str7 = "1234 12";
console.log(Number(str7));
console.log(Number.parseFloat(str7));
console.log(Number.parseInt(str7));

// 배열을 다루는 Array객체
// forEach() : 비파괴적인 메소드이며, 요소를 순회

const arr = [10, 20, 30, 40, 50];
arr.forEach(function(n){
    console.log(n);
});

// to String() : 배열안의 모든 문자를 쉼표(,)를 이용해 모두 결합해서 하나의 문자열로 반환
let fruits = ["Banana", "Orange", "Apple", "Mango"];
console.log(fruits.toString());

// join() : 배열안의 모든 문자를 파라미터로 지정한 문자를 이용해서 모두 결합
console.log(fruits.join("/"));

// shift() : 첫번째 오소를 제거하고 값을 반환
console.log(fruits.shift());
console.log(fruits);

// unshift() : 배열의 맨앞에 요소를 추가하고 배열의 길이를 반환
console.log(fruits.unshift("Lemon"));
console.log(fruits);

let persons = [
    {
        name : "유재석",
        point : 78,
        city : "서울"
    },
    {
        name : "김종국",
        point : 92,
        city : "서울"
    },
    {
        name : "양세찬",
        point : 76,
        city : "제주"
    },
    {
        name : "하하",
        point : 81,
        city : "인천"
    }
];

let pass = persons.filter(e => e.point > 80);
console.log(pass);