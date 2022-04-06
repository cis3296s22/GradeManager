import '../Style/SignUpPageLayout.css';
import React from "react";

const initialState = {
  name: "",
  date: "",
  email: "",
  student: "",
  teacher: "",
  password: "",
  password_2: "",
  nameError: "",
  dateError: "",
  emailError: "",
  studentError: "",
  teacherError: "",
  passwordError: "",
  password_2Error: ""
};


export default class Signup extends React.Component {
     
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
      
      let nameError = "";
      let dateError = "";
      let emailError = "";
      let passwordError = "";
      let password_2Error = "";
      
      
      if (!this.state.name){
        nameError = "Please Enter A Name!";
      }

      if (!this.state.date){
        dateError = "Select A Date of Birth!";
      }

      if (!this.state.email){
        emailError = "Enter An Email!";
      }

      if (!this.state.email.includes("@")){
        emailError = "Invalid Email";
      }      

      if (!this.state.password){
        passwordError = "Please Enter A Password";
      }

      if (!this.state.password_2){ 
        password_2Error = "Please Enter A Password";
      }

      if (this.state.password != this.state.password_2){
        passwordError = "Passwords Do Not Match!";
        password_2Error = "Passwords Do Not Match!";      
      }

      if (this.state.password.length() < 8){
        passwordError = "Password must be at least 8 characters long!";
      }

      if (this.state.password_2.length() < 8){ 
        password_2Error = "Password must be at least 8 characters long!";
      }

      if (nameError || dateError || emailError || passwordError || password_2Error){
        this.state({nameError, dateError, emailError, passwordError, password_2Error});
        return true;
      }

      return true;
    }

    handleButtonClicked = event => {
      const isValid = this.validate();
      if (isValid){
        alert('Welcome');
        this.setState(initialState);
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
          <div style = {{ fontSize: 12, color: "red"}}>
            {this.state.nameError}
          </div>

          Date of Birth<input
          className = "NameInputText"
          type = "date"
          name = "Date Of Birth"
          value = {this.state.date}
          onChange = {this.handleChange}
          placeholder = "D.O.B"
          />
          <div style = {{ fontSize: 12, color: "red"}}>
            {this.state.dateError}
          </div>

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

          <label className= "InstructText">
          <p>Select Whether You Are A Student Or A Teacher</p>
          </label>
          

          <label>Teacher</label>
          <input
          className = "InputText"
          type = "radio"
          name = "Teacher"
          value = {this.state.teacher}
          onChange = {this.handleChange}
          /> 


          <label>Student</label>
          <input
          className = "InputText"
          type = "radio"
          name = "Student"
          value = {this.state.student}
          onChange = {this.handleChange}
          label = "Student"
          /> 

          <input
          className = "NameInputText"
          type = "password"
          name = "Password"
          value = {this.state.password}
          onChange = {this.handleChange}
          placeholder = "Password"
          />
          <div style = {{ fontSize: 12, color: "red"}}>
            {this.state.passwordError}
          </div>

          <input
          className = "NameInputText"
          type = "password"
          name = "Re-enter Password"
          value = {this.state.password_2}
          onChange = {this.handleChange}
          placeholder = "Re-enter Password"
          />
          <div style = {{ fontSize: 12, color: "red"}}>
            {this.state.password_2Error}
          </div>
          <p>Passwords Must Be At Least 8 Characters Long</p>

          <button 
          type="button"
          onClick={this.handleButtonClicked}>

          Sign Up</button>

        </form>

      </div>
    </div>
  );
}
}
