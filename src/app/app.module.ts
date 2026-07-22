import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
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
import { CandidateLoginComponent } from './pages/candidate-login/candidate-login.component';
import { CandidateSignupComponent } from './pages/candidate-signup/candidate-signup.component';
import { CandidateDashboardComponent } from './pages/candidate-dashboard/candidate-dashboard.component';
import { ApplyJobComponent } from './pages/apply-job/apply-job.component';
import { MyApplicationsComponent } from './pages/my-applications/my-applications.component';
import { PageNotFoundComponent } from './pages/page-not-found/page-not-found.component';
import { HrSidebarComponent } from './components/hr-sidebar/hr-sidebar.component';
import { CandidateSidebarComponent } from './components/candidate-sidebar/candidate-sidebar.component';
import { CandidateProfileComponent } from './pages/candidate-profile/candidate-profile.component';
import { ResumeComponent } from './pages/resume/resume.component';
import { ForgotPasswordComponent } from './pages/forgot-password/forgot-password.component';
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    HomeComponent,
    HrLoginComponent,
    HrSignupComponent,
    DashboardComponent,
    JobsComponent,
    AddJobComponent,
    CandidatesComponent,
    ResultsComponent,
    CandidateResultComponent,
    ProfileComponent,
    CandidateLoginComponent,
    CandidateSignupComponent,
    CandidateDashboardComponent,
    ApplyJobComponent,
    MyApplicationsComponent,
    PageNotFoundComponent,
    HrSidebarComponent,
    CandidateSidebarComponent,
    CandidateProfileComponent,
    ResumeComponent,
    ForgotPasswordComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
     FormsModule,
     HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
