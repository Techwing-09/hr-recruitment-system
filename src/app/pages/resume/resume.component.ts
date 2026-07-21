import { Component, OnInit } from '@angular/core';
import { ResumeService } from 'src/app/services/resume.service';

@Component({
  selector: 'app-resume',
  templateUrl: './resume.component.html',
  styleUrls: ['./resume.component.css']
})
export class ResumeComponent implements OnInit {

  candidateId!: number;
  selectedFile!: File;

  constructor(private resumeService: ResumeService) { }

  ngOnInit(): void {

    const id = localStorage.getItem('candidateId');

    if (id) {
      this.candidateId = Number(id);
    } else {
      alert("Please login first.");
    }

  }

  onFileSelected(event: any): void {

    if (event.target.files.length > 0) {
      this.selectedFile = event.target.files[0];
    }

  }

  uploadResume(): void {

    if (!this.selectedFile) {
      alert("Please select a PDF file.");
      return;
    }

    this.resumeService.uploadResume(this.candidateId, this.selectedFile)
      .subscribe({

        next: (response) => {
          alert("Resume uploaded successfully.");
          console.log(response);
        },

        error: (error) => {
          console.error(error);
          alert("Failed to upload resume.");
        }

      });

  }

  viewResume(): void {

    this.resumeService.viewResume(this.candidateId);

  }

}