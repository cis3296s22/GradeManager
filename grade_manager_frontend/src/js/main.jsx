import { render } from "react-router-dom";
import {
  BrowserRouter,
  Routes,
  Route,
} from "react-router-dom";
import App from "./App";
import Login from "./Login";
import Signup from "./Signup";

const rootElement = document.getElementById("root");
render(
  <BrowserRouter>
    <Routes>
      <Route path="/login" element={<Signup></Signup>} />
    </Routes>
  </BrowserRouter>,
  rootElement
);