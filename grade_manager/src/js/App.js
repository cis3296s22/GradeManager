import "../Style/App.css";
import Course from "./Course";

function App() {
  return (
    <div className="App">
      {/*add router when adding new pages (login/signup)  */}
      <h1>Grade Manager</h1>
      {<Course></Course>}
    </div>
  );
}

export default App;
