import ListGroup from "react-bootstrap/ListGroup";
import semStyles from "../Style/Semester.css";

function Semester() {
  function addSemesterTab(key) {
    if (key === "addNewSemester") {
      console.log("add new semester tab");
    } else {
      console.log("just clicking through the semester tabs");
    }
  }

  function alertClicked() {
    alert("You clicked the third ListGroupItem");
  }
  // style={{ width: "35rem", color: "black" }}
  return (
    <ListGroup defaultActiveKey="#link1" style={{ height: "100%" }}>
      <ListGroup.Item action href="#link1">
        Semester 1
      </ListGroup.Item>
      <ListGroup.Item action href="#link2" disabled>
        Semester 2
      </ListGroup.Item>
      <ListGroup.Item action onClick={alertClicked}>
        Add Semester
      </ListGroup.Item>
    </ListGroup>
  );
}
export default Semester;
