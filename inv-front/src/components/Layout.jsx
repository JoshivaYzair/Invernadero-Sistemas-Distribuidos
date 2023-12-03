import Sidebar from './Sidebar';
import { useNavigate } from 'react-router-dom';

const Layout = ({ children }) => {

  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem('id');
    localStorage.removeItem('rol');
    localStorage.removeItem('jwtToken');
    navigate('/login');
  };

  return (
    <div className='container-fluid row p-0 m-0 w-100' style={{ height: '100vh'}}>
      <Sidebar className='col' />
      <div className='col p-3'>{children}</div>
      <button
        className='btn btn-danger mt-auto'
        onClick={handleLogout}
        style={{ position: 'fixed', bottom: '5px', left: '5px', width: 280,
        margin: '0', padding: '5px 3px'}}
      >
        Cerrar Sesión
      </button>
    </div>
  );
};

export default Layout;
