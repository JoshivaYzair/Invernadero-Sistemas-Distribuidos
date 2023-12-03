import { jwtDecode } from "jwt-decode";
import { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

const Login = () => {
  const [user, setUser] = useState(null);
  const [userData, setUserData] = useState({
    email: '',
    password: ''
  });

  useEffect(() => {
    const storedToken = localStorage.getItem('jwtToken');

    if (storedToken) {
      const decodedUser = decodeToken(storedToken);
      setUser(decodedUser);
    }
  }, []);

  const handleChange = e => {
    const { name, value } = e.target;
    setUserData({
      ...userData,
      [name]: value,
    });
  };

  const handleLogin = async e => {
    e.preventDefault();

    console.log(userData);

    try {
      const response = fetch('http://localhost:8060/auth/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(userData),
      })

      console.log(response)
      const token = response.body.token;
      console.log(token);
      if (token) {
        const decodedToken = jwtDecode(token);
        console.log(decodedToken);
        /*
        const id = decodedToken.usuario.id;
        const rol = decodedToken.usuario.rol;

        // Almacenar el ID y el rol del usuario en el almacenamiento local
        localStorage.setItem('id', id);
        localStorage.setItem('rol', rol);

        // Almacenar el token en el almacenamiento local (puedes usar cookies también)
        localStorage.setItem('token', token);

        // Redirigir al usuario a la ruta "/"
        $router.push('/');
        */
      } else {
        console.error('No se obtuvo un token en la respuesta del servidor:', error);
      }
    } catch (error) {
      console.error('Error al autenticar:', error);
    }
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
