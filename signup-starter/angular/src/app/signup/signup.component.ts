import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  signupForm = this.fb.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', Validators.required]
  });

  constructor(private fb: FormBuilder) {}

  signup() {
    const data = this.signupForm.value;
    // call backend API
    fetch('http://localhost:8080/api/auth/signup', {
      method: 'POST',
      headers: {'Content-Type': 'application/json'},
      body: JSON.stringify(data)
    }).then(r => r.text()).then(t => alert(t)).catch(e => console.error(e));
  }

  continueWithGoogle() {
    window.location.href = 'http://localhost:8080/oauth2/authorization/google';
  }

  continueWithOutlook() {
    window.location.href = 'http://localhost:8080/oauth2/authorization/microsoft';
  }
}
