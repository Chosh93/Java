import {useState, useEffect} from "react";

const UseEffectClock = () => {
    const [time, setTime] = useState(new Date());
    useEffect(() => {
        const interval = setInterval(() => {
            setTime(new Date());
        }, 1000);
        // 해당하는 컴포넌트가 Unmount 되면 interval을 해제
        return() => clearInterval(interval);
    }, []);
    return (
        <>
        <h1>현재 시간 : {time.toLocaleTimeString()}</h1>
        </>
    );
};
export default UseEffectClock;