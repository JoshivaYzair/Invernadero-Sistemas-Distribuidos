import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Layout from './components/Layout';
import Home from './pages/Home';
import Login from './pages/Login';
import Dashboard from './pages/Dashboard';
import Notificaciones from './pages/Notificaciones';
import AddNotificacion from './pages/AddNotificacion';

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
        <Route
          path='/login'
          element={ <Login /> }
        />
        <Route
          path='/dashboard'
          element={
            <Layout>
              <Dashboard />
            </Layout>
          }
        />
        <Route
          path='/notificaciones'
          element={
            <Layout>
              <Notificaciones />
            </Layout>
          }
        />
        <Route
          path='/notificaciones/agregar'
          element={
            <Layout>
              <AddNotificacion />
            </Layout>
          }
        />
      </Routes>
    </Router>
  );
};

export default App;
