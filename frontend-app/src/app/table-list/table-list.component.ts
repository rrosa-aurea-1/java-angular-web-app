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

  constructor(public _userService: UserService) { }

  ngOnInit() {

    this.getUsers();
    console.log(JSON.stringify(this.users));
   
  }


  getUsers() {
    
      this._userService.getUsers().subscribe(
        data => {
       
          this.users = data;
          console.log('done loading users '+ console.log(JSON.stringify(this.users)));
          return true;
        },
        error => {
          console.error("Error loading users!");
          return Observable.throw(error);
        }
      );
    }
  

}
