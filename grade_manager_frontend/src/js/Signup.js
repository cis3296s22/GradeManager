import '../Style/SignUpPageLayout.css';
import {Navigate} from "react-router-dom";
import {Container} from "react-bootstrap";
import React from "react";

const initialState = {
  name: "",
  date: "",
  email: "",
  student: "checkbox",
  teacher: "checkbox",
  password: "",
  password_2: "",
  nameError: "",
  dateError: "",
  emailError: "",
  studentError: "",
  teacherError: "",
  passwordError: "",
  password_2Error: "",
};


var isSignedIn = false;
var isSelected = false;


export default class Signup extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      isSignedIn: true,
      isSelected: true
    };
  }
     
  state = initialState

  handleChange = event => {
    const isCheckbox = event.target.type === "checkbox";
    this.setState({
      [event.target.name]: isCheckbox
        ? event.target.checked
        : event.target.value
    });
  };

  validate = () =>{
    
    this.state.nameError = "";
    this.state.dateError = "";
    this.state.emailError = "";
    this.state.passwordError = "";
    this.state.password_2Error = "";

    if (!this.state.name){
      this.state.nameError = "Please Enter A Name!";
    }

    if (!this.state.date){
        this.state.dateError = "Select A Date of Birth!";
      }

    if (!this.state.email){
        this.state.emailError = "Enter An Email!";
      }
      else if (!this.state.email.includes("@") || !this.state.email.includes(".")){
        this.state.emailError = "Invalid Email, missing '@' or '.' ";
      }     
      
    if (!this.state.student.checked && !this.state.teacher.checked){
        this.state.studentError = "Select One Of The Above";
    }

    if (!this.state.password){
        this.state.passwordError = "Please Enter A Password";
      }

    if (!this.state.password_2){ 
        this.state.password_2Error = "Please Enter A Password";
      }

      if (this.state.password != this.state.password_2){
        this.state.passwordError = "Passwords Do Not Match!";
        this.state.password_2Error = "Passwords Do Not Match!";      
      }

      if (this.state.password.length < 8){
        this.state.passwordError = "Password must be at least 8 characters long!";
      }

      if (this.state.password_2.length() < 8){ 
        this.state.password_2Error = "Password must be at least 8 characters long!";
      }

      if (this.state.nameError || this.state.dateError || this.state.emailError || this.state.studentError || this.state.passwordError /*|| this.state.password_2Error*/){
        alert("Please Check Written Messages In Red. Please type random character in any given input to display the various text.");
        if (this.state.name){
          this.setState(this.state.nameError);
        }
        if (this.state.date){
          this.setState(this.state.dateError);
        }
        if (this.state.email){
          this.setState(this.state.emailError);
        }
        if (this.state.student || this.state.teacher){
          this.setState(this.state.studentError);
        }

        this.setState(initialState);
        return false;
      }

      return true;
    }

    handleButtonClicked = event => {
      const isValid = this.validate();
      if (isValid){
        alert('Welcome ' + this.state.name);
        this.state.name = "";
        this.state.date = "";
        this.state.email = "";
        this.state.password = "";
        this.state.password_2 = "";
        this.state.nameError = "";
        this.state.dateError = "";
        this.state.emailError = "";
        this.state.passwordError = "";
        this.state.password_2Error = "";
        this.setState(initialState);
        isSignedIn = isValid;
      }
      
    };

    launchLogin = event => {
      if (true){
      this.setState(initialState);
      isSelected = true;
      }

  };

  

  render() {
  return (
    <div className = "SignUpPageLayout">
      <div className = "SignUpFormat">
        <h2 className = "SignUpHeading">Sign Up Below!</h2>
        <form className = "SignUpForm">

        <input
          className = "NameInputText"
          type = "text"
          name = "name"
          value = {this.state.name}
          onChange = {this.handleChange}
          placeholder = "Name"
          />
          <label className="ErrorMessages">
          <div style = {{ fontSize: 12, color: "red"}}>
            {this.state.nameError}
          </div>
          </label>

          Date of Birth<input
          className = "NameInputText"
          type = "date"
          name = "date"
          value = {this.state.date}
          onChange = {this.handleChange}
          />

          <label className="ErrorMessages">
          <div style = {{ fontSize: 12, color: "red"}}>
            {this.state.dateError}
          </div>
          </label>

        <input
          className = "NameInputText"
          type = "text"
          name = "email"
          value = {this.state.email}
          onChange = {this.handleChange}
          placeholder = "Email"
          />
          <label className="ErrorMessages">
          <div style = {{ fontSize: 12, color: "red"}}>
            {this.state.emailError}
          </div>
          </label>

          <label className= "InstructText">
          <p>Select Whether You Are A Student Or A Teacher</p>
          </label>
          

          <label>Teacher</label>
          <input
          className = "InputText"
          type = "radio"
          name = "radio"
          value = {this.state.teacher}
          onChange = {this.handleChange}
          /> 


          <label>Student</label>
          <input
          className = "InputText"
          type = "radio"
          name = "radio"
          value = {this.state.student}
          onChange = {this.handleChange}
          label = "Student"
          /> 
          <label className="ErrorMessages">
          <div style = {{ fontSize: 12, color: "red"}}>
            {this.state.studentError}
          </div>
          </label>

          <input
          className = "NameInputText"
          type = "password"
          name = "password"
          value = {this.state.password}
          onChange = {this.handleChange}
          placeholder = "Password"
          />
          <label className="ErrorMessages">
          <div style = {{ fontSize: 12, color: "red"}}>
            {this.state.passwordError}
          </div>
          </label>

          <input
          className = "NameInputText"
          type = "password"
          name = "re-password"
          value = {this.state.password2}
          onChange = {this.handleChange}
          placeholder = "Enter Password Again"
          />
          <label className="ErrorMessages">
          <div style = {{ fontSize: 12, color: "red"}}>
            {this.state.password2Error}
          </div>
          </label>

          <p>Passwords Must Be At Least 8 Characters Long</p>

          <button 
          type="button"
          onClick={this.handleButtonClicked}>

          Sign Up</button> 
          <Container>
           {isSignedIn ? <Navigate to = "/Home"></Navigate> : <Navigate to = "/"></Navigate>}
          </Container>

              <button
                  type="button"
                  onClick={this.launchLogin}>
                  <h6>Login If You Already Have An Account</h6>
              </button>
                        
            <Container>
              {isSelected ? <Navigate to = "/"></Navigate> : <Navigate to = "/Signup"></Navigate>}
           </Container>
        </form>

      </div>
    </div>
  );
}
}