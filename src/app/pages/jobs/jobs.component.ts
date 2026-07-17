import { Component } from '@angular/core';

@Component({
  selector: 'app-jobs',
  templateUrl: './jobs.component.html',
  styleUrls: ['./jobs.component.css']
})
export class JobsComponent {

  jobs = [

    {
      title: 'Java Developer',
      skills: 'Java, Spring Boot',
      experience: '2 Years',
      salary: '8 LPA',
      location: 'Hyderabad',
      description: 'Develop REST APIs using Spring Boot.'
    },

    {
      title: 'Angular Developer',
      skills: 'Angular, TypeScript',
      experience: '1 Year',
      salary: '6 LPA',
      location: 'Bangalore',
      description: 'Develop responsive Angular applications.'
    }

  ];

  editJob(index:number){

    alert("Edit Job : " + this.jobs[index].title);

    // Later navigate to Add Job page
    // and load selected job details

  }

  deleteJob(index:number){

    this.jobs.splice(index,1);

    alert("Job Deleted Successfully");

  }

}