document.addEventListener("DOMContentLoaded", () => {

});

// 메뉴는 [1]예매하기, [2]종료하기
// 사용자로부터 좌석번호(index)를 입력받아 예매하는 시스템 (좌석은 10개)
// [V] [V] [V] [ ] [ ] [ ] [ ] [ ] [ ] [ ]
// 예매가 완료되면 해당 좌석 값을 1로 변경한다.
// 이미 예매가 완료된 좌석은 재구매할 수 없다.
// 한 좌석당 예매 가격은 12000원이다.
// 프로그램 종료 후 , 해당 영화관의 총 매출액을 출력한다.

document.addEventListener("DOMContentLoaded", ()=>{
    printSeat();
    const exitBtn = document.querySelector("#exitBtn");
    exitBtn.addEventListener("click", exitProgram);
})

const count = 10;
let seats;
(seats = []).length = count;
seats.fill(0);
const price = 12000;
let total = 0;

function printSeat(){
    console.log(seats);
    const seatsDiv = document.querySelector("#seats");
    seatsDiv.innerHTML="";

    for(let i = 0; i < count; i++){
        const seat = document.createElement("div");
        seat.classList.add("seat");
        if(seats[i] === 1){
            seat.classList.add("booked");
        }
        seat.textContent = i + 1;
        seat.addEventListener("click", () => bookSeat(i));
        seatsDiv.appendChild(seat);
    }
}
function bookSeat(index){
    if(seats[index] === 1){
        var btn_dis = document.getElementsByClassName('seat');
        btn_dis.disalbed = true;
    } else {
        seats[index] = 1;
        total += price;
        alert("예매가 완료 되었습니다.");
    }
}
function exitProgram(){
    alert(`총 매출액은 ${total}원 입니다.`);
    console.log(seats);
}