import {useState} from "react";

const Clock = () => {
    const [date, setDate] = useState(new Date());
    const tick = () => {
        setDate(new Date());
    }
    setInterval(tick, 1000);
    return (
        <>
        <h1>현재 시간을 표시합니다.</h1>
        <h2>현재 시간 : {date.toLocaleTimeString()}</h2>
        </>
    );
};

export default Clock;