import { Component } from '@angular/core';

@Component({
  selector: 'app-candidate-result',
  templateUrl: './candidate-result.component.html',
  styleUrls: ['./candidate-result.component.css']
})
export class CandidateResultComponent {

  candidate = {

    name: 'Rahul Kumar',

    email: 'rahul@gmail.com',

    phone: '9876543210',

    job: 'Java Developer',

    matchScore: 92,

    technical: 90,

    communication: 88,

    overall: 89,

    feedback: 'Candidate demonstrated strong Java and Spring Boot knowledge with good communication skills. Recommended for selection.',

    status: 'Selected'

  };

}