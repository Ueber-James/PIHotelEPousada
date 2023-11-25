import React from 'react';
import Header from './components/Header';
import Footer from './components/Footer';
import Login from './pages/login/Login';
import Singup from './pages/singup/Sign';
// pages

import Home from './pages/Home';
import RoomDetails from './pages/RoomDetails';


// router
import {

  createBrowserRouter, RouterProvider
} from "react-router-dom";


const router =  createBrowserRouter ([
  {
    path: '/',
    element:  <Home />
  },
  {
    path: '/room/:id',
    element:  <RoomDetails />
  },

  {
    path: '/login',
    element:  <Login />
  },
  {
    path: '/singup',
    element:  <Singup />
  }
]);

const App = () => {
  return( <div>
    <Header />
    <RouterProvider router={router} />
    <Footer />
  </div>
  );
};

export default App;
