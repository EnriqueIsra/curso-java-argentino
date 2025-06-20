import PropTypes from "prop-types";

export const ProductTable = ({ products }) => {
  return (
    <table className="table table-hover table-striped">
      <thead>
        <tr>
          <th>id</th>
          <th>name</th>
          <th>description</th>
          <th>price</th>
        </tr>
      </thead>
      <tbody>
        {products.map((product) => {
          return (
            <tr key={product.id}>
              <td>{product.id}</td>
              <td>{product.name}</td>
              <td>{product.description}</td>
              <td>{product.price}</td>
            </tr>
          )
        })}
      </tbody>
    </table>
  );
};
ProductTable.propTypes = {
  products: PropTypes.array.isRequired,
};
