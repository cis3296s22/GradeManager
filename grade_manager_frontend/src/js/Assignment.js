import { FaPlus } from "react-icons/fa";
import Button from "react-bootstrap/Button";
import FormControl from "react-bootstrap/FormControl";
import Dropdown from "react-bootstrap/Dropdown";
import InputGroup from "react-bootstrap/InputGroup";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import { useState } from "react";
function Assignment(props) {
  const ifAddAssignmentDiv = props.ifAddAssignmentDiv;
  const ifNewAssignmentContainer = props.ifNewAssignmentContainer;

  const [newAssignment, setNewAssignment] = useState({
    name: null,
    grade: null,
    group: null,
    container: null,
  });

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
  return (
    <div>
      {newAssignment.container}
      {ifAddAssignmentDiv && addAssignmentDiv}
    </div>
  );
}
export default Assignment;

// todo
// when user clicks +add Assignment button
// grab inputGroup Text and store it in newAssignment
// consider not accepting until all user input is entered
// using validation
