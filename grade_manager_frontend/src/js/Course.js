import Tabs from "react-bootstrap/Tabs";
import Tab from "react-bootstrap/Tab";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import { FaPlus } from "react-icons/fa";
import InputGroup from "react-bootstrap/InputGroup";
import FormControl from "react-bootstrap/FormControl";
import Dropdown from "react-bootstrap/Dropdown";
import { useState } from "react";
import Container from "react-bootstrap/Container";
import Semester from "./Semester";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";

// import "../Style/Course.css";
{
  /* stored as a variable and added to the mapping?
 display course card that takes in input values to send data*/
}

{
  /* display course card pulled from backend */
}

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

  // function addCourseTab(key) {
  //   if (key === "addNewCourse") {
  //     console.log("add new course tab");
  //   } else {
  //     console.log("just clicking through the course tabs");
  //   }
  // }

  // addAssignmentDiv has all the calls to the function addAssignment
  // add Assignment creates a div and attaches it to the useState for the assignment variable
  // the variable is waiting to be displayed within the return newAssignment.container
  function addAssignment() {
    // CURRENT: taking input from user and storing in newAssignment
    // not displaying the new assignmnet
    // press the +newAssignment button to send the newAssignmet to the database
    // also adds to the newAssignment variable on change

    // SEND TO DATABASE FROM HERE

    // make this look better later
    console.log("add assignment");
    console.log(newAssignment);

    const newAssignmentDiv = (
      <Row>
        <Col>{newAssignment.name}</Col>
        <Col>{newAssignment.group}</Col>
        <Col>{newAssignment.grade}</Col>
      </Row>
    );

    setNewAssignment((prevState) => ({
      ...prevState,
      container: newAssignmentDiv,
    }));
  }

  const [newCourse, setNewCourse] = useState({
    CourseName: null,
    container: null,
  });

  function applyNewCourse(e) {
    const newCourseDiv = (
      <Tab eventKey={newCourse.CourseName} title={newCourse.CourseName}>
        <Card border="primary">
          <Card.Header>{newCourse.CourseName}</Card.Header>
          <Card.Body>{addAssignmentDiv}</Card.Body>
        </Card>
      </Tab>
    );
    setNewCourse((prevState) => ({
      ...prevState,
      container: newCourseDiv,
    }));

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

          {/* {newAssignment.container} */}
          {/* {addAssignmentDiv} */}
          {/* <Card.Text></Card.Text> */}
        </Card.Body>
      </Card>
    </Tab>
  );

  const [newAssignment, setNewAssignment] = useState({
    name: null,
    grade: null,
    group: null,
    container: null,
  });

  function chooseAssignmentGroup(e) {
    // setNewAssignment((prevState) => { group: e });
    setNewAssignment((prevState) => ({
      ...prevState,
      group: e,
    }));

    // console.log("clicking through dropdown");
    // console.log(e);
    console.log(newAssignment);
  }

  const addAssignmentDiv = (
    <Row>
      <InputGroup>
        <InputGroup.Text>Assignment</InputGroup.Text>
        <FormControl
          aria-label="Assignment"
          onChange={(e) =>
            setNewAssignment((prevState) => ({
              ...prevState,
              name: e.target.value,
            }))
          }
        />
        {/* group should be a dropdown with the ability to add new groups */}
        <Dropdown onSelect={(e) => chooseAssignmentGroup(e)}>
          <Dropdown.Toggle variant="outline-success" id="dropdown-basic">
            Group
          </Dropdown.Toggle>

          <Dropdown.Menu>
            <Dropdown.Item eventKey={"Quiz"}>Quiz</Dropdown.Item>
            <Dropdown.Item eventKey={"Assignment"}>Assignment</Dropdown.Item>
            <Dropdown.Item eventKey={"Attendance"}>Attendance</Dropdown.Item>
          </Dropdown.Menu>
        </Dropdown>
        <InputGroup.Text>Grade</InputGroup.Text>
        <FormControl
          aria-label="Grade"
          onChange={(e) =>
            setNewAssignment((prevState) => ({
              ...prevState,
              grade: e.target.value,
            }))
          }
        />
        <Button variant="outline-success" onClick={addAssignment}>
          <FaPlus />
          {" Add Assignment "}
        </Button>{" "}
      </InputGroup>
    </Row>
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
            <Tab eventKey="SoftwareDesign" title="Software Design">
              <Card border="primary">
                <Card.Header>Software Design</Card.Header>
                <Card.Body>
                  {/* use useEffect instead?????? */}
                  {newAssignment.container}
                  {addAssignmentDiv}
                  {/* <Card.Text></Card.Text> */}
                </Card.Body>
              </Card>
            </Tab>

            <Tab eventKey="IH" title="Intellectual Heritage">
              <Card border="primary" style={{ width: "35rem", color: "black" }}>
                <Card.Header>Intellectual Heritage</Card.Header>
                <Card.Body>{addAssignmentDiv}</Card.Body>
              </Card>
            </Tab>

            {/* map through the all the courses being returned from the database and render*/}
            {/*  */}
            {addCourseDiv}
          </Tabs>
        </Col>
      </Row>
    </Container>
  );
}

export default Course;

// Course card would take input from the user to enter assignments
// types of assignments should be added by the user

// https://react-bootstrap.github.io/components/tabs/
