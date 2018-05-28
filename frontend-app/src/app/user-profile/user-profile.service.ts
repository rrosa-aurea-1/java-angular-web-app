
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class UserService {

    constructor(private http: HttpClient) { }


    getUserById(id: string) {
        return this.http.get('/api/users/' + id);
    }

    getUsers() {
        return this.http.get('/api/users');
    }

    createUser(user: any) {
        let body = JSON.stringify(user);
        return this.http.post('/api/users/', body, httpOptions);
    }

    updateUser(user: any) {
        let body = JSON.stringify(user);
        return this.http.put('/api/users/', body, httpOptions);
    }


    deleteUser(id: string) {
        return this.http.delete('/api/users/' + id);
    }
}

