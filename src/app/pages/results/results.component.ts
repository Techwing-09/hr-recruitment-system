import { Component } from '@angular/core';

@Component({
  selector: 'app-results',
  templateUrl: './results.component.html',
  styleUrls: ['./results.component.css']
})
export class ResultsComponent {

  results = [

    {
      name:'Rahul',
      job:'Java Developer',
      matchScore:92,
      technical:90,
      communication:88,
      overall:89,
      status:'Selected'
    },

    {
      name:'Priya',
      job:'Angular Developer',
      matchScore:85,
      technical:80,
      communication:82,
      overall:81,
      status:'Selected'
    },

    {
      name:'Kiran',
      job:'Python Developer',
      matchScore:72,
      technical:70,
      communication:68,
      overall:69,
      status:'Rejected'
    }

  ];

}
