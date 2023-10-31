const Home = () => {
  return (
    <div className='jumbotron p-2'>
      <h1 className='display-4'>¡Bienvenido!</h1>
      <p className='lead'>
        En este sistema de monitoreo puedes interactuar con todos los datos en tiempo real que genera el invernadero.
      </p>
      <hr className='my-4' />
      <p>
        Puedes empezar llendo al reporte general de los datos que se encuentran en el dashboard.
      </p>
      <p className='lead'>
        <a className='btn btn-primary btn-lg'  href='/dashboard' role='button'>
          Ir al dashboard
        </a>
      </p>
    </div>
  );
};

export default Home;
