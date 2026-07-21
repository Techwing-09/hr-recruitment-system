import { Component, OnInit } from '@angular/core';
import { ResumeService } from 'src/app/services/resume.service';
import { JobService } from 'src/app/services/job.service';
import { ApplicationService } from 'src/app/services/application.service';

import { Job } from 'src/app/models/job';
import { Application } from 'src/app/models/application';

@Component({
  selector: 'app-apply-job',
  templateUrl: './apply-job.component.html',
  styleUrls: ['./apply-job.component.css']
})
export class ApplyJobComponent implements OnInit {

  candidateId!: number;
  selectedFile: File | null = null;

  jobs: Job[] = [];

  constructor(
    private resumeService: ResumeService,
    private jobService: JobService,
    private applicationService: ApplicationService
  ) { }

  ngOnInit(): void {

    const id = localStorage.getItem('candidateId');

    if (id) {

      this.candidateId = Number(id);

    } else {

      alert("Please login first.");
      return;

    }

    this.getAllJobs();

  }

  // Load all jobs
  getAllJobs(): void {

    this.jobService.getAllJobs().subscribe({

      next: (data: Job[]) => {

        this.jobs = data;

      },

      error: (error) => {

        console.error(error);
        alert("Unable to load jobs.");

      }

    });

  }

  // Select Resume
  onFileSelected(event: any): void {

    if (event.target.files.length > 0) {

      this.selectedFile = event.target.files[0];

    }

  }

  // Apply Job
  applyJob(job: Job): void {

    if (!this.selectedFile) {

      alert("Please upload your resume.");
      return;

    }

    // Upload Resume
    this.resumeService.uploadResume(this.candidateId, this.selectedFile)
      .subscribe({

        next: () => {

          const application: Application = {

            candidateId: this.candidateId,
            jobId: job.id!

          };

          // Save Application
          this.applicationService.applyJob(application)
            .subscribe({

              next: (message: string) => {

                alert("Resume Uploaded Successfully");
                alert(message);

                this.selectedFile = null;

              },

              error: (error) => {

                console.error(error);

                if (error.error) {
                  alert(error.error);
                } else {
                  alert("Application failed.");
                }

              }

            });

        },

        error: (error) => {

          console.error(error);

          if (error.error) {
            alert(error.error);
          } else {
            alert("Resume Upload Failed");
          }

        }

      });

  }

}