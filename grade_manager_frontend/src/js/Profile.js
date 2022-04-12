import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Image from "react-bootstrap/Image";
import { useEffect, useState } from "react";
import { FaArchway } from "react-icons/fa";

function Profile() {
  const styles = {
    profileDistance: {
      //   position: "absolute",
      //   top: "5rem",
      //   left: "25rem",
      // figure out how to center this godamn thing
    },
  };
  const [profileInfo, setProfileInfo] = useState({});

  useEffect(() => {
    const fetchData = async () => {
      const data = await fetch("STUDENT PROFILE URL HERE "); //replace URL here with student
      const json = await data.json();
      console.log(json);
      setProfileInfo(json);
    };
    fetchData();
  }, []);
  console.log(profileInfo);
  // {"studentId":8403576665033886403,"email":"hi","birthday":null,"age":1,"semesterList":[],"name":"022078925508001002461285"}
  return (
    <Row style={styles.profileDistance}>
      <Col>
        {/* "src/icon/profileImage.png" */}
        <Image
          src={"https://covers.openlibrary.org/b/isbn/0062060619-M.jpg"}
          rounded
        ></Image>
      </Col>
      <Col>
        <Row>{profileInfo.name}</Row>
        <Row>{profileInfo.email}</Row>
        <Row>{profileInfo.age && <span> Years Old</span>}</Row>
        <Row>{profileInfo.studentId}</Row>
      </Col>
    </Row>
  );
}

export default Profile;
