import { useState } from "react";

const RadioButton = () => {
    const [value, setValue] = useState("apple");
    const handleChange = (event) => {
        setValue(event.target.value);
    }
    return(
        <div>
            <input type="radio" name="fruits" value="apple" onChange={handleChange}/>
            <label>사과</label>
            <br />
            <input type="radio" name="fruits" value="orange" onChange={handleChange} />
            <label>오렌지</label>
            <br />
            <input type="radio" name="fruits" value="strawberry" onChange={handleChange} />
            <label>딸기</label>
            <br />
            <p>Selected value: {value}</p>
        </div>
    );
}
export default RadioButton;