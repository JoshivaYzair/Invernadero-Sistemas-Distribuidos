import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Layout from './components/Layout';
import Home from './pages/Home';
import Dashboard from './pages/Dashboard';
import Notificaciones from './pages/Notificaciones';

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
      </Routes>
    </Router>
  );
};

export default App;
