// const btnE1 = document.querySelector("button");
// btnE1.addEventListener("click", function(e){
//     console.log("버튼 눌림" + e);
//     console.log("x좌표 : " + e.clientX);
//     console.log("y좌표 : " + e.clientY);
//     console.log("마우스가 클릭된 x좌표" + e.pageX);
//     console.log("마우스가 클릭된 y좌표" + e.pageY);
//     console.log("모니터의 왼쪽 모서리 기준으로 마우스가 클릭된 x축 좌표" + e.screenX);
//     console.log("모니터의 왼쪽 모서리 기준으로 마우스가 클릭된 y축 좌표" + e.screenY);
// });

const inputEl = document.querySelector("input");
inputEl.addEventListener("keydown", function(event){
    console.log(`keyCode : ${event.keyCode}`);
    console.log(`ctrlKey : ${event.ctrlKey}`);
    console.log(`altKey : ${event.altKey}`);
    console.log(`shiftKey : ${event.shiftKey}`);
});

// 이벤트 취소하기 : html태그 중 일부는 기본으로 이벤트가 적용되어 있습니다.
// 대표적으로 a태그와 form 태그가 해당 됩니다.
// target 속성은 이벤트가 발생한 요소를 나타냅니다.( 리액트에서 확이 할 예정 )
// preventDefault()메서드를 사용하면 태그에 기본으로 연결된 이벤트를 취소할 수 있습니다.

const aEls= document.querySelector("a");
for(let e of aEls){
    e.addEventListener("click", function(e){
        // 기본 이벤트 취소
        e.preventDeFault();
    });
}
const form = document.getElementById("myForm");
form.addEventListener("submit", function(e){
    event.preventDefault();
})