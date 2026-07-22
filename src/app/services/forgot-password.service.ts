import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ForgotPassword } from '../models/forgot-password';

@Injectable({
  providedIn: 'root'
})
export class ForgotPasswordService {

  private hrApi = "http://localhost:8080/api/user";
  private candidateApi = "http://localhost:8080/api/candidate";

  constructor(private http: HttpClient) { }

  // HR Forgot Password
  resetHrPassword(data: ForgotPassword): Observable<any> {
    return this.http.put(
      `${this.hrApi}/forgot-password`,
      data,
      { responseType: 'text' }
    );
  }

  // Candidate Forgot Password
  resetCandidatePassword(data: ForgotPassword): Observable<any> {
    return this.http.put(
      `${this.candidateApi}/forgot-password`,
      data,
      { responseType: 'text' }
    );
  }
}