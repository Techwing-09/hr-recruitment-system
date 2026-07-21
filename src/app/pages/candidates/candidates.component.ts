import { Component, OnInit } from '@angular/core';
import { Application } from 'src/app/models/application';
import { ApplicationService } from 'src/app/services/application.service';

@Component({
  selector: 'app-candidates',
  templateUrl: './candidates.component.html',
  styleUrls: ['./candidates.component.css']
})
export class CandidatesComponent implements OnInit {

  candidates: Application[] = [];

  constructor(
    private applicationService: ApplicationService
  ) { }

  ngOnInit(): void {
    this.loadCandidates();
  }

  loadCandidates(): void {

    this.applicationService.getAllApplications().subscribe({

      next: (data: Application[]) => {

        this.candidates = data;
        console.log(this.candidates);

      },

      error: (error) => {

        console.error(error);
        alert("Unable to load candidates.");

      }

    });

  }

  // View Resume
  viewResume(candidateId: number): void {

    if (!candidateId) {
      alert("Candidate ID not found.");
      return;
    }

    window.open(
      `http://localhost:8080/api/resumes/view/${candidateId}`,
      '_blank'
    );

  }

}