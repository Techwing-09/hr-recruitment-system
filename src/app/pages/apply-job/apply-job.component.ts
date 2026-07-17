import { Component } from '@angular/core';

@Component({
  selector: 'app-apply-job',
  templateUrl: './apply-job.component.html',
  styleUrls: ['./apply-job.component.css']
})
export class ApplyJobComponent {

  selectedFile: File | null = null;

  jobs = [

    {
      title:'Java Developer',
      skills:'Java, Spring Boot',
      experience:'2 Years',
      salary:'8 LPA',
      location:'Hyderabad',
      description:'Develop enterprise applications using Spring Boot.'
    },

    {
      title:'Angular Developer',
      skills:'Angular, TypeScript',
      experience:'1 Year',
      salary:'6 LPA',
      location:'Bangalore',
      description:'Develop responsive web applications.'
    }

  ];

  onFileSelected(event:any){

    this.selectedFile = event.target.files[0];

  }

  applyJob(job:any){

    if(!this.selectedFile){

      alert("Please upload your resume.");

      return;

    }

    alert("Application submitted successfully for " + job.title);

  }

}