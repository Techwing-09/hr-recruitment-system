import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn:'root'
})
export class CandidateService {

  private apiUrl='http://localhost:8080/api/candidates';

  constructor(private http:HttpClient){}

  getCandidates():Observable<any>{

    return this.http.get(this.apiUrl);

  }

  getCandidate(id:number):Observable<any>{

    return this.http.get(`${this.apiUrl}/${id}`);

  }

  updateProfile(id:number,data:any):Observable<any>{

    return this.http.put(`${this.apiUrl}/${id}`,data);

  }

}