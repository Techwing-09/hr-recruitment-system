import { Component, OnInit } from '@angular/core';
import { CandidateDashboardService } from '../../services/candidate-dashboard.service';

@Component({
  selector: 'app-candidate-dashboard',
  templateUrl: './candidate-dashboard.component.html',
  styleUrls: ['./candidate-dashboard.component.css']
})
export class CandidateDashboardComponent implements OnInit {

  dashboard: any = {};

  constructor(private dashboardService: CandidateDashboardService) { }

  ngOnInit(): void {

    // Replace 1 with the logged-in candidate ID later
    this.loadDashboard(1);

  }

  loadDashboard(candidateId: number): void {

    this.dashboardService.getDashboard(candidateId).subscribe({

      next: (data) => {

        console.log(data);
        this.dashboard = data;

      },

      error: (error) => {

        console.error(error);

      }

    });

  }

}
