import {useState, useEffect} from "react";

const UseEffectCnt = () => {
    const [count, setCount] = useState(0);
    useEffect(() => {
        document.title = `You clicked ${count} times`;
    }, [count])
    return (
        <>
        <p>You Clicked {count} times</p>
        <button onClick={() => setCount(count + 1)}>Click me</button>
        </>
    );
};
export default UseEffectCnt;
