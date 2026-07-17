import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn:'root'
})
export class ApplicationService {

  private apiUrl='http://localhost:8080/api/applications';

  constructor(private http:HttpClient){}

  applyJob(data:any):Observable<any>{

    return this.http.post(this.apiUrl,data);

  }

  getApplications():Observable<any>{

    return this.http.get(this.apiUrl);

  }

  getMyApplications(id:number):Observable<any>{

    return this.http.get(`${this.apiUrl}/candidate/${id}`);

  }

}