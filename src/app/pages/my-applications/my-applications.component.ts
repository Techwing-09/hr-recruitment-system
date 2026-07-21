import { Component, OnInit } from '@angular/core';
import { Application } from 'src/app/models/application';
import { ApplicationService } from 'src/app/services/application.service';

@Component({
  selector: 'app-my-applications',
  templateUrl: './my-applications.component.html',
  styleUrls: ['./my-applications.component.css']
})
export class MyApplicationsComponent implements OnInit {

  applications: Application[] = [];

  candidateId!: number;

  constructor(
    private applicationService: ApplicationService
  ) { }

  ngOnInit(): void {

    const id = localStorage.getItem('candidateId');

    if (id) {

      this.candidateId = Number(id);

      this.loadApplications();

    } else {

      alert("Please login first.");

    }

  }

  loadApplications(): void {

    this.applicationService.getApplicationsByCandidate(this.candidateId)
      .subscribe({

        next: (data: Application[]) => {

          this.applications = data;

          console.log(this.applications);

        },

        error: (error) => {

          console.error(error);

          alert("Unable to load applications.");

        }

      });

  }

  viewApplication(application: Application): void {

    alert("Application Details for " + application.jobTitle);

  }

}