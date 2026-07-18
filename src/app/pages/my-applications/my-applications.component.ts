import { Component } from '@angular/core';

@Component({
  selector: 'app-my-applications',
  templateUrl: './my-applications.component.html',
  styleUrls: ['./my-applications.component.css']
})
export class MyApplicationsComponent {

  applications = [

    {
      jobTitle:'Java Developer',
      date:'18-07-2026',
      matchScore:92,
      interviewStatus:'Completed',
      finalStatus:'Selected'
    },

    {
      jobTitle:'Angular Developer',
      date:'20-07-2026',
      matchScore:85,
      interviewStatus:'Scheduled',
      finalStatus:'Pending'
    }

  ];

  viewApplication(application:any){

    alert("Application Details for " + application.jobTitle);

    // Later navigate to application details page

  }

}