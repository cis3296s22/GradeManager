import Tabs from "react-bootstrap/Tabs";
import Tab from "react-bootstrap/Tab";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import { FaPlus } from "react-icons/fa";
import InputGroup from "react-bootstrap/InputGroup";
// import Form from "react-bootstrap/Form";
import FormControl from "react-bootstrap/FormControl";
import Dropdown from "react-bootstrap/Dropdown";
import DropdownButton from "react-bootstrap/DropdownButton";
import { useState } from "react";
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
  const [show, setShow] = useState(false);

  const showDropdown = () => {
    console.log(show);
    setShow(true);
  };
  const hideDropdown = () => {
    console.log(show);
    setShow(false);
  };

  // ********************************************************

  return (
    <Tabs
      defaultActiveKey="profile"
      id="uncontrolled-tab-example"
      className="mb-3"
      onSelect={addCourseTab}
    >
      <Tab eventKey="SoftwareDesign" title="Software Design">
        <Card border="primary" style={{ width: "35rem", color: "black" }}>
          <Card.Header>Grades</Card.Header>
          <Card.Body>
            {/* <Card.Title>Primary Card Title</Card.Title> */}
            {/* is this div necessary? */}
            <div>
              <InputGroup>
                <InputGroup.Text>Assignment</InputGroup.Text>
                <FormControl aria-label="Assignment" />
                {/* group should be a dropdown with the ability to add new groups */}
                <Dropdown
                  // error has to be with the function call?
                  onMouseOver={() => console.log("onMouseOver")}
                  onMouseEnter={() => console.log("onMouseEnter")}
                  onMouseLeave={() => console.log("onMouseLeave")}
                  //   onMouseEnter={() => showDropdown()}
                  //   onMouseLeave={() => hideDropdown()}
                  show={show}
                >
                  <Dropdown.Toggle variant="success" id="dropdown-basic">
                    Group
                  </Dropdown.Toggle>

                  <Dropdown.Menu>
                    <Dropdown.Item href="#/action-1">Quiz</Dropdown.Item>
                    <Dropdown.Item href="#/action-2">Assignments</Dropdown.Item>
                    <Dropdown.Item href="#/action-3">Attendance</Dropdown.Item>
                  </Dropdown.Menu>
                </Dropdown>
                {/* ************************************************************ */}

                {/* <DropdownButton
                  id="dropdown-basic-button"
                  title="Group"
                  variant="secondary"
                  show={show}
                  //   showDropdown hideDropdown
                  onMouseEnter={console.log("mouse hovering")}
                  onMouseLeave={console.log("mouse NOT hovering")}
                >
                  <Dropdown.Item href="#/action-1">Quiz</Dropdown.Item>
                  <Dropdown.Item href="#/action-2">Assignments</Dropdown.Item>
                  <Dropdown.Item href="#/action-3">Attendence</Dropdown.Item>
                  <Dropdown.Item href="#/action-3"> */}
                {/* <DropdownButton
                      id="dropdown-basic-button-Add-Group"
                      title="Add Group"
                      variant="secondary"
                    ></DropdownButton> */}
                {/* </Dropdown.Item>
                </DropdownButton> */}
                {/* ************************************************************ */}
                {/* <InputGroup.Text>Group</InputGroup.Text>
                <FormControl aria-label="Group" /> */}

                <InputGroup.Text>Grade</InputGroup.Text>
                <FormControl aria-label="Grade" />
              </InputGroup>
              <Button variant="outline-success" onClick={addAssignment}>
                {" "}
                <FaPlus />
                {" Add Assignment "}
              </Button>{" "}
            </div>
            <Card.Text></Card.Text>
          </Card.Body>
        </Card>
      </Tab>
      <Tab eventKey="profile" title="Profile">
        <Card border="primary" style={{ width: "35rem", color: "black" }}>
          <Card.Header>Grades</Card.Header>
          <Card.Body>
            <Card.Title>Primary Card Title</Card.Title>
            <Card.Text>
              Some quick example text to build on the card title and make up the
              bulk of the card's content.
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
              Some quick example text to build on the card title and make up the
              bulk of the card's content.
            </Card.Text>
          </Card.Body>
        </Card>
      </Tab>
    </Tabs>
  );
}

export default Course;

// Course card would take input from the user to enter assignments
// types of assignments should be added by the user

// https://react-bootstrap.github.io/components/tabs/
