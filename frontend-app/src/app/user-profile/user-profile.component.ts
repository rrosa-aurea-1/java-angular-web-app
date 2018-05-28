import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { UserService } from './user-profile.service';
import { Observable } from 'rxjs/Rx';
import { Router } from '@angular/router';
import swal from 'sweetalert2';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css'],
  providers: [UserService]
})
export class UserProfileComponent implements OnInit {



  user = {
    id: '',
    username: '',
    email: '',
    firstname: '',
    lastname: ''
  }

  constructor(public _userService: UserService, public router: Router) {


  }

  ngOnInit() {

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
        let status=error.status;
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
