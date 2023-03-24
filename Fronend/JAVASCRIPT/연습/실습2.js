let time;
let hour;
let min;
hour = prompt("시간을 입력하세요 : ");
hour = Number(hour);
min = prompt("분을 입력하세요 : ");
min = Number(min);
document.write("시간 정보 : "+ hour + "시 "+ min + "분<br>" );
if(min >= 45){
    min = min - 45;
    document.write("알람 시간은 : " + hour + "시 " + min + "분");
} else if(min < 45){
    min = (min + 15);
    hour = hour - 1;
    document.write("알람 시간은 : " + hour + "시 " + min + "분");
}