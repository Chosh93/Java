import { useEffect, useState } from "react";
import "./App.css";
// 배열로 구성된 객체를 전달 받아 map으로 화면에 표시하고
// 표시된 화면 영역에 이벤트 연결하기
const TableMap = () => {
    const data = [
        { id: 1, name: 'John', age: 25},
        { id: 2, name: 'Jane', age: 30},
        { id: 3, name: 'Tom', age: 28}
    ];
    const [mapData, setMapData] = useState("");

    useEffect(() => {
        setMapData(data);
    }, []);

    const handleTalbeRowClick = (item) => {
        console.log(item);
    };

    return (
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Age</th>
                </tr>
            </thead>
            <tbody>
                {mapData && mapData.map(item => (
                    <tr key={item.id} onClick={() => handleTalbeRowClick(item)}>
                        <td>{item.id}</td>
                        <td>{item.name}</td>
                        <td>{item.age}</td>
                    </tr>
                ))}
            </tbody>
        </table>
    );
}
export default TableMap;