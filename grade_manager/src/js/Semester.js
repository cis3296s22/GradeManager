import ListGroup from "react-bootstrap/ListGroup";
import "../Style/Semester.css";

function Semester() {
  // const[newSemester, setNewSemester] = useState({
  //   semester
  // })
  function addSemesterTab(e) {
    console.log("should add new semester here?");
    //  put all the semster into an array? and map through
    // add new semester to this array and render it below instead
    //  render a new semester? and send it to the database?
  }

  // const numbers = [1, 2, 3, 4, 5];
  // const listItemss = numbers.map((number) => <li>{number}</li>);
  // <ul>{listItems}</ul>;

  const semesterNames = [
    "Semester 1",
    "Semester 2",
    "Semester 3",
    "Semester 4",
    "Semester 5",
    "Semester 6",
    "Semester 7",
    "Add New Semester",
  ];
  const listItems = semesterNames.map((semester) => (
    <ListGroup.Item action eventKey={semester} key={semester}>
      {semester}
    </ListGroup.Item>
  ));

  return (
    <ListGroup defaultActiveKey="#link1" bsPrefix="SemesterContainer">
      {listItems}
    </ListGroup>
  );
}
export default Semester;
