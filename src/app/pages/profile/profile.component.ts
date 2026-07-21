import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  profile: any = {};

  editMode: boolean = false;

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
    this.loadProfile();
  }

  // Load HR Profile
  loadProfile(): void {

    const userId = Number(localStorage.getItem('userId'));

    console.log("User ID:", userId);

    this.authService.getUserById(userId).subscribe({

      next: (data: any) => {

        console.log("Profile Data:", data);

        this.profile = data;

      },

      error: (err: any) => {

        console.log(err);

      }

    });

  }

  // Enable Edit Mode
  editProfile(): void {

    this.editMode = true;

  }

  // Save Updated Profile
  saveProfile(): void {

    const userId = Number(localStorage.getItem('userId'));

    this.authService.updateUser(userId, this.profile).subscribe({

      next: (data: any) => {

        alert("Profile Updated Successfully");

        this.profile = data;

        this.editMode = false;

      },

      error: (err: any) => {

        console.log(err);

        alert("Failed to Update Profile");

      }

    });

  }

}