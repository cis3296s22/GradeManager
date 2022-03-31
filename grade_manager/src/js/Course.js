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
      // marginLeft: 0,
      // marginRight: 0,
    },
  };
  // const newAssignment =
  function addCourseTab(key) {
    if (key === "addNewCourse") {
      console.log("add new course tab");
    } else {
      console.log("just clicking through the course tabs");
    }
  }
  function addAssignment() {
    //   fill in

    console.log("add assignment");
    console.log(newAssignment);
  }

  // ********************************************************
  //   NOT WORKING on dropdown below
  const [show, setShow] = useState(true);

  const showDropdown = () => {
    console.log(show);
    setShow(true);
  };
  const hideDropdown = () => {
    console.log(show);
    setShow(false);
  };

  // ********************************************************

  const [newAssignment, setNewAssignment] = useState({
    name: null,
    grade: null,
    group: null,
  });

  function chooseAssignmentGroup(e) {
    // setNewAssignment((prevState) => { group: e });
    setNewAssignment((prevState) => ({
      ...prevState,
      group: e,
    }));

    console.log("clicking through dropdown");
    console.log(e);
    console.log(newAssignment);
  }

  const addAssignmentDiv = (
    <div>
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
        {/* ************************************************************ */}
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
    </div>
  );

  const placeHolderAssignment = (
    <div>
      <p>
        <span>Assignment Name</span> <span>Quiz</span>
        <span> 89</span>
      </p>
    </div>
  );

  return (
    <Container style={styles.grid}>
      <Row style={styles.row}>
        <Col sm={3} style={styles.col}>
          {/* {<Semester></Semester>} */}
          <Semester />
        </Col>
        <Col style={styles.col}>
          <Tabs
            defaultActiveKey="profile"
            id="uncontrolled-tab-example"
            className="mb-3"
            onSelect={addCourseTab}
          >
            <Tab eventKey="SoftwareDesign" title="Software Design">
              <Card border="primary">
                <Card.Header>Grades</Card.Header>
                <Card.Body>
                  {/* put everything in this div into a variable and add to all courses dynamically */}
                  {placeHolderAssignment}
                  {addAssignmentDiv}
                  {/* <Card.Text></Card.Text> */}
                </Card.Body>
              </Card>
            </Tab>
            <Tab eventKey="IH" title="Intellectual Heritage">
              <Card border="primary" style={{ width: "35rem", color: "black" }}>
                <Card.Header>Grades</Card.Header>
                <Card.Body>{addAssignmentDiv}</Card.Body>
              </Card>
            </Tab>

            <Tab eventKey="addNewCourse" title="Add Course">
              <Card border="primary" style={{ width: "35rem", color: "black" }}>
                <Card.Header>Grades</Card.Header>
                <Card.Body>
                  <Card.Title>Primary Card Title</Card.Title>
                  <Card.Text>
                    Some quick example text to build on the card title and make
                    up the bulk of the card's content.
                  </Card.Text>
                </Card.Body>
              </Card>
            </Tab>
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
