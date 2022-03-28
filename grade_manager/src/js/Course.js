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

  // COLUMN DIV FOR SEMESTER IS TAKING UP TOO MUCH SPACE
  // HAVE TO DIVIDE IT UP ACCORDING TO BOOTSTRAP GRID
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
                  <div>
                    <InputGroup>
                      <InputGroup.Text>Assignment</InputGroup.Text>
                      <FormControl aria-label="Assignment" />
                      {/* group should be a dropdown with the ability to add new groups */}
                      <Dropdown>
                        <Dropdown.Toggle
                          variant="outline-success"
                          id="dropdown-basic"
                        >
                          Group
                        </Dropdown.Toggle>

                        <Dropdown.Menu>
                          <Dropdown.Item href="#/action-1">Quiz</Dropdown.Item>
                          <Dropdown.Item href="#/action-2">
                            Assignments
                          </Dropdown.Item>
                          <Dropdown.Item href="#/action-3">
                            Attendance
                          </Dropdown.Item>
                        </Dropdown.Menu>
                      </Dropdown>
                      {/* ************************************************************ */}
                      <InputGroup.Text>Grade</InputGroup.Text>
                      <FormControl aria-label="Grade" />
                      <Button variant="outline-success" onClick={addAssignment}>
                        {" "}
                        <FaPlus />
                        {" Add Assignment "}
                      </Button>{" "}
                    </InputGroup>
                  </div>
                  <Card.Text></Card.Text>
                </Card.Body>
              </Card>
            </Tab>
            <Tab eventKey="IH" title="Intellectual Heritage">
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
