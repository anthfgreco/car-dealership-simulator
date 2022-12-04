function Table({ pageData }) {
  // Create number formatter.
  const formatter = new Intl.NumberFormat("en-US", {
    style: "currency",
    currency: "USD",
    maximumFractionDigits: 0, // (causes 2000.99 to be printed as $2,001)
  });

  return (
    <table className="">
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
        {pageData.map((ad) => (
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
            <td>{formatter.format(ad.price)}</td>
            <td>{ad.seat_num}</td>
            <td>{ad.door_num}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

export default Table;
