import React, { useState, useEffect } from 'react';
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';

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

  const deleteNotificacion = id => {
    const token = localStorage.getItem('jwtToken');
    
    fetch(`http://localhost:8080/lectura/${id}`, {
      method: 'DELETE',
      headers: {
        'Authorization': `Bearer ${token}`,
        'Content-Type': 'application/json',
      }
    })
      .then(response => {
        if (!response.ok) {
          throw new Error('Error al eliminar la notificación');
        }
        setLecturas(lecturas.filter(item => item.id !== id));
      })
      .catch(error => {
        console.error('Error al eliminar la notificación:', error);
      });
  };

  return (
    <div className='p-2'>
      {loading ? (
        <p>Cargando...</p>
      ) : (
        <div>
          <div className='jumbotron jumbotron-fluid d-flex justify-content-between d-flex align-items-end'>
            <h1 className='display-5 m-0'>Notificaciones</h1>
            <Button href='/notificaciones/agregar' variant='primary'>
              <i className='bi bi-plus-lg pe-2'></i>
              Nueva Notificación
            </Button>
          </div>
          <Table bordered hover responsive className='mt-4'>
            <thead>
              <tr>
                <th>Nombre</th>
                <th>Tem. Maxima</th>
                <th>Tem. Minima</th>
                <th>Hum. Maxima</th>
                <th>Hum. Minima</th>
                <th style={{ textAlign: 'center' }}>Acciones</th>
              </tr>
            </thead>
            <tbody>
              {lecturas.map(item => (
                <tr key={item.id}>
                  <td>{item.invernadero}</td>
                  <td>{item.temMax}</td>
                  <td>{item.temMin}</td>
                  <td>{item.humMax}</td>
                  <td>{item.humMin}</td>
                  <td style={{ textAlign: 'center' }}>
                    <Button
                      title='Eliminar'
                      variant='danger'
                      onClick={() => deleteNotificacion(item.id)}
                    >
                      <i className='bi bi-trash3'></i>
                    </Button>
                  </td>
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