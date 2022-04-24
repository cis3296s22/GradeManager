import ListGroup from "react-bootstrap/ListGroup";
import "../Style/Semester.css";
import { useState } from "react";
import { ListGroupItem } from "react-bootstrap";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import Container from "react-bootstrap/Container";

import Course from "./Course";

function Semester(semesterList) {
  const styles = {
    grid: {
      paddingLeft: 0,
      paddingRight: 0,
      position: "absolute", //change this later
      marginTop: "5rem",
      top: "10rem",
      left: "10rem",
      width: "75%",
    },
    row: {
      marginLeft: 0,
      marginRight: 0,
    },
    col: {
      paddingLeft: 0,
      paddingRight: 0,
    },
  };
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
  // const [semesters, setSemesters] = useState([]);

  console.log(semesterList);

  const [semesterCourses, setsemesterCourses] = useState([]);
  // console.log(semesterCourses);
  const listItems = semesterList.semesterList.map((semester, index) => (
    <ListGroup.Item
      action
      eventKey={semester.number}
      key={semester.number}
      onClick={() => setsemesterCourses(semester.courseList)}
      // onClick display the associated courses
    >
      {semester.name}
    </ListGroup.Item>
  ));

  return (
    <Container style={styles.grid}>
      <Row style={styles.row}>
        <Col sm={3} style={styles.col}>
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
        </Col>
        <Col style={styles.col}>
          {<Course courses={semesterCourses}></Course>}
        </Col>
      </Row>
    </Container>
  );
}
export default Semester;
