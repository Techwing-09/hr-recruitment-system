import { Component } from '@angular/core';
import { Router } from '@angular/router';

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

  constructor(private router: Router){}

  login(){

    if(this.candidate.email=='' || this.candidate.password==''){

      alert("Please enter Email and Password");

      return;

    }

    alert("Login Successful");

    this.router.navigate(['/candidate-dashboard']);

  }

}