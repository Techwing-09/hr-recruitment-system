import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Job } from 'src/app/models/job';
import { JobService } from 'src/app/services/job.service';

@Component({
  selector: 'app-jobs',
  templateUrl: './jobs.component.html',
  styleUrls: ['./jobs.component.css']
})
export class JobsComponent implements OnInit {

  jobs: Job[] = [];

  constructor(
    private jobService: JobService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadJobs();
  }

  // Load all jobs
  loadJobs(): void {

    this.jobService.getAllJobs().subscribe({

      next: (data) => {

        this.jobs = data;

      },

      error: (error) => {

        console.error(error);

        alert("Failed to load jobs.");

      }

    });

  }

  // Edit Job
  editJob(id: number): void {

    this.router.navigate(['/add-job', id]);

  }

  // Delete Job
  deleteJob(id: number): void {

    if (confirm("Are you sure you want to delete this job?")) {

      this.jobService.deleteJob(id).subscribe({

      next: (message) => {

  alert(message);

  this.loadJobs();

},

        error: (error) => {

          console.error(error);

          alert("Failed to delete job.");

        }

      });

    }

  }

}