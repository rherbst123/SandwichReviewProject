import { Injectable } from '@angular/core';

import { Sandwich } from './sandwich';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Title } from '@angular/platform-browser';
import { RouterLink } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class SandwichService {
  

  private sandwichURL = "http://localhost:8080/sandwiches";

  constructor(private http: HttpClient) { }

  public getAllSandwiches(): Observable<any>{
    return this.http.get<Sandwich[]>(this.sandwichURL);
  }
 
  public getByShop(shop: String): Observable<any>{
    return this.http.get<Sandwich[]>(this.sandwichURL + "/byshop/" + shop);
  }
 
  public getSandwich(name: String): Observable<any> {  
    return this.http.get<Sandwich[]>(this.sandwichURL + "/" + name);
  }

  public addSandwich(sandwich: Sandwich) {
    return this.http.post<Sandwich>(this.sandwichURL, sandwich);
  }


  public editSandwich(name: Sandwich) {
    return this.http.put<Sandwich>(this.sandwichURL, name);
  }

  public deleteSandwich(name: string): Observable<any> {  
    return this.http.delete<Sandwich[]>(this.sandwichURL + "/" + name);
  }
}
