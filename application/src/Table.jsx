function Table({ pageData }) {
  // Create number formatter.
  const moneyFormatter = new Intl.NumberFormat("en-US", {
    style: "currency",
    currency: "USD",
    maximumFractionDigits: 0, // (causes 2000.99 to be printed as $2,001)
  });

  return (
    <table className="m-auto table-auto">
      <thead>
        <tr>
          <th>Make</th>
          <th>Model</th>
          <th>Model ID</th>
          <th>Ad ID</th>
          <th>Ad Year</th>
          <th>Ad Month</th>
          <th>Color</th>
          <th>Model Year</th>
          <th>Bodytype</th>
          <th>Mileage</th>
          <th>Engine Size</th>
          <th>Gearbox</th>
          <th>Fuel Type</th>
          <th>Price</th>
          <th>Seats</th>
          <th>Doors</th>
        </tr>
      </thead>
      <tbody>
        {pageData.map((ad, i) => (
          <tr
            key={ad.adv_id}
            className={
              i % 2 == 0
                ? "border-b bg-white dark:border-gray-700 dark:bg-gray-900"
                : "border-b bg-gray-300 dark:border-gray-700 dark:bg-gray-800"
            }
          >
            <td>{ad.maker}</td>
            <td>{ad.genmodel}</td>
            <td>{ad.genmodel_id}</td>
            <td>{ad.adv_id}</td>
            <td>{ad.adv_year}</td>
            <td>{ad.adv_month}</td>
            <td>{ad.color}</td>
            <td>{ad.reg_year}</td>
            <td>{ad.bodytype}</td>
            <td>{ad.runned_miles.toLocaleString()} mi</td>
            <td>{ad.engin_size}</td>
            <td>{ad.gearbox}</td>
            <td>{ad.fuel_type}</td>
            <td>{moneyFormatter.format(ad.price)}</td>
            <td>{ad.seat_num}</td>
            <td>{ad.door_num}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

export default Table;
