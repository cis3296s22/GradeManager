import Tabs from "react-bootstrap/Tabs";
import Tab from "react-bootstrap/Tab";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import { FaPlus } from "react-icons/fa";
import InputGroup from "react-bootstrap/InputGroup";
import FormControl from "react-bootstrap/FormControl";
import { useState } from "react";
import Container from "react-bootstrap/Container";
import Semester from "./Semester";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";

import Assignment from "./Assignment";

// import "../Style/Course.css";

function Course() {
  const styles = {
    grid: {
      paddingLeft: 0,
      paddingRight: 0,
      position: "absolute", //change this later
      top: "10rem",
      left: "10rem",
      width: "75%",
    },
    row: {
      marginLeft: 0,
      marginRight: 0,
      //  the rows is already taking up the whole height, need the ListGroup Items to expand/shrink
      // in response to the available size
    },
    col: {
      paddingLeft: 0,
      paddingRight: 0,
    },
  };

  const [courseNames, setCourseNames] = useState([
    "Software Design",
    "Intellectual Heritage",
    "Calculus I",
  ]);

  const CourseTabs = courseNames.map((eachCourseName) => (
    <Tab eventKey={eachCourseName} title={eachCourseName} key={eachCourseName}>
      <Card border="primary">
        <Card.Header>{eachCourseName}</Card.Header>
        <Card.Body>
          <Assignment ifAddAssignmentDiv={true} />
        </Card.Body>
      </Card>
    </Tab>
  ));

  const [newCourse, setNewCourse] = useState({
    CourseName: null,
    container: null,
  });

  function applyNewCourse(e) {
    setCourseNames((prevState) => [...prevState, newCourse.CourseName]);

    // SEND TO DATABASE HERE
  }
  const addCourseDiv = (
    <Tab eventKey={"newCourse"} title={"New Course"}>
      <Card border="primary">
        <Card.Header>{newCourse.CourseName}</Card.Header>
        <Card.Body>
          <InputGroup className="mb-3">
            <InputGroup.Text id="basic-addon1">
              Enter Course Name
            </InputGroup.Text>
            <FormControl
              aria-label="newCourseName"
              aria-describedby="basic-addon1"
              onChange={(e) =>
                setNewCourse({
                  CourseName: e.target.value,
                })
              }
            />

            <Button variant="outline-success" onClick={applyNewCourse}>
              <FaPlus />
              {"Add Course"}
            </Button>
          </InputGroup>
        </Card.Body>
      </Card>
    </Tab>
  );

  return (
    <Container style={styles.grid}>
      <Row style={styles.row}>
        <Col sm={3} style={styles.col}>
          <Semester />
        </Col>
        <Col style={styles.col}>
          <Tabs
            defaultActiveKey="profile"
            id="uncontrolled-tab-example"
            className="mb-3"
            // onSelect={addCourseTab}
          >
            {/* map through the all the courses being returned from the database and render*/}
            {CourseTabs}

            {addCourseDiv}
          </Tabs>
        </Col>
      </Row>
    </Container>
  );
}

export default Course;
