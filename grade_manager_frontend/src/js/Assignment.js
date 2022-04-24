import { FaPlus } from "react-icons/fa";
import Button from "react-bootstrap/Button";
import FormControl from "react-bootstrap/FormControl";
import Dropdown from "react-bootstrap/Dropdown";
import InputGroup from "react-bootstrap/InputGroup";
import Row from "react-bootstrap/Row";
import ListGroup from "react-bootstrap/ListGroup";
import { useState } from "react";
function Assignment(props) {
  const ifAddAssignmentDiv = props.ifAddAssignmentDiv;
  const assignmentList = props.assignmentList;

  // const [allAssignments, setallAssignments] = useState([]);
  const allAssignments = assignmentList.map((eachAssignment) => (
    <ListGroup horizontal style={{ width: "100%" }}>
      <ListGroup.Item style={{ width: "33.33%" }}>
        {eachAssignment.name}
      </ListGroup.Item>
      <ListGroup.Item style={{ width: "33.33%" }}>Assignment</ListGroup.Item>
      <ListGroup.Item style={{ width: "33.33%" }}>
        {eachAssignment.grade}
      </ListGroup.Item>
    </ListGroup>
  ));

  const [newAssignment, setNewAssignment] = useState({
    name: null,
    grade: null,
    group: null,
    container: null,
  });

  const [group, setGroup] = useState("Group");
  function chooseAssignmentGroup(e) {
    setGroup(e);

    setNewAssignment((prevState) => ({
      ...prevState,
      group: e,
    }));
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
            {group}
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
      // could use listGroup & ListGroup.Item
      <ListGroup horizontal style={{ width: "100%" }}>
        <ListGroup.Item style={{ width: "33.33%" }}>
          {newAssignment.name}
        </ListGroup.Item>
        <ListGroup.Item style={{ width: "33.33%" }}>
          {newAssignment.group}
        </ListGroup.Item>
        <ListGroup.Item style={{ width: "33.33%" }}>
          {newAssignment.grade}
        </ListGroup.Item>
      </ListGroup>
    );

    setNewAssignment((prevState) => ({
      ...prevState,
      container: newAssignmentDiv,
    }));
  }

  return (
    <div style={{ maxWidth: "100%" }}>
      {allAssignments}
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
