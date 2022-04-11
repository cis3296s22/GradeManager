import "../Style/App.css";
import Signup from "./Signup";
import Semester from "./Semester";

function App() {
  return (
    <div className="App">
      {/*add router when adding new pages (login/signup)  */}
      <h1>Grade Manager</h1>
      {/* <Signup></Signup> */}
      {<Semester></Semester>}
    </div>
  );
}

export default App;
