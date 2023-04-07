const xhr = new XMLHttpRequest(); // 객체 생성
xhr.open("POST", "https://jsonplaceholder.typicode.com/posts"); // HTTP Method, URL, IP 주소, Port번호, 백엔드가 수신할 컨트롤러 정의
// 조회일땐 get 설정일땐 post
xhr.setRequestHeader("contents-type", "application/json"); // 헤더값의 content-type 정의
const data = {
    id : "Chosh",
    pwd : "1234",
    name : "TEST",
    addr : "Korea"
}
xhr.send(JSON.stringify(data));
// xhr.send(JSON.stringify(data)); // XMLHttpRequest 객체를 사용하여 서버로 HTTP 요청을 보내는 메서드
// XMLHttpRequest 객체를 사용하여 서버로부터 HTTP 응답을 받았을 때 호출되는 콜백 함수를 설정하는 프로퍼티

xhr.onload = () => {
    if(xhr.status === 201){
        // 정상적으로 응답되면 status가 200
        const res = JSON.parse(xhr.response);
        console.log(res);
    } else {
        // 에버발생
        console.error(xhr.status, xhr.statusText);
    }
};