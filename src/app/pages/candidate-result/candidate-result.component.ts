import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Application } from 'src/app/models/application';
import { ApplicationService } from 'src/app/services/application.service';

@Component({
  selector: 'app-candidate-result',
  templateUrl: './candidate-result.component.html',
  styleUrls: ['./candidate-result.component.css']
})
export class CandidateResultComponent implements OnInit {

  application!: Application;

  constructor(
    private route: ActivatedRoute,
    private applicationService: ApplicationService
  ) {}

  ngOnInit(): void {

    const applicationId = Number(
      this.route.snapshot.paramMap.get('applicationId')
    );

    this.applicationService.getApplicationById(applicationId)
      .subscribe({

        next: (data) => {

          this.application = data;

        },

        error: (error) => {

          console.error(error);
          alert("Unable to load candidate details.");

        }

      });

  }

  sendOffer(): void {

    this.applicationService
      .sendOffer(this.application.applicationId!)
      .subscribe({

        next: (message) => {

          alert(message);

          this.application.finalStatus = "Offer Sent";

        }

      });

  }

  rejectCandidate(): void {

    this.applicationService
      .rejectCandidate(this.application.applicationId!)
      .subscribe({

        next: (message) => {

          alert(message);

          this.application.finalStatus = "Rejected";

        }

      });

  }

  viewResume(): void {

    window.open(
      `http://localhost:8080/api/resumes/view/${this.application.candidateId}`,
      '_blank'
    );

  }

}