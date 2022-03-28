import ListGroup from "react-bootstrap/ListGroup";
import "../Style/Semester.css";

function Semester() {
  function addSemesterTab(key) {
    if (key === "addNewSemester") {
      console.log("add new semester tab");
    } else {
      console.log("just clicking through the semester tabs");
    }
  }

  //   .list-group{
  //     max-height: 300px;
  //     margin-bottom: 10px;
  //     overflow:scroll;
  //     -webkit-overflow-scrolling: touch;
  // }
  function alertClicked() {
    alert("You clicked the third ListGroupItem");
  }
  // style={{ width: "35rem", color: "black" }}
  return (
    <ListGroup
      defaultActiveKey="#link1"
      // style={{ maxHeight: "300px" }}
      bsPrefix="SemesterContainer"
    >
      <ListGroup.Item action href="#link1">
        Semester 1
      </ListGroup.Item>
      <ListGroup.Item action href="#link2">
        Semester 2
      </ListGroup.Item>
      <ListGroup.Item action href="#link3">
        Semester 3
      </ListGroup.Item>
      <ListGroup.Item action href="#link4">
        Semester 4
      </ListGroup.Item>
      <ListGroup.Item action href="#link5">
        Semester 5
      </ListGroup.Item>
      <ListGroup.Item action href="#link6">
        Semester 6
      </ListGroup.Item>
      <ListGroup.Item action href="#link7">
        Semester 7
      </ListGroup.Item>
      <ListGroup.Item action onClick={alertClicked}>
        Add Semester
      </ListGroup.Item>
    </ListGroup>
  );
}
export default Semester;
