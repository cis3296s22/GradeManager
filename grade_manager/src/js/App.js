import "../Style/App.css";
import Semester from "./Semester";
import Course from "./Course";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <div className="helloWorld">
          {/*<Course></Course>*/}
          <Semester></Semester>

          {/* add names here to make sure that you can push to github and make a pull from helloWorld to main */}
        </div>
      </header>
    </div>
  );
}

export default App;
