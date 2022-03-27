import ListGroup from 'react-bootstrap/ListGroup'


function Semester() {
    function addSemesterTab(key) {
        if (key === "addNewSemester") {
            console.log("add new semester tab");
        } else {
            console.log("just clicking through the semester tabs");
        }
    }


    function alertClicked() {
        alert('You clicked the third ListGroupItem');
    }
    return(
        <ListGroup defaultActiveKey="#link1">
            <ListGroup.Item action href="#link1">
                Link 1
            </ListGroup.Item>
            <ListGroup.Item action href="#link2" disabled>
                Link 2
            </ListGroup.Item>
            <ListGroup.Item action onClick={alertClicked}>
                This one is a button
            </ListGroup.Item>
        </ListGroup>
    );




}
export default Semester;