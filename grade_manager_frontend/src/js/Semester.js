import ListGroup from "react-bootstrap/ListGroup";
import "../Style/Semester.css";
import { useState } from "react";
import { ListGroupItem } from "react-bootstrap";

function Semester() {
  // pull the semesters from the database
  // semesterobject : {
  // course1: {assignment1: {name: "name", grade: 100, group: "quiz"}};

  function addSemesterTab(semester) {
    // automatically increment the semester &
    // SEND TO DATABASE

    setSemesterNames((prevState) => [
      ...prevState,
      "Semester " +
        (Number(semesterNames[semesterNames.length - 1].match(/\d+/g)) + 1),
    ]);

    // if the key is Add New Semester
    // send a new semester to the database
  }

  const [semesterNames, setSemesterNames] = useState([
    "Semester 1",
    "Semester 2",
    "Semester 3",
    "Semester 4",
    "Semester 5",
    "Semester 6",
    "Semester 7",
    "Semester 8",
  ]);

  const listItems = semesterNames.map((semester) => (
    <ListGroup.Item
      action
      eventKey={semester}
      key={semester}
      // onClick display the associated courses
    >
      {semester}
    </ListGroup.Item>
  ));

  return (
    <ListGroup defaultActiveKey="#link1" bsPrefix="SemesterContainer">
      {listItems}
      <ListGroupItem
        action
        eventKey={"Add New Semester"}
        onClick={addSemesterTab}
      >
        Add New Semester
      </ListGroupItem>
    </ListGroup>
  );
}
export default Semester;
