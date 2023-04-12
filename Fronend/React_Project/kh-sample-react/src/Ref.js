import { useRef } from "react";

const CreateRef = () => {
    const inputRef = useRef(null); // useRef() 함수 호출
    const handleFocus = () =>{
        inputRef.current.disabled = false;
        inputRef.current.focus();
    };
    return (
        <>
        <input disabled type="text" ref={inputRef}/>
        <button onClick={handleFocus}>활성화</button>
        </>
    );
}

export default CreateRef;