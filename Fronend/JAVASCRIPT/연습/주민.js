// 길이체크, 하이픈이 있는지 체크해서 하이픈이 없으면 재 입력 요구 하도록
// 성별 확인 123456-1234567
// 문자열에서 해당 문자 추출은 charAt(n)
// 문자열 잘라내기 substring(0,2) 0부터 2미만까지 잘라냄
// 날짜 객체를 만드는 방법도 자바와 동일 const date = new Date();
// 날짜 객체에서 현재 년도 가져오기 : date.getFullYear();
// 현재 년도 = 태어난 년도 = 나이
// 결과는 html로 출력하기

let jumin;
while(true){
    jumin = prompt("주민등록번호 : ", "");
    if(jumin.length != 14) alert("입력 오류 : 다시 입력하세요.");
    else{
        if(jumin.indexOf("-") == -1) alert("하이픈이 누락되었습니다.");
        else break;
    }
}
let gender = jumin.charAt(7);
let prnGender;
if(gender == "1" || gender == "3") {
    prnGender = "남성";
    document.write(prnGender);
}
else {
    prnGerder = "여성";
    document.write(prnGender);
}