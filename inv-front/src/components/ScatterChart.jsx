import React from 'react';
import {
  Chart as ChartJS,
  LinearScale,
  PointElement,
  LineElement,
  Tooltip,
  Legend,
} from 'chart.js';
import { Scatter } from 'react-chartjs-2';

ChartJS.register(LinearScale, PointElement, LineElement, Tooltip, Legend);

export const options = {
  scales: {
    y: {
      beginAtZero: true,
    },
  },
};

export const data = {
  datasets: [
    {
      label: 'A dataset',
      data: Array.from({ length: 100 }, () => ({
        x: () => {[56, 78, 56, 46, 67, 43, 23]},
        y: () => {[68, 85, 35, 97, 23, 67, 34]},
      })),
      backgroundColor: 'rgba(255, 99, 132, 1)',
    },
  ],
};

export function ScatterChart() {
  return <Scatter options={options} data={data} />;
}
