import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Users } from './users';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  private userURL = "http://localhost:8080/users";

  constructor(private http: HttpClient) { }

  public getAll(): Observable<any>{
    return this.http.get<Users[]>(this.userURL);
  }
 
 

}
