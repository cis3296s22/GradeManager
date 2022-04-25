import React, {useState } from 'react';
// import './ProfileComponent.css'
import '../Style/ProfileComponent.css'

function ProfileComponent() {

    const [name,setName] = useState('Students Name: ');
    const [grade, setGrade] = useState('Grade level: ');
    const [about,setAbout] = useState('About: ');

        return (
            <div className='ProfileComponent'>
                <div className='upper-container'>
                    <div className= 'image-container'>
                        <img src= "https://thumbs.dreamstime.com/z/cartoon-alien-holding-paper-pencil-illustration-32608012.jpg" alt= ' ' height="100px" width= '100px' />
                    </div>
                </div>
            <div className="lower-container">
                <h3> { name } </h3>
                <h4> { grade } </h4>
                <p> { about } </p>
            </div>
        </div>
        )

        getDataFromSignup = () => {
            fetch("https://facebook.github.io/react-native/")
              .then(response => response.text())
              .then(data => {
                const $ = cheerio.load(data);
                this.setState({ logos: $(".logos").html() });
              })
              .catch(error => {
                this.setState({ error: error });
              });
            };
}


export default ProfileComponent;