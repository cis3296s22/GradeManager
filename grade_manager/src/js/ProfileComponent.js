import React, {useState } from 'react';
import './ProfileComponent.css'

function ProfileComponent() {

    const [name,setName] = useState('Your Name');
    const [grade, setGrade] = useState('Grade level');
    const [about,setAbout] = useState('Name');

        return (
            <div className='ProfileComponent'>
                <div className='upper-container'>
                    <div className= 'image-container'>
                        <img src= " " alt= ' ' height="100px" width= '100px' />
                    </div>
                </div>
            <div className="lower-container">
                <h3> { name } </h3>
                <h4> { grade } </h4>
                <p> { about } </p>
            </div>
        </div>
        )
}

export default ProfileComponent
