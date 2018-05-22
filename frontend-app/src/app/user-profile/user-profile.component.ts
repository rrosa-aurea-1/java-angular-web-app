import { Component, OnInit } from '@angular/core';
import { UserService } from './user.service';
import { Observable } from 'rxjs/Rx';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  public users;

  constructor(private _userService: UserService) { }

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
    let user = { id: '1' };
    this._userService.createUser(user).subscribe(
      data => {
        // refresh the list
        this.getUsers();
        return true;
      },
      error => {
        console.error("Error saving user!");
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
