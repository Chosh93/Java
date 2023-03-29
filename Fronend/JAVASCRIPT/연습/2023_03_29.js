// 날짜와 시간을 다루는 Date 객체
const date = new Date();
console.log(Math.floor(date));

// 인스턴스 만들기

// 월은 0부터 시작, GMT 기준 시간으로 설정
const date1 =  new Date(2022, 11, 27, 18, 30, 50);
console.log(date1);

// 원하는 달로 입력됨
const date2 = new Date("2022-12-25/18:30:50");
console.log(date2);

// Date 객체의 메소드
let myDate = new Date();
console.log(myDate.getFullYear()); // 현재 년도 출력
console.log(myDate.getMonth()); // 현재 월 출력
console.log(myDate.getDate()); // 현재 날짜 출력
console.log(myDate.getDay() + 1); // 현재 요일 출력 0부터 시작
console.log(myDate.getHours()); // 현재 시간 출력
console.log(myDate.getMinutes()); // 현재 분 출력
console.log(myDate.getSeconds()); // 현재 초 출력
console.log(myDate.getTime()); // 1970년 1월1일 0시0분 부터 지금까지 경과

console.log(typeof(myDate));


let date3 = new Date("2023-07-25");
console.log(Math.floor(date3));

// Map 객체 : 자바스크립트에서 제공하는 데이터 구조 중 하나로 key-value 쌍으로 데이터를 저장 관리합니다.
// Map은 객체와 유사하지만, 객체와는 다르게 키에 다양한 자료형을 사용 할 수 있습니다.
let map = new Map();
map.set("name", "유나");
map.set("email", "yuna@gmail.com");
map.set("addr", "경기도 수원시");

console.log(map.size);
console.log(map.get("name"));
console.log(map.get("email"));
console.log(map.get("addr"));

map.forEach((item) =>{
    console.log(item);

});

// 수학 연산을 다루는 Math 객체(자바랑 똑같음)
console.log(Math.abs(-5)); // 출력: 5
console.log(Math.ceil(1.1)); // 출력: 2
console.log(Math.floor(1.9)); // 출력: 1
console.log(Math.round(1.4)); // 출력: 1
console.log(Math.max(1, 2, 3)); // 출력: 3
console.log(Math.min(1, 2, 3)); // 출력: 1
console.log(Math.pow(2, 3)); // 출력: 8
console.log(Math.sqrt(9)); // 출력: 3
console.log(Math.random()); // 출력: 0 이상 1 미만의 임의의 수