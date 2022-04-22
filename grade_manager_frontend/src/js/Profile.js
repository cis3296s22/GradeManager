import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Image from "react-bootstrap/Image";
import { useEffect, useState } from "react";
import Container from "react-bootstrap/Container";

import image from "../icon/profileImage.png";

function Profile() {
  const styles = {
    profileDistance: {
      //   position: "absolute",
      //   width: "75%",
      //   justifyContent: "center",
      //   top: "5rem",
      //   left: "25rem",

      backgroundColor: "grey",
    },
  };
  const [profileInfo, setProfileInfo] = useState({});

  useEffect(() => {
    const fetchData = async () => {
      //   STUDENT PROFILE URL BELOW
      // HARD CODED STUDENT ID HERE
      const studentId = encodeURIComponent("8207732286254237848");
      const data = await fetch(
        `http://localhost:8086/api/v1/Student/getStudent?studentId=1217145871618558908`,

        {
          // mode: "no-cors", //stack over flow says that's a server issue (remove this line?)

          method: "GET",
          headers: {
            Accept: "application/json",
            AccessControlAllowOrigin: "*",
          },
        }
      ); //replace URL here with student
      if (data.ok) {
        const json = await data.json();
        setProfileInfo(json);
        // setProfileInfo({
        //   firstName: "removeadf",
        //   lastName: " setProfileInfoasdf",
        //   age: 91,
        //   email: "test@gmail.comm"
        // });
      }
    };
    fetchData();
  }, []);

  console.log(profileInfo);
  // {"studentId":8403576665033886403,"email":"hi","birthday":null,"age":1,"semesterList":[],"name":"022078925508001002461285"}
  return (
    <Container>
      <Row style={styles.profileDistance}>
        <Col>
          {/* "src/icon/profileImage.png" */}
          <Image src={image} rounded></Image>
        </Col>
        <Col>
          <Row>{profileInfo.name}</Row>
          <Row>{profileInfo.email}</Row>
          <Row>{profileInfo.age} Years Old</Row>
          {/* <Row>{profileInfo.studentId}</Row> */}
        </Col>
      </Row>
    </Container>
  );
}

export default Profile;
