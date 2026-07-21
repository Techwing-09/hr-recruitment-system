import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CandidateService } from 'src/app/services/candidate.service';

@Component({
  selector: 'app-candidate-signup',
  templateUrl: './candidate-signup.component.html',
  styleUrls: ['./candidate-signup.component.css']
})
export class CandidateSignupComponent {

  candidate = {

    candidateName: '',
    email: '',
    phone: '',
    password: '',
    confirmPassword: ''

  };

  constructor(
    private router: Router,
    private candidateService: CandidateService
  ) {}

  register() {

    if (
      this.candidate.candidateName == '' ||
      this.candidate.email == '' ||
      this.candidate.phone == '' ||
      this.candidate.password == '' ||
      this.candidate.confirmPassword == ''
    ) {
      alert("Please fill all fields");
      return;
    }

    if (this.candidate.password != this.candidate.confirmPassword) {
      alert("Passwords do not match");
      return;
    }

    const request = {
      candidateName: this.candidate.candidateName,
      email: this.candidate.email,
      phone: this.candidate.phone,
      password: this.candidate.password
    };

    this.candidateService.signup(request).subscribe({

      next: (response) => {

        alert(response.message);

        this.router.navigate(['/candidate-login']);

      },

      error: (error) => {

        console.error(error);

        alert("Registration Failed");

      }

    });

  }

}