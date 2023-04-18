import { useReducer } from "react";


// state : 현재 상태
// dispatch : 상태를 업데이트 하는 함수
// reducer : 개발자가 외부에 만들어야 하는 함수

const reducer = (state, action) => {
    //액션의 타입에 따라 다른 작업 수행
    switch(action.type) {
        case "INCREMENT":
            return {value:state.value + 1};
        case "DECREMENT":
            return {value:state.value - 1};
        default :
            return state;
    };
};

const UseReducerCnt = () => {
    const [state, dispatch] = useReducer(reducer, {value:0});
    return (
        <>
        <p>현재 카운터 값은 <b>{state.value}</b></p>
        <button onClick={() => dispatch({type:"INCREMENT"})}>+1</button>
        <button onClick={() => dispatch({type:"DECREMENT"})}>-1</button>
        </>
    );
};

export default UseReducerCnt