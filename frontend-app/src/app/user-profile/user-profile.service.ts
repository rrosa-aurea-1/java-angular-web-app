
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import {IUser} from './user.interface';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class UserService {

    constructor(private http: HttpClient) { }


    getUserById(id: string): Observable<IUser>  {
        return this.http.get<IUser>('/api/users/' + id);
    }

    getUsers(): Observable<IUser []> {
        return this.http.get<IUser []>('/api/users');
    }

    createUser(user: IUser) : Observable<string> {
        let body = JSON.stringify(user);
        return this.http.post<string>('/api/users/', body, httpOptions);
    }

    updateUser(user: IUser) : Observable<IUser>  {
        let body = JSON.stringify(user);
        return this.http.put<IUser>('/api/users/', body, httpOptions);
    }


    deleteUser(id: string) :Observable<string> {
        return this.http.delete<string>('/api/users/' + id);
    }
}

