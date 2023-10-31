import { AreaChart } from '../components/AreaChart';
import { PieChart } from '../components/PieChart';
import { ScatterChart } from '../components/ScatterChart';
import { VerticalBarChart } from '../components/VerticalBarChart';

const Dashboard = () => {
  return (
    <div>
      <div className='jumbotron jumbotron-fluid p-2'>
        <h1 className='display-5'>Dashboard</h1>
      </div>
      <div className="container">
      <div className="row">
        <div className="col"><AreaChart /></div>
        <div className="col"><VerticalBarChart /></div>
        <div className="w-100"></div>
        <div className="col"><ScatterChart /></div>
        <div className="col"><PieChart /></div>
      </div>
    </div>
    </div>
  );
};

export default Dashboard;
