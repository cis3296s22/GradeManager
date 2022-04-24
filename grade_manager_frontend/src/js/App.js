import "../Style/App.css";
import Signup from "./Signup";
import Semester from "./Semester";
import Profile from "./Profile";
import Login from "./Login";
import { useEffect, useState } from "react";

function App() {
  const [profileInfo, setProfileInfo] = useState({});
  const [semesterList, setSemesterList] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      const studentId = encodeURIComponent("6444407856832004412");
      const URL =
        `http://localhost:8086/api/v1/Student/getStudent?studentId=` +
        studentId;
      const data = await fetch(
        URL,

        {
          // mode: "no-cors", //stack over flow says that's a server issue (remove this line?)
          method: "GET",
          headers: {
            Accept: "application/json",
            AccessControlAllowOrigin: "*",
          },
        }
      ); //replace URL here with student
      if (data.ok) {
        const json = await data.json();
        setProfileInfo(json);            
        setSemesterList(json.semesterList);
      }
    };
    fetchData();
  }, []);
  // setSemesterList(profileInfo.)
  console.log(semesterList);
  return (
    <div className="App">
      {/*add router when adding new pages (login/signup)  */}
      {/* <h1>Grade Manager</h1> */}
      {/* <Signup></Signup> */}
      {/* {<Login></Login>} */}
      {<Profile student={profileInfo}></Profile>}
      {<Semester semesterList={semesterList}></Semester>}
    </div>
  );
}

export default App;
