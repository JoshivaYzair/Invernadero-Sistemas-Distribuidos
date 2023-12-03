import React, { useState, useEffect } from 'react';
import Table from 'react-bootstrap/Table';

const Lecturas = () => {
  const [lecturas, setLecturas] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const apiUrl = 'http://localhost:8060/lectura';
  
    const token = localStorage.getItem('jwtToken');
  
    fetch(apiUrl, {
      method: 'GET',
      headers: {
        'Authorization': `Bearer ${token}`,
        'Content-Type': 'application/json',
      },
    })
      .then(response => {
        if (!response.ok) {
          throw new Error('Error en la respuesta');
        }
        return response.json();
      })
      .then(data => {
        setLecturas(data);
        setLoading(false);
      })
      .catch(error => {
        console.error('Error al recuperar los datos:', error);
        setLoading(false);
      });
  }, []);

  return (
    <div className='p-2'>
      {loading ? (
        <p>Cargando...</p>
      ) : (
        <div>
          <div className='jumbotron jumbotron-fluid d-flex justify-content-between d-flex align-items-end'>
            <h1 className='display-5 m-0'>Lecturas</h1>
          </div>
          <Table bordered hover responsive className='mt-4'>
            <thead>
              <tr>
                <th>ID</th>
                <th>Temperatura</th>
                <th>Humedad</th>
              </tr>
            </thead>
            <tbody>
              {lecturas.map(item => (
                <tr key={item.id}>
                  <td>{item.id}</td>
                  <td>{item.temperatura}</td>
                  <td>{item.humedad}</td>
                </tr>
              ))}
            </tbody>
          </Table>
        </div>
      )}
    </div>
  );
};

export default Lecturas;