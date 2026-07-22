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

    // Get logged-in candidate ID from localStorage
    const candidateId = Number(localStorage.getItem("candidateId"));

    if (candidateId) {

      this.loadDashboard(candidateId);

    } else {

      console.error("Candidate ID not found in localStorage.");

    }

  }

  loadDashboard(candidateId: number): void {

    this.dashboardService.getDashboard(candidateId).subscribe({

      next: (data) => {

        console.log("Dashboard Data:", data);

        this.dashboard = data;

      },

      error: (error) => {

        console.error("Dashboard Error:", error);

      }

    });

  }

}