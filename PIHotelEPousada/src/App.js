import React from 'react';
import Header from './components/Header';
import Footer from './components/Footer';
import Login from './pages/login/Login';
import Singup from './pages/singup/Sign';
import Reservation from './components/reservation';
import AdminPage from './pages/admin/AdminPage';
import MyReservations from './pages/myReservations/MyReservations';




import Home from './pages/Home';
import RoomDetails from './pages/RoomDetails';


// router
import {

  createBrowserRouter, RouterProvider
} from "react-router-dom";


const router = createBrowserRouter([
  {
    path: '/',
    element: <Home />
  },
  {
    path: '/room/:id',
    element: <RoomDetails />
  },

  {
    path: '/login',
    element: <Login />
  },
  {
    path: '/singup',
    element: <Singup />
  },
  {
    path: '/reservation/:id',
    element: <Reservation />
  },
  {
    path: '/adm',
    element: <AdminPage />,
  },
  {
    path: '/my-reservations',
    element: <MyReservations />
  }
  
]);

const App = () => {
  return (<div>
    <Header />
    <RouterProvider router={router} />
    <Footer />
  </div>
  );
};

export default App;
