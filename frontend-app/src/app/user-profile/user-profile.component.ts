import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { UserService } from './user-profile.service';
import { Observable } from 'rxjs/Rx';
import { Router, ActivatedRoute } from '@angular/router';
import swal from 'sweetalert2';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css'],
  providers: [UserService]
})
export class UserProfileComponent implements OnInit {



  public user = {
    id: '',
    username: '',
    email: '',
    firstname: '',
    lastname: ''
  }

  public type = 'Create';
  public disableId = false;

  constructor(public _userService: UserService, public router: Router, public root: ActivatedRoute) {


  }

  ngOnInit() {

    let id = this.root.snapshot.paramMap.get('id');
    if (id != null) {
      this.getUser(id);
    }
  }

  getUser(id: string) {

    this._userService.getUserById(id).subscribe(
      data => {
        // refresh the list
        if (data != null) {
          this.user = data;
          this.type = 'Update';
          this.disableId = true;
        }
        return data;
      },
      error => {

        console.error(JSON.stringify(error));
        swal('Error!', 'Impossible to get user!', 'error');
        return Observable.throw(error);
      }
    );
  }

  manageUser() {
    if (this.disableId) {
      this.updateUser();

    }
    else {
      this.createUser();
    }

  }


  updateUser() {


    this._userService.updateUser(this.user).subscribe(
      data => {
        // refresh the list
        swal('Updated!', 'User updated!', 'success');
        this.router.navigate(['/user-list']);
        return true;
      },
      error => {
        let status = error.status;
        if (status === 200) {
          // refresh the list
          swal('Updated!', 'User updated!', 'success');
          this.router.navigate(['/user-list']);
          return true;

        }
        else {
          console.error(JSON.stringify(error));
          swal('Error!', 'User not updated!', 'error');
          return Observable.throw(error);
        }
      }
    );
  }




  createUser() {
    this._userService.createUser(this.user).subscribe(
      data => {
        // refresh the list
        swal('Created!', 'User created!', 'success');
        this.router.navigate(['/user-list']);
        return true;
      },
      error => {
        let status = error.status;
        if (status === 200) {
          // refresh the list
          swal('Created!', 'User created!', 'success');
          this.router.navigate(['/user-list']);
          return true;

        }
        else {
          console.error(JSON.stringify(error));
          swal('Error!', 'User not created!', 'error');
          return Observable.throw(error);
        }
      }
    );
  }


}
