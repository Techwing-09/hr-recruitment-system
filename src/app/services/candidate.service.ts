import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CandidateService {

  private apiUrl = 'http://localhost:8080/api/candidate';

  constructor(private http: HttpClient) { }

  // Candidate Signup
  signup(candidate: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/signup`, candidate);
  }

  // Candidate Login
  login(data: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/login`, data);
  }

  // Get All Candidates
  getCandidates(): Observable<any> {
    return this.http.get(this.apiUrl);
  }

  // Get Candidate By Id
  getCandidate(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/${id}`);
  }

  // Update Candidate
  updateCandidate(id: number, data: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/${id}`, data);
  }

  // Delete Candidate
  deleteCandidate(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }

}