import {
  Link, Route, Routes
} from 'react-router-dom';
import "../Style/App.css";
import Course from "./Course";
import Signup from "./Signup";
import Login from "./Login";
import { BrowserRouter } from 'react-router-dom';

export default function App(){

  return (
    <BrowserRouter>
        {<Login></Login>}
        <div className = "App">
          <nav>
          <ul>
            <li>
            <Link to = "/Signup" target = {"_blank"}>Signup</Link>
            </li>
          </ul>
          </nav>
          <switch>
          <Routes>
          <Route path="/Signup" element = {<Signup></Signup>}/>
          </Routes>
          </switch>
          </div>
    
    </BrowserRouter>
  );
}

