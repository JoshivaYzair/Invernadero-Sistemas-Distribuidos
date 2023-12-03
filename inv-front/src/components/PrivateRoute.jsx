import { Navigate } from 'react-router-dom';

const PrivateRoute = ({ children, roles }) => {
  const isAuthenticated = !!localStorage.getItem('jwtToken');
  const userRole = localStorage.getItem('rol');

  return isAuthenticated && roles.includes(userRole) ? (
    <>{children}</>
  ) : (
    <Navigate to="/login" />
  );
};

export default PrivateRoute;