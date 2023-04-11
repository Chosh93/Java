import React from "react";

// props 기본값 설정 : defaultProps
// props값을 따로 지정하지 않는 경우, 보여줄 기본값을 설정 합니다.
// children : 태그 사이의 내용을 전달 받아 보여줌


// 구조분해(비구조화할당) : 배열이나 객체의 속성 혹은 값을 해체하여 그 값을 변수에 담아 표현하는 자바스크립트 표현식
const MyComponent = ({name, children}) =>{
    // const {name, children} = props;
    return (
        <>
        <p>안녕하세요. 제 이름은 {name} 입니다.</p>
        <p>저의 취미는 {children} 입니다.</p>
        </>
    );
}
MyComponent.defaultProps = {
    name: "기본이름"
};
export default MyComponent;