import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-hr-signup',
  templateUrl: './hr-signup.component.html',
  styleUrls: ['./hr-signup.component.css']
})
export class HrSignupComponent {

  user = {
    fullName: '',
    companyName: '',
    email: '',
    phone: '',
    password: '',
    role: 'HR'
  };

  constructor(
    private authService: AuthService,
    private router: Router
  ) {}

  register() {

    // Validation
    if (
      this.user.fullName.trim() === '' ||
      this.user.companyName.trim() === '' ||
      this.user.email.trim() === '' ||
      this.user.phone.trim() === '' ||
      this.user.password.trim() === ''
    ) {
      alert('Please fill all fields');
      return;
    }

    this.authService.signup(this.user).subscribe({

      next: (response: any) => {

        console.log("Success Response:", response);

        if (response.message) {
          alert(response.message);
        } else {
          alert("HR Registered Successfully");
        }

        this.router.navigate(['/hr-login']);
      },

      error: (error: any) => {

        console.log("Complete Error:", error);
        console.log("Backend Response:", error.error);

        if (error.error && error.error.message) {
          alert(error.error.message);
        }
        else if (typeof error.error === 'string') {
          alert(error.error);
        }
        else {
          alert("Registration Failed");
        }

      }

    });

  }

}