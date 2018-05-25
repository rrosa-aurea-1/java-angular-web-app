import { Component, OnInit } from '@angular/core';
import { UserService } from '../user-profile/user.service';
import { Observable } from 'rxjs/Rx';

@Component({
  selector: 'app-table-list',
  templateUrl: './table-list.component.html',
  styleUrls: ['./table-list.component.css'],
  providers: [UserService]
})
export class TableListComponent implements OnInit {

  public users;
  public fields;

  constructor(public _userService: UserService) { }

  ngOnInit() {

    this.getUsers();

  }


  getUsers() {

    this._userService.getUsers().subscribe(
      data => {

        this.users = data;
        let firstUser=this.users[0];
        if (firstUser != undefined) {
          this.fields= Object.keys(firstUser);
        }
        console.log('done loading users '+ JSON.stringify(this.users));
        return true;
      },
      error => {
        console.error("Error loading users!");
        return Observable.throw(error);
      }
    );
  }


}
