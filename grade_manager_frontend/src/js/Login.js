import React, { useRef, useState } from "react";
import {Navigate} from "react-router-dom";
import '../Style/LoginPageLayout.css';
import {Container} from "react-bootstrap";

const initialState = {
    email: "",
    password: ""

};

var isLoggedIn = false;
var isClicked = false;


export default class Login extends React.Component {

    state = initialState

    handleChange = event => {
        const isCheckbox = event.target.type == "checkbox";
        this.setState({
            [event.target.name]: isCheckbox
                ? event.target.checked
                : event.target.value
        });
    };

    validate = () =>{

        this.state.emailError = "";
        this.state.passwordError = "";


        if (!this.state.email){
            this.state.emailError = "Enter your Email!";
        }
        if (!this.state.email.includes("@")){
            this.state.emailError = "Invalid Email";
        }

        if (!this.state.password){
            this.state.passwordError = "Please Enter the Password";
        }

        if (this.state.passwordError || this.state.emailError){
            this.setState(initialState);
            return false;
        }

        return true;
    }

    handleButtonClicked = event => {
        const isValid = this.validate();
        
        if (isValid){ 
            alert('Welcome Again!');
            this.setState(initialState);
            isLoggedIn = isValid;
        }
            
    };

    launchSign = event => {
        if (true){
        alert("Please Sign Up!");
        this.setState(initialState);
        isClicked = true;
        }

    };



    render() {

        return (
            <div className = "LoginPageLayout">
                <div className = "LoginFormat">
                <h2 className = "GradeHeader"> 
                    Grade Manager </h2>
                    <h2 className = "LoginHeading">
                        Login!</h2>
                    <form className = "LoginForm">

                        <input
                            className = "NameInputText"
                            type = "text"
                            name = "email"
                            value = {this.state.email}
                            onChange = {this.handleChange}
                            placeholder = "Email"
                        />
                        <div style = {{ fontSize: 12, color: "red"}}>
                            {this.state.emailError}
                        </div>

                        <input
                            className = "NameInputText"
                            type = "password"
                            name = "password"
                            value = {this.state.password}
                            onChange = {this.handleChange}
                            placeholder = "Password"
                        />
                        <div style = {{ fontSize: 12, color: "red"}}>
                            {this.state.passwordError}
                        </div>

                            
                        <button
                            className= "LogButton"
                            type="button"
                            onClick={this.handleButtonClicked}>
                            Login</button>

                        <Container>
                            {isLoggedIn ? <Navigate replace to = "/Home"></Navigate> : <></>}
                        </Container>


                        
                        <button
                            className= "SignupButton"
                            type="button"
                            onClick={this.launchSign}>
                            <h6>Don't have an account? Sign up</h6>
                            </button>
                        
                        <Container>
                            {isClicked ? <Navigate replace to = "/Signup"></Navigate> : <></>}
                        </Container>     
                

                    </form>

                </div>
            </div>
        );
    }
}
