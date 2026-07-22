import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './pages/home/home.component';

import { HrLoginComponent } from './pages/hr-login/hr-login.component';
import { HrSignupComponent } from './pages/hr-signup/hr-signup.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { JobsComponent } from './pages/jobs/jobs.component';
import { AddJobComponent } from './pages/add-job/add-job.component';
import { CandidatesComponent } from './pages/candidates/candidates.component';
import { ResultsComponent } from './pages/results/results.component';
import { CandidateResultComponent } from './pages/candidate-result/candidate-result.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { CandidateProfileComponent } from './pages/candidate-profile/candidate-profile.component';
import { ForgotPasswordComponent } from './pages/forgot-password/forgot-password.component';import { CandidateLoginComponent } from './pages/candidate-login/candidate-login.component';
import { CandidateSignupComponent } from './pages/candidate-signup/candidate-signup.component';
import { CandidateDashboardComponent } from './pages/candidate-dashboard/candidate-dashboard.component';
import { ApplyJobComponent } from './pages/apply-job/apply-job.component';
import { MyApplicationsComponent } from './pages/my-applications/my-applications.component';
import { ResumeComponent } from './pages/resume/resume.component';
import { PageNotFoundComponent } from './pages/page-not-found/page-not-found.component';

const routes: Routes = [

  { path: '', redirectTo: 'home', pathMatch: 'full' },

  { path: 'home', component: HomeComponent },
  { path: 'forgot-password',component: ForgotPasswordComponent},
  // HR
  { path: 'hr-login', component: HrLoginComponent },
  { path: 'hr-signup', component: HrSignupComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'jobs', component: JobsComponent },
  { path: 'add-job', component: AddJobComponent },
  { path: 'add-job/:id', component: AddJobComponent },
  { path: 'candidates', component: CandidatesComponent },
  { path: 'results', component: ResultsComponent },
  { path: 'candidate-result/:applicationId', component: CandidateResultComponent },
  { path: 'profile', component: ProfileComponent },

  // Candidate
  { path: 'candidate-login', component: CandidateLoginComponent },
  { path: 'candidate-signup', component: CandidateSignupComponent },
  { path: 'candidate-dashboard', component: CandidateDashboardComponent },
  { path: 'apply-job', component: ApplyJobComponent },
  { path: 'my-applications', component: MyApplicationsComponent },
  { path: 'candidate-profile', component: CandidateProfileComponent },
  {path:'resume',component:ResumeComponent},

  // 404
  { path: '**', component: PageNotFoundComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }