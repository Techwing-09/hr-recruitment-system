import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-candidate-signup',
  templateUrl: './candidate-signup.component.html',
  styleUrls: ['./candidate-signup.component.css']
})
export class CandidateSignupComponent {

  candidate = {

    name: '',
    email: '',
    phone: '',
    password: '',
    confirmPassword: ''

  };

  constructor(private router: Router){}

  register(){

    if(
      this.candidate.name=='' ||
      this.candidate.email=='' ||
      this.candidate.phone=='' ||
      this.candidate.password=='' ||
      this.candidate.confirmPassword==''
    ){

      alert("Please fill all fields");
      return;

    }

    if(this.candidate.password!=this.candidate.confirmPassword){

      alert("Passwords do not match");
      return;

    }

    alert("Registration Successful");

    this.router.navigate(['/candidate-login']);

  }

}