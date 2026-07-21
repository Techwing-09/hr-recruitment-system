import { Component, OnInit } from '@angular/core';
import { DashboardService } from '../../services/dashboard.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  dashboard: any = {};

  recentJobs: any[] = [];

  constructor(private dashboardService: DashboardService) { }

  ngOnInit(): void {
    this.loadDashboard();
  }

  loadDashboard(): void {

    this.dashboardService.getDashboardData().subscribe({

      next: (data: any) => {

        console.log("Dashboard Data:", data);

        this.dashboard = data;

        this.recentJobs = data.recentJobs;

      },

      error: (err: any) => {

        console.error("Dashboard Error:", err);

      }

    });

  }

}