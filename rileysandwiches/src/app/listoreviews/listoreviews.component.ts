import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { Review } from '../review';
import { ReviewService } from '../review.service';

@Component({
  selector: 'app-listoreviews',
  templateUrl: './listoreviews.component.html',
  styleUrls: ['./listoreviews.component.css']
})
export class ListoreviewsComponent implements OnInit {

  constructor(private router: Router,
              private route: ActivatedRoute,
              private reviewSerice: ReviewService ) { }

  reviews: Review[];

  ngOnInit(): void {
    this.reviewSerice.getAllReviews().subscribe(
      data => {
        this.reviews = data;
      });



  }

}

