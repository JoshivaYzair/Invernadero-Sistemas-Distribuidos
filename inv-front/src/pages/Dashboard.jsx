import { AreaChart } from '../components/AreaChart';

const Dashboard = () => {

  const invernadero1 = {
    labels: ['Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado', 'Domingo'],
    datasets: [
      {
        fill: true,
        label: 'Invernadero 1',
        data: [30, 34, 46, 47, 33, 40, 39, 50, 15, 1],
        borderColor: 'rgb(53, 162, 235)',
        backgroundColor: 'rgba(53, 162, 235, 0.5)',
      },
    ],
  };

  const invernadero2 = {
    labels: ['Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado', 'Domingo'],
    datasets: [
      {
        fill: true,
        label: 'Invernadero 2',
        data: [41, 5, 22, 26, 17, 25, 42, 49, 48, 31],
        borderColor: 'rgb(255, 0, 0)',
        backgroundColor: 'rgb(255, 127, 127, 0.5)',
      },
    ],
  };

  const invernadero3 = {
    labels: ['Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado', 'Domingo'],
    datasets: [
      {
        fill: true,
        label: 'Invernadero 3',
        data: [6, 12, 14, 35, 28, 36, 20, 47, 21, 2],
        borderColor: 'rgb(34, 139, 34)',
        backgroundColor: 'rgba(144, 238, 144, 0.5)',
      },
    ],
  };

  const invernadero4 = {
    labels: ['Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado', 'Domingo'],
    datasets: [
      {
        fill: true,
        label: 'Invernadero 4',
        data: [16, 41, 2, 31, 48, 30, 25, 24, 11, 14],
        borderColor: 'rgb(128, 0, 128)',
        backgroundColor: 'rgba(203, 195, 227, 0.5)',
      },
    ],
  };

  return (
    <div>
      <div className='jumbotron jumbotron-fluid p-2'>
        <h1 className='display-5'>Dashboard</h1>
      </div>
      <div className="container">
      <div className="row">
        <div className="col"><AreaChart data={invernadero1} /></div>
        <div className="col"><AreaChart data={invernadero2} /></div>
        <div className="w-100"></div>
        <div className="col"><AreaChart data={invernadero3} /></div>
        <div className="col"><AreaChart data={invernadero4} /></div>
      </div>
    </div>
    </div>
  );
};

export default Dashboard;
