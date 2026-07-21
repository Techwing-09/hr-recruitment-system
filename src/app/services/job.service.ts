import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Job } from '../models/job';

@Injectable({
  providedIn: 'root'
})
export class JobService {

  private apiUrl = 'http://localhost:8080/api/jobs';

  constructor(private http: HttpClient) { }

  // Get All Jobs
  getAllJobs(): Observable<Job[]> {

    return this.http.get<Job[]>(this.apiUrl);

  }

  // Get Job By Id
  getJobById(id: number): Observable<Job> {

    return this.http.get<Job>(`${this.apiUrl}/${id}`);

  }

  // Create Job
  createJob(job: Job): Observable<Job> {

    return this.http.post<Job>(this.apiUrl, job);

  }

  // Update Job
  updateJob(id: number, job: Job): Observable<Job> {

    return this.http.put<Job>(`${this.apiUrl}/${id}`, job);

  }

  // Delete Job
deleteJob(id: number): Observable<string> {

  return this.http.delete(`${this.apiUrl}/${id}`, {
    responseType: 'text'
  });

}

}