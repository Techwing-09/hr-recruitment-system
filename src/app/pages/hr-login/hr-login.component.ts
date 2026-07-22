import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-hr-login',
  templateUrl: './hr-login.component.html',
  styleUrls: ['./hr-login.component.css']
})
export class HrLoginComponent {

  user = {
    email: '',
    password: ''
  };

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  login() {

    this.authService.login(this.user).subscribe({

      next: (response: any) => {

        console.log("Login Response:", response);

        localStorage.setItem('userId', response.userId.toString());
        localStorage.setItem('fullName', response.fullName);
        localStorage.setItem('role', response.role);

        alert(response.message);

        this.router.navigate(['/dashboard']);

      },

      error: (error: any) => {

        console.log(error);
        alert('Invalid Email or Password');

      }

    });

  }

  // Forgot Password
  forgotPassword() {
    this.router.navigate(['/forgot-password'], {
      queryParams: { userType: 'hr' }
    });
  }

}