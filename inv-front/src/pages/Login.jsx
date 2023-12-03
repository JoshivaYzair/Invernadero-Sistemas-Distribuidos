import { jwtDecode } from 'jwt-decode';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const Login = () => {

  const navigate = useNavigate();

  const [userData, setUserData] = useState({
    email: '',
    password: '',
  });

  const handleChange = e => {
    const { name, value } = e.target;
    setUserData({
      ...userData,
      [name]: value,
    });
  };

  const handleLogin = async e => {
    e.preventDefault();

    fetch('http://localhost:8060/auth/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(userData),
    })
      .then(response => {

        if (!response.ok) {
          throw new Error(
            'No se obtuvo un token en la respuesta del servidor.'
          );
        }

        return response.json();
      })
      .then(data => {

        if (data.token) {
          const decodedToken = jwtDecode(data.token);
   
          const id = decodedToken.id;
          const rol = decodedToken.rol;

          localStorage.setItem('id', id);
          localStorage.setItem('rol', rol);
          localStorage.setItem('jwtToken', data.token);

          navigate('/');
        }
      })
      .catch(error => {
        console.error('Error al autenticar:', error);
      });
  };

  return (
    <div className='container'>
      <div className='row justify-content-center'>
        <div className='col-md-6'>
          <div className='card mt-5'>
            <div className='card-header'>
              <h3 className='text-center'>Login</h3>
            </div>
            <div className='card-body'>
              <form>
                <div className='mb-3'>
                  <label htmlFor='username' className='form-label'>
                    Nombre de usuario
                  </label>
                  <input
                    type='text'
                    className='form-control'
                    name='email'
                    value={userData.email}
                    onChange={handleChange}
                  />
                </div>
                <div className='mb-3'>
                  <label htmlFor='password' className='form-label'>
                    Contraseña
                  </label>
                  <input
                    type='password'
                    className='form-control'
                    name='password'
                    value={userData.password}
                    onChange={handleChange}
                  />
                </div>
                <div className='text-center'>
                  <button
                    type='button'
                    className='btn btn-primary'
                    onClick={handleLogin}
                  >
                    Login
                  </button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Login;
