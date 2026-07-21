import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CandidateService } from 'src/app/services/candidate.service';

@Component({
  selector: 'app-candidate-login',
  templateUrl: './candidate-login.component.html',
  styleUrls: ['./candidate-login.component.css']
})
export class CandidateLoginComponent {

  candidate = {
    email: '',
    password: ''
  };

  constructor(
    private router: Router,
    private candidateService: CandidateService
  ) { }

  login() {

    if (this.candidate.email === '' || this.candidate.password === '') {
      alert("Please enter Email and Password");
      return;
    }

    this.candidateService.login(this.candidate).subscribe({

      next: (response: any) => {

        console.log("Login Response :", response);

        if (response.message === "Login Successful") {

          // Save candidate details
          localStorage.setItem("candidateId", String(response.id));
          localStorage.setItem("candidateName", response.candidateName);
          localStorage.setItem("candidateEmail", response.email);
          localStorage.setItem("candidatePhone", response.phone);

          console.log("Stored Candidate ID :", localStorage.getItem("candidateId"));

          alert("Login Successful");

          this.router.navigate(['/candidate-dashboard']);

        } else {

          alert(response.message);

        }

      },

      error: (error: any) => {

        console.error(error);
        alert("Invalid Email or Password");

      }

    });

  }

}