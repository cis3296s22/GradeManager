import React from 'react';
import "../Style/App.css";
import Course from "./Course";
import Profile from "./Profile";
import ProfileComponent from './ProfileComponent'

function App() {
  return (
    <div className="App">
      {/*add router when adding new pages (login/signup)  */}
      <h1>Grade Manager</h1>
      {/* {<Course></Course>} */}
      <Profile></Profile>
    </div>
  );
}

export default App;
