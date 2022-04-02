import '../Style/SignUpPageLayout.css';

function Signup() {
  return (
    <div className = "SignUpPageLayout">
      <div className = "SignUpFormat">
        <h2 className = "SignUpHeading">Sign Up Below!</h2>
        <form className = "SignUpForm">

        <input
          className = "NameInputText"
          type = "text"
          name = "name"
          placeholder = "Name"
          />

        <input
          className = "NameInputText"
          type = "date"
          name = "Date Of Birth"
          placeholder = "D.O.B"
          />

        <input
          className = "NameInputText"
          type = "text"
          name = "email"
          placeholder = "Email"
          />

          <label className= "InstructText">
          <p>Select Whether You Are A Student Or A Teacher</p>
          </label>
          

          <input
          className = "InputText"
          type = "radio"
          name = "Teacher"
          value = "Teacher"
          /> Teacher

          <input
          className = "InputText"
          type = "radio"
          name = "Student"
          label = "Student"
          /> Student

          <input
          className = "NameInputText"
          type = "password"
          name = "Pass"
          placeholder = "Password"
          />

          <input
          className = "NameInputText"
          type = "password"
          name = "R-Pass"
          placeholder = "Re-enter Password"
          />

          <button>
            Sign Up
          </button>

        </form>

      </div>
    </div>
  );
}

export default Signup;
