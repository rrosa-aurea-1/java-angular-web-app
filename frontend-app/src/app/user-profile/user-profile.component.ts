import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { UserService } from './user.service';
import { Observable } from 'rxjs/Rx';
import swal from 'sweetalert2';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css'],
  providers: [UserService]
})
export class UserProfileComponent implements OnInit {

  public users;

  user: any = {
    username: '',
    email: '',
    firstname: '',
    lastname: ''
  }

  constructor(public _userService: UserService) {


  }



  ngOnInit() {

    this.getUsers();
  }

  getUsers() {
    this._userService.getUsers().subscribe(
      data => { this.users = data },
      err => console.error(err),
      () => console.log('done loading users')
    );
  }

  createUser() {
    this._userService.createUser(this.user).subscribe(
      data => {
        // refresh the list
        this.getUsers();
        swal('Created!', 'User created!', 'success');
        return true;
      },
      error => {
        console.error("Error saving user!");
        swal('Error!', 'User not created!', 'error');
        return Observable.throw(error);
      }
    );
  }

  deleteUser(user: any) {
    if (confirm("Are you sure you want to delete " + user.username + "?")) {
      this._userService.deleteUser(user).subscribe(
        data => {
          // refresh the list
          this.getUsers();
          return true;
        },
        error => {
          console.error("Error deleting user!");
          return Observable.throw(error);
        }
      );
    }
  }

}
