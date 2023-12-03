import { useState, useEffect } from 'react';

const Sidebar = () => {
  const [activeItem, setActiveItem] = useState();

  const DASHBOARD_SELECTED = 'dashboard';
  const NOTIFICACIONES_SELECTED = 'notificaciones';
  const LECTURAS_SELECTED = 'lecturas';

  useEffect(() => {
    const storedActiveItem = localStorage.getItem('activeItem');
    if (storedActiveItem) {
      setActiveItem(storedActiveItem);
    }
  }, []);

  const handleItemClick = item => {
    setActiveItem(item);
    localStorage.setItem('activeItem', item);
  };

  return (
    <nav
      id='sidebar'
      className='d-flex flex-column flex-shrink-0 p-3 m-3 rounded bg-light'
      style={{ width: 280 }}
    >
      <a
        href='/dashboard'
        className='container d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none'
        onClick={() => handleItemClick(DASHBOARD_SELECTED)}
      >
        <img
          className='p-1'
          width='60'
          height='60'
          src='/src/assets/greenhouse.svg'
        />
        <span className='p-2 fs-4 text-center'>Monitoreo de Invernadero</span>
      </a>
      <hr></hr>
      <ul className='nav nav-pills flex-column mb-auto'>
        <li className='nav-item'>
          <a
            href='/dashboard'
            className={
              activeItem === DASHBOARD_SELECTED ? 'active nav-link' : 'nav-link'
            }
            onClick={() => handleItemClick(DASHBOARD_SELECTED)}
          >
            Dashboard
          </a>
        </li>
        <li className='nav-item'>
          <a
            href='/notificaciones'
            className={
              activeItem === NOTIFICACIONES_SELECTED
                ? 'active nav-link'
                : 'nav-link'
            }
            onClick={() => handleItemClick(NOTIFICACIONES_SELECTED)}
          >
            Notificaciones
          </a>
        </li>
        <li className='nav-item'>
          <a
            href='/lecturas'
            className={
              activeItem === LECTURAS_SELECTED ? 'active nav-link' : 'nav-link'
            }
            onClick={() => handleItemClick(LECTURAS_SELECTED)}
          >
            Lecturas
          </a>
        </li>
      </ul>
    </nav>
  );
};

export default Sidebar;
