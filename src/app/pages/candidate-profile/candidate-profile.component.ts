import { Component } from '@angular/core';

@Component({
  selector: 'app-candidate-profile',
  templateUrl: './candidate-profile.component.html',
  styleUrls: ['./candidate-profile.component.css']
})
export class CandidateProfileComponent {

  candidate = {

    name: 'Rahul Kumar',

    email: 'rahul@gmail.com',

    phone: '9876543210',

    qualification: 'B.Tech - Computer Science',

    skills: 'Java, Spring Boot, Angular',

    experience: 'Fresher',

    address: 'Hyderabad, Telangana'

  };

}