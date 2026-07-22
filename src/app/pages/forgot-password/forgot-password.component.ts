import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ForgotPassword } from 'src/app/models/forgot-password';
import { ForgotPasswordService } from 'src/app/services/forgot-password.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  forgotPassword: ForgotPassword = new ForgotPassword();

  confirmPassword: string = '';

  userType: string = '';

  constructor(
    private forgotPasswordService: ForgotPasswordService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {

    this.route.queryParams.subscribe(params => {
      this.userType = params['userType'];
    });

  }

  resetPassword() {

    if (this.forgotPassword.newPassword !== this.confirmPassword) {
      alert("Passwords do not match");
      return;
    }

    if (this.userType === 'hr') {

      this.forgotPasswordService.resetHrPassword(this.forgotPassword).subscribe({

        next: (response) => {
          alert(response);
        },

        error: (error) => {
          alert("Failed to reset HR password.");
          console.log(error);
        }

      });

    } else {

      this.forgotPasswordService.resetCandidatePassword(this.forgotPassword).subscribe({

        next: (response) => {
          alert(response);
        },

        error: (error) => {
          alert("Failed to reset Candidate password.");
          console.log(error);
        }

      });

    }

  }

}