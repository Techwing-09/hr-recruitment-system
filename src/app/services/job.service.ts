import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class JobService {

  private apiUrl='http://localhost:8080/api/jobs';

  constructor(private http:HttpClient) { }

  getJobs():Observable<any>{

    return this.http.get(this.apiUrl);

  }

  addJob(job:any):Observable<any>{

    return this.http.post(this.apiUrl,job);

  }

  updateJob(id:number,job:any):Observable<any>{

    return this.http.put(`${this.apiUrl}/${id}`,job);

  }

  deleteJob(id:number):Observable<any>{

    return this.http.delete(`${this.apiUrl}/${id}`);

  }

}