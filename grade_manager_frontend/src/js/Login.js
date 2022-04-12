import '../Style/LoginPageLayout.css';
import React from "react";

const initialState = {
    email: "",
    password: ""

};


export default class Login extends React.Component {

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
        }
    };


    render() {
        return (
            <div className = "LoginPageLayout">
                <div className = "LoginFormat">
                    <h2 className = "LoginHeading">Login!</h2>
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
                            type="button"
                            onClick={this.handleButtonClicked}>

                            Login</button>

                    </form>

                </div>
            </div>
        );
    }
}