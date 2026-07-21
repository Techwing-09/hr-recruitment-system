import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Application } from '../models/application';

@Injectable({
  providedIn: 'root'
})
export class ApplicationService {

  private apiUrl = 'http://localhost:8080/api/applications';

  constructor(private http: HttpClient) { }

  // Apply for a Job
  applyJob(application: Application): Observable<string> {
    return this.http.post(`${this.apiUrl}/apply`, application, {
      responseType: 'text'
    });
  }

  // Get All Applications (HR)
  getAllApplications(): Observable<Application[]> {
    return this.http.get<Application[]>(this.apiUrl);
  }

  // Get Application By Id
  getApplicationById(applicationId: number): Observable<Application> {
    return this.http.get<Application>(`${this.apiUrl}/${applicationId}`);
  }

  // Get Applications of Logged-in Candidate
  getApplicationsByCandidate(candidateId: number): Observable<Application[]> {
    return this.http.get<Application[]>(
      `${this.apiUrl}/candidate/${candidateId}`
    );
  }

  // Get Applications for a Job (HR)
  getApplicationsByJob(jobId: number): Observable<Application[]> {
    return this.http.get<Application[]>(
      `${this.apiUrl}/job/${jobId}`
    );
  }

  // Send Offer
  sendOffer(applicationId: number): Observable<string> {
    return this.http.put(
      `${this.apiUrl}/${applicationId}/offer`,
      {},
      { responseType: 'text' }
    );
  }

  // Reject Candidate
  rejectCandidate(applicationId: number): Observable<string> {
    return this.http.put(
      `${this.apiUrl}/${applicationId}/reject`,
      {},
      { responseType: 'text' }
    );
  }

  // Delete Application
  deleteApplication(applicationId: number): Observable<string> {
    return this.http.delete(
      `${this.apiUrl}/${applicationId}`,
      { responseType: 'text' }
    );
  }

}