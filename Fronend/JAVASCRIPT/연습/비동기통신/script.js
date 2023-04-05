const xhr = new XMLHttpRequest(); // 객체 생성
xhr.open("POST", "URL 경로"); // IP 주소, Port번호, 백엔드가 수신할 컨트롤러
xhr.setRequestHeader("contents-type", "application/json");
const data = {
    id : 100,
    title : "비동기통신 연습",
    author : "곰돌이"
};

xhr.send(JSON.stringify(data));