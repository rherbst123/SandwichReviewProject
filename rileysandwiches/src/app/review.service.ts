import { Injectable } from '@angular/core';

import { Review } from './review';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  private reviewURL = "http://localhost:8080/reviews";

  constructor(private http: HttpClient) { }

 
 
  public getAllReviews(): Observable<any>{
    return this.http.get<Review[]>(this.reviewURL);
  }
  public getSandwich(name: string): Observable<any> {  
    return this.http.get<Review[]>(this.reviewURL + "/" + name);
  }
 
  public getBySandname(name: string): Observable<any> {  
    return this.http.get<Review[]>(this.reviewURL + "/byname/" + name);
  }
  
  public getReview(name: string): Observable<any> {  
    return this.http.get<Review[]>(this.reviewURL + "/" + name);
  }
  

 
 
  public addReview(review: Review) {
    return this.http.post<Review>(this.reviewURL, review);
  }


  public editReview(review: Review) {
    return this.http.put<Review>(this.reviewURL, review);
  }

  public deleteReview(review: string): Observable<any> {  
    return this.http.delete<Review[]>(this.reviewURL + "/" + review);
  }

  
}



