import "../Style/App.css";
import Signup from "./Signup";
import Semester from "./Semester";
import Profile from "./Profile";
import Login from "./Login";

function App() {
  return (
    <div className="App">
      {/*add router when adding new pages (login/signup)  */}
      <h1>Grade Manager</h1>
      {/* <Signup></Signup> */}
      {/* {<Login></Login>} */}
      {<Profile></Profile>}
      {<Semester></Semester>}
    </div>
  );
}

export default App;
