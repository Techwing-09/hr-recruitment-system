import { Component, OnInit } from '@angular/core';
import { CandidateService } from 'src/app/services/candidate.service';

@Component({
  selector: 'app-candidate-profile',
  templateUrl: './candidate-profile.component.html',
  styleUrls: ['./candidate-profile.component.css']
})
export class CandidateProfileComponent implements OnInit {

  candidateId!: number;

  isEditMode = false;

  candidate: any = {};

  constructor(private candidateService: CandidateService) { }

  ngOnInit(): void {

    const id = localStorage.getItem('candidateId');

    if (id) {

      this.candidateId = Number(id);

      this.loadCandidate();

    } else {

      alert("Please login first.");

    }

  }

  loadCandidate(): void {

    this.candidateService.getCandidate(this.candidateId).subscribe({

      next: (response: any) => {

        this.candidate = response;

      },

      error: (error: any) => {

        console.error(error);

      }

    });

  }

  editProfile(): void {

    this.isEditMode = true;

  }

  updateProfile(): void {

    this.candidateService.updateCandidate(this.candidateId, this.candidate).subscribe({

      next: (response: any) => {

        alert("Profile Updated Successfully");

        this.isEditMode = false;

        this.loadCandidate();

      },

      error: (error: any) => {

        console.error(error);

        alert("Profile Update Failed");

      }

    });

  }

}