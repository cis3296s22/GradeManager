import {BrowserRouter, BrowserRouter as Router, Route, Routes, Navigate} from 'react-router-dom';
import "../Style/App.css";
import Course from "./Course";
import Signup from "./Signup";
import Login from "./Login";


export default function App(){

  return (
    <BrowserRouter>
        <Routes>
          <Route path ="/" element = {<Login></Login>}/>  
          <Route path="/Signup" element = {<Signup></Signup>}/>
          <Route path="/Home" element = {<Course></Course>}/>
          </Routes>
          
    </BrowserRouter>
  );
}