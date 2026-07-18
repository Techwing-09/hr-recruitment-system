import { Component } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent {

  profile = {

    name: 'John Smith',

    company: 'TalentMatch Technologies',

    email: 'johnsmith@gmail.com',

    phone: '+91 9876543210',

    role: 'HR Manager',

    address: 'Hyderabad, Telangana'

  };

}