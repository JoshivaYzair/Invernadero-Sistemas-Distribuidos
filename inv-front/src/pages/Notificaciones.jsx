import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';

const Notificaciones = () => {
  return (
    <div className='p-2'>
      <div className="jumbotron jumbotron-fluid d-flex justify-content-between d-flex align-items-end">
        <h1 className="display-5 m-0">Notificaciones</h1>
        <Button variant="primary" style={{ height: '45px' }}>
          <i className="bi bi-plus-circle-fill pe-2"></i>
          Nueva Notificación
        </Button>{' '}
      </div>
      <Table bordered hover responsive className='mt-4'>
        <thead>
          <tr>
            <th>Nombre</th>
            <th>Tem. Maxima</th>
            <th>Tem. Minima</th>
            <th>Hum. Maxima</th>
            <th>Hum. Minima</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Inv. Papas No.2</td>
            <td>67 Grados</td>
            <td>20 Grados</td>
            <td>30%</td>
            <td>10%</td>
          </tr>
          <tr>
            <td>Inv. Tomates No.1</td>
            <td>40 Grados</td>
            <td>26 Grados</td>
            <td>50%</td>
            <td>30%</td>
          </tr>
          <tr>
            <td>Inv. Cebollas No.3</td>
            <td>60 Grados</td>
            <td>41 Grados</td>
            <td>20%</td>
            <td>15%</td>
          </tr>
        </tbody>
      </Table>
    </div>
  );
};

export default Notificaciones;
