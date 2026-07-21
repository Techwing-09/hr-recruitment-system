import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Job } from 'src/app/models/job';
import { JobService } from 'src/app/services/job.service';

@Component({
  selector: 'app-add-job',
  templateUrl: './add-job.component.html',
  styleUrls: ['./add-job.component.css']
})
export class AddJobComponent implements OnInit {

  job: Job = {
    jobTitle: '',
    companyName: '',
    requiredSkills: '',
    experience: '',
    salary: '',
    location: '',
    jobDescription: ''
  };

  jobId!: number;
  isEdit = false;

  constructor(
    private jobService: JobService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {

    this.route.params.subscribe(params => {

      if (params['id']) {

        this.jobId = +params['id'];
        this.isEdit = true;

        this.jobService.getJobById(this.jobId).subscribe({

          next: (data) => {

            this.job = data;

          },

          error: (err) => {

            console.error(err);
            alert("Unable to load job details.");

          }

        });

      }

    });

  }

  saveJob() {

    if (this.isEdit) {

      this.jobService.updateJob(this.jobId, this.job).subscribe({

        next: () => {

          alert("Job Updated Successfully");
          this.router.navigate(['/jobs']);

        },

        error: (err) => {

          console.error(err);
          alert("Failed to update job.");

        }

      });

    } else {

      this.jobService.createJob(this.job).subscribe({

        next: () => {

          alert("Job Posted Successfully");
          this.clearForm();
          this.router.navigate(['/jobs']);

        },

        error: (err) => {

          console.error(err);
          alert("Failed to Post Job");

        }

      });

    }

  }

  clearForm() {

    this.job = {
      jobTitle: '',
      companyName: '',
      requiredSkills: '',
      experience: '',
      salary: '',
      location: '',
      jobDescription: ''
    };

  }

}