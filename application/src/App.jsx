import { useState, useEffect } from "react";
import "./App.css";

function App() {
  const [count, setCount] = useState(0);
  const [testData, setTestData] = useState([]);

  useEffect(() => {
    fetch("/api/?maker=ferrari")
      .then((result) => result.json())
      .then((data) => {
        console.log(data);
        setTestData(data);
      });
  }, []);

  return (
    <div className="App bg-slate-200 p-10">
      <h1>Vite + React</h1>
      <div className="card">
        <button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
      </div>
      <table className="table-auto">
        <thead>
          <tr>
            <th>Make</th>
            <th>Model</th>
            <th>Model ID</th>
            <th>Ad Year</th>
            <th>Ad Month</th>
            <th>Color</th>
            <th>Model Year</th>
            <th>Bodytype</th>
            <th>Miles</th>
            <th>Engine Size</th>
            <th>Gearbox</th>
            <th>Fuel Type</th>
            <th>Price</th>
            <th>Seats</th>
            <th>Doors</th>
          </tr>
        </thead>
        <tbody>
          {testData.map((ad) => (
            <tr key={ad.adv_id}>
              <td>{ad.maker}</td>
              <td>{ad.genmodel}</td>
              <td>{ad.genmodel_id}</td>
              <td>{ad.adv_year}</td>
              <td>{ad.adv_month}</td>
              <td>{ad.color}</td>
              <td>{ad.reg_year}</td>
              <td>{ad.bodytype}</td>
              <td>{ad.runned_miles}</td>
              <td>{ad.engin_size}</td>
              <td>{ad.gearbox}</td>
              <td>{ad.fuel_type}</td>
              <td>${ad.price}</td>
              <td>{ad.seat_num}</td>
              <td>{ad.door_num}</td>
            </tr>
          ))}
        </tbody>
      </table>
      ;
    </div>
  );
}

export default App;
