import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Layout from './components/Layout';
import Home from './pages/Home';
import Login from './pages/Login';
import Dashboard from './pages/Dashboard';
import Notificaciones from './pages/Notificaciones';
import AddNotificacion from './pages/AddNotificacion';
import Lecturas from './pages/Lecturas';
import PrivateRoute from './components/PrivateRoute';

const App = () => {
  return (
    <Router>
      <Routes>
        <Route
          path='/'
          element={
            <Layout>
              <Home />
            </Layout>
          }
        />
        <Route path='/login' element={<Login />} />
        <Route
          path='/dashboard'
          element={
            <PrivateRoute roles={['admin', 'user']}>
              <Layout>
                <Dashboard />
              </Layout>
            </PrivateRoute>
          }
        />
        <Route
          path='/notificaciones'
          element={
            <PrivateRoute roles={['admin', 'user']}>
              <Layout>
                <Notificaciones />
              </Layout>
            </PrivateRoute>
          }
        />
        <Route
          path='/notificaciones/agregar'
          element={
            <PrivateRoute roles={['admin']}>
              <Layout>
                <AddNotificacion />
              </Layout>
            </PrivateRoute>
          }
        />
        <Route
          path='/lecturas'
          element={
            <PrivateRoute roles={['admin', 'user']}>
              <Layout>
                <Lecturas />
              </Layout>
            </PrivateRoute>
          }
        />
      </Routes>
    </Router>
  );
};

export default App;
