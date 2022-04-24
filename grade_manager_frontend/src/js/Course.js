import Tabs from "react-bootstrap/Tabs";
import Tab from "react-bootstrap/Tab";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import { FaPlus } from "react-icons/fa";
import InputGroup from "react-bootstrap/InputGroup";
import FormControl from "react-bootstrap/FormControl";
import { useEffect, useState } from "react";

import Assignment from "./Assignment";

// import "../Style/Course.css";

function Course(courses) {
  console.log(courses.courses);

  const [semsCourses, setSemsCourses] = useState([]);
  useEffect(() => {
    setSemsCourses(courses.courses);
  });
  // setSemsCourses(courses.courses);
  console.log(semsCourses);

  const CourseTabs = semsCourses.map((eachCourse, index) => (
    <Tab eventKey={index} title={eachCourse.name} key={index}>
      <Card border="primary">
        <Card.Header>{eachCourse.name}</Card.Header>
        <Card.Body>
          <Assignment ifAddAssignmentDiv={true} assignmentList={eachCourse.assignmentList} />
        </Card.Body>
      </Card>
    </Tab>
  ));

  const [newCourse, setNewCourse] = useState({
    CourseName: null,
    container: null,
  });

  function applyNewCourse(e) {
    // setCourseNames((prevState) => [...prevState, newCourse.CourseName]);
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
  );
}

export default Course;
