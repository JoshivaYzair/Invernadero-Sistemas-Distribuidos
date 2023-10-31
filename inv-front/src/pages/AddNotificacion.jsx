import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Form, Button, Col, Row } from 'react-bootstrap';

const AddNotificacion = () => {
  const navigate = useNavigate();

  const [notificacion, setNotificacion] = useState({
    invernadero: '',
    temMax: '',
    temMin: '',
    humMax: '',
    humMin: '',
  });

  const handleChange = e => {
    const { name, value } = e.target;
    setNotificacion({
      ...notificacion,
      [name]: value,
    });
  };

  const handleSubmit = e => {
    e.preventDefault();

    fetch('http://localhost:8080/notificaciones', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(notificacion),
    })
      .then(response => response.json())
      .then(data => {
        console.log('Notificacion agregada:', data);
        navigate('/notificaciones');
      })
      .catch(error => {
        console.error('Error al agregar la Notificacion:', error);
      });
  };

  return (
    <div className='p-2'>
      <div className='jumbotron jumbotron-fluid d-flex justify-content-between d-flex align-items-end mb-4'>
        <h1 className='display-6 m-0'>Agregar Notificación</h1>
        <Button href='/notificaciones' variant='secondary'>
          <i className='bi bi-arrow-left pe-2'></i>
          Regresar
        </Button>
      </div>
      <Form className='p-4 rounded' onSubmit={handleSubmit}>
        <Row className='mb-3'>
          <Form.Group as={Col} className='mb-3' controlId='invernadero'>
            <Form.Label>Nombre</Form.Label>
            <Form.Select
              required
              type='text'
              name='invernadero'
              value={notificacion.invernadero}
              onChange={handleChange}
            >
              <option>invernadero no.1</option>
              <option>invernadero no.2</option>
              <option>invernadero no.3</option>
              <option>invernadero no.4</option>
            </Form.Select>
          </Form.Group>
        </Row>
        <Row className='mb-3'>
          <Form.Group as={Col} className='mb-3' controlId='temMax'>
            <Form.Label>Temperatura Máxima</Form.Label>
            <Form.Control
              required
              type='text'
              name='temMax'
              value={notificacion.temMax}
              onChange={handleChange}
            />
          </Form.Group>

          <Form.Group as={Col} className='mb-3' controlId='temMin'>
            <Form.Label>Temperatura Mínima</Form.Label>
            <Form.Control
              required
              type='text'
              name='temMin'
              value={notificacion.temMin}
              onChange={handleChange}
            />
          </Form.Group>
        </Row>
        <Row className='mb-3'>
          <Form.Group as={Col} className='mb-3' controlId='humMax'>
            <Form.Label>Humedad Máxima</Form.Label>
            <Form.Control
              required
              type='text'
              name='humMax'
              value={notificacion.humMax}
              onChange={handleChange}
            />
          </Form.Group>

          <Form.Group as={Col} className='mb-3' controlId='humMin'>
            <Form.Label>Humedad Mínima</Form.Label>
            <Form.Control
              required
              type='text'
              name='humMin'
              value={notificacion.humMin}
              onChange={handleChange}
            />
          </Form.Group>
        </Row>
        <div className='d-flex justify-content-center align-items-center'>
          <Button variant='success' type='submit'>
            Guardar
          </Button>
        </div>
      </Form>
    </div>
  );
};

export default AddNotificacion;
