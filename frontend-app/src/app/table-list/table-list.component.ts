import { Component, OnInit } from '@angular/core';
import { UserService } from '../user-profile/user-profile.service';
import { Observable } from 'rxjs/Rx';
import swal from 'sweetalert2';
import {IUser} from '../user-profile/user.interface';

@Component({
  selector: 'app-table-list',
  templateUrl: './table-list.component.html',
  styleUrls: ['./table-list.component.css'],
  providers: [UserService]
})
export class TableListComponent implements OnInit {

  public users: IUser[];
  public fields: string[];
  public load = false;

  constructor(public _userService: UserService) { }

  ngOnInit() {

    this.getUsers();

  }

  editUser(id: string) {
  }

  deleteUser(id: string) {
    swal({
      title: "Are you sure you want to delete user with '" + id + "' id?",
      text: "You won't be able to revert this!",
      type: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.value) {
        this._userService.deleteUser(id).subscribe(
          data => {
            // refresh the list/*  */
            swal('Deleted!', 'User deleted!', 'success');
            this.getUsers();
            return true;
          },
          error => {
            console.error("Error deleting user!");
            swal('Error!', 'User not deleted!', 'error');
            return Observable.throw(error);
          }
        );
      }
    })
  }



  getUsers() {

    this._userService.getUsers().subscribe(
      data => {

        this.users = data;
        let firstUser = this.users[0];
        this.fields=[];
        this.load = false;
        if (firstUser != undefined) {
          this.fields = Object.keys(firstUser);
          this.load = true;
        }
        console.log('done loading users ' + JSON.stringify(this.users));
        return this.load;
      },
      error => {
        console.error("Error loading users!");
        return Observable.throw(error);
      }
    );
  }


}
