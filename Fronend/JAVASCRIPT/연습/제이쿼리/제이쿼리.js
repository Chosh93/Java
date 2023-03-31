// let colorBtn = document.getElementById("colorButton");
// let colors = ["red", "orange", "yellow", "green", "blue", "indigo", "violet"];
// let colorInx = 0;

// colorBtn.addEventListener("click", function(){
//     document.body.style.background = colors[colorInx];
//     colorInx = (colorInx +1)% colors.length;
// });

// $(document).ready(function() {
//     var colors = ["red", "orange", "yellow", "green", "blue", "purple"];
//     var colorIndex = 0;
  
//     $("#colorButton").click(function() {
//       $("body").css("background-color", colors[colorIndex]);
//       colorIndex = (colorIndex + 1) % colors.length;
//     });
//   });


  $(document).ready(function(){
    let colors = ["red","orange","yellow","green","blue","Indigo","violet"];
    let colorInx = 0; //배열 사용하기 위해 인덱스 생성
    
    $("#colorButton").click(function(){
        $("body").css("background-color",colors[colorInx]);
        colorInx =(colorInx + 1)% colors.length;
        });
    });