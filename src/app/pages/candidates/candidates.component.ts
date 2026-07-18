import { Component } from '@angular/core';

@Component({
  selector: 'app-candidates',
  templateUrl: './candidates.component.html',
  styleUrls: ['./candidates.component.css']
})
export class CandidatesComponent {

  candidates = [

    {
      name: 'Rahul',
      email: 'rahul@gmail.com',
      job: 'Java Developer',
      matchScore: 92,
      status: 'Interview Scheduled'
    },

    {
      name: 'Priya',
      email: 'priya@gmail.com',
      job: 'Angular Developer',
      matchScore: 86,
      status: 'Under Review'
    }

  ];

}
