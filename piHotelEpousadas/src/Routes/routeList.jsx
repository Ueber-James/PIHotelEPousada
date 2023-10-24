/* eslint-disable no-unused-vars */
import { BrowserRouter, Routes, Route } from 'react-router-dom';

import { Home } from '../pages/Home';
import { Detail } from '../pages/Detail';
import { Login } from '../pages/Login';
import { notFound } from '../pages/NotFound/notFound';

export function RouteList() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Detail />}>
          <Route path="/" element={<Detail />} />
          <Route path="/" element={<Home />} />
          <Route path="/" element={<Login />} />
          <Route path="*" element={<notFound />} />
        </Route>
      </Routes>
    </BrowserRouter>
  )
}