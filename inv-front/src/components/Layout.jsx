import Sidebar from './Sidebar';

const Layout = ({ children }) => {
  return (
    <div className='container-fluid row p-0 m-0 w-100' style={{ height: '100vh'}}>
      <Sidebar className='col' />
      <div className='col p-3'>{children}</div>
    </div>
  );
};

export default Layout;
