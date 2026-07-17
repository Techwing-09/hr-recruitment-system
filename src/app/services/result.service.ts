import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ResultService {

  private apiUrl = 'http://localhost:8080/api/results';

  constructor(private http: HttpClient) { }

  getAllResults(): Observable<any> {
    return this.http.get(this.apiUrl);
  }

  getResultById(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/${id}`);
  }

}