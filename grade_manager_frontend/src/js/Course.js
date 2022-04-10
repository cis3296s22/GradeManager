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

  // const [newAssignment, setNewAssignment] = useState({
  //   name: null,
  //   grade: null,
  //   group: null,
  //   container: null,
  // });

  // const addAssignmentDiv = (
  //   <Row>
  //     <InputGroup>
  //       <InputGroup.Text>Assignment</InputGroup.Text>
  //       <FormControl
  //         aria-label="Assignment"
  //         onChange={(e) =>
  //           setNewAssignment((prevState) => ({
  //             ...prevState,
  //             name: e.target.value,
  //           }))
  //         }
  //       />
  //       {/* group should be a dropdown with the ability to add new groups */}
  //       <Dropdown onSelect={(e) => chooseAssignmentGroup(e)}>
  //         <Dropdown.Toggle variant="outline-success" id="dropdown-basic">
  //           Group
  //         </Dropdown.Toggle>

  //         <Dropdown.Menu>
  //           <Dropdown.Item eventKey={"Quiz"}>Quiz</Dropdown.Item>
  //           <Dropdown.Item eventKey={"Assignment"}>Assignment</Dropdown.Item>
  //           <Dropdown.Item eventKey={"Attendance"}>Attendance</Dropdown.Item>
  //         </Dropdown.Menu>
  //       </Dropdown>
  //       <InputGroup.Text>Grade</InputGroup.Text>
  //       <FormControl
  //         aria-label="Grade"
  //         onChange={(e) =>
  //           setNewAssignment((prevState) => ({
  //             ...prevState,
  //             grade: e.target.value,
  //           }))
  //         }
  //       />
  //       <Button variant="outline-success" onClick={addAssignment}>
  //         <FaPlus />
  //         {" Add Assignment "}
  //       </Button>{" "}
  //     </InputGroup>
  //   </Row>
  // );

  // // addAssignmentDiv has all the calls to the function addAssignment
  // // add Assignment creates a div and attaches it to the useState for the assignment variable
  // // the variable is waiting to be displayed within the return newAssignment.container
  // function addAssignment() {
  //   // CURRENT: taking input from user and storing in newAssignment
  //   // not displaying the new assignmnet
  //   // press the +newAssignment button to send the newAssignmet to the database
  //   // also adds to the newAssignment variable on change

  //   // SEND TO DATABASE FROM HERE

  //   // make this look better later
  //   console.log("add assignment");
  //   console.log(newAssignment);

  //   const newAssignmentDiv = (
  //     <Row>
  //       <Col>{newAssignment.name}</Col>
  //       <Col>{newAssignment.group}</Col>
  //       <Col>{newAssignment.grade}</Col>
  //     </Row>
  //   );

  //   setNewAssignment((prevState) => ({
  //     ...prevState,
  //     container: newAssignmentDiv,
  //   }));
  // }
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
          {/* I think all I gotta do is call the assignmnet function from here and do conditional rendering */}
          {/* <Assignment newAssignment={true}/> */}
          {/* <Assignment ifNewAssignmentContainer={true} /> */}
          <Assignment ifAddAssignmentDiv={true} />

          {/* <Assignment add Assignm */}
          {/* {newAssignment.container} */}
          {/* {addAssignmentDiv} */}
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

  // function chooseAssignmentGroup(e) {
  //   // setNewAssignment((prevState) => { group: e });
  //   setNewAssignment((prevState) => ({
  //     ...prevState,
  //     group: e,
  //   }));

  //   // console.log("clicking through dropdown");
  //   // console.log(e);
  //   console.log(newAssignment);
  // }

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

// Course card would take input from the user to enter assignments
// types of assignments should be added by the user

// https://react-bootstrap.github.io/components/tabs/
