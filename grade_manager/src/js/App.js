import "../Style/App.css";
import Course from "./Course";
import Login from "./Login";

function App() {
  return (
    <div className="App">
      {/*add router when adding new pages (login/signup)  */}
      <h1>Grade Manager</h1>
      {/* {<Course></Course>} */}
      <Login></Login>
    </div>
  );
}

export default App;
