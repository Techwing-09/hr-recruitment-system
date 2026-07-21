import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CandidateDashboardService {

  private apiUrl = 'http://localhost:8080/api/candidate-dashboard';

  constructor(private http: HttpClient) { }

  getDashboard(candidateId: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${candidateId}`);
  }

}