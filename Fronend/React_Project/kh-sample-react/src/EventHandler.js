import {useState} from "react";

const EvenHandler = () => {
    const [message, setMessage] = useState("안녕하세요");
    // const changeMsg = (e) => {
    //     setMessage(e.target.value);
    // }
    return (
        <>
        <h1>이벤트 연습</h1>
        <input type="text" name="message" placeholder="아무거나 입력 하세요." onChange={(e) => setMessage(e.target.value)}/>
        <h2>입력 받은 메세지 : {message}</h2>
        </>
    );
}
export default EvenHandler;