// 폼 요소의 시작은 항상 form 태그입니다.
// 폼요소는 input, select, button 태그가 있다.
// 폼 요소를 선택 할 때는 elements 속성이나 name 속성을 사용
// document.frm.id.value = "곰돌이1";
// document.frm.pw.value = "1234";



// function inputCall() {
//     let id = document.frm.id.value;
//     console.log(id);
//     let pwd = document.frm.pw.value;
//     console.log(pwd);
//     let desc = document.frm.desc.value;
//     console.log(desc);
// }

// 체크박스, 콤보박스 다루기 : 체크박스도 value 속성으로 값을 가져 올 수 있음
// const optEl = document.querySelectorAll("option");
// for(let e of optEl){
//     if(e.value === "banana") 
//     e.selected = true;
// }

// 파일 업로드
function upload() {
    const filePath = document.frm.upload.files;
    conslog.log(filePath);
}