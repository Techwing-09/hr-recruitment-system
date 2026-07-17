import { Component } from '@angular/core';

@Component({
  selector: 'app-add-job',
  templateUrl: './add-job.component.html',
  styleUrls: ['./add-job.component.css']
})
export class AddJobComponent {

  job = {

    title:'',
    skills:'',
    experience:'',
    salary:'',
    location:'',
    description:''

  };

  saveJob(){

    console.log(this.job);

    alert("Job Posted Successfully");

    this.clearForm();

  }

  clearForm(){

    this.job = {

      title:'',
      skills:'',
      experience:'',
      salary:'',
      location:'',
      description:''

    };

  }

}