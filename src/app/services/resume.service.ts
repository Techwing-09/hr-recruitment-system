import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ResumeService {

  private apiUrl = 'http://localhost:8080/api/resumes';

  constructor(private http: HttpClient) { }

  uploadResume(candidateId: number, file: File) {

    const formData = new FormData();

    formData.append('candidateId', candidateId.toString());
    formData.append('file', file);

    return this.http.post(this.apiUrl + '/upload', formData);

  }

  viewResume(candidateId: number) {

    window.open(this.apiUrl + '/view/' + candidateId, '_blank');

  }

  deleteResume(id: number) {

    return this.http.delete(this.apiUrl + '/' + id, {
      responseType: 'text'
    });

  }

}