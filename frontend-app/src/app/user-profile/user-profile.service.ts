
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })

};

@Injectable()
export class UserService {

    constructor(private http: HttpClient) { }


    getUserById(id: string): Observable<any> {
        return this.http.get<any>('/api/users/' + id);
    }

    getUsers(): Observable<any[]> {
        return this.http.get<any[]>('/api/users');
    }

    createUser(user: any): Observable<string> {
        let body = JSON.stringify(user);
        return this.http.post<string>('/api/users/', body, httpOptions);
    }

    updateUser(user: any): Observable<any> {
        let body = JSON.stringify(user);
        return this.http.put<any>('/api/users/' + user.id, body, httpOptions);
    }


    deleteUser(id: string): Observable<string> {
        return this.http.delete<string>('/api/users/' + id);
    }
}

