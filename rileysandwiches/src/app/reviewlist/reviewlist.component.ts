import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Review } from '../review';
import { ReviewService } from '../review.service';

@Component({
  selector: 'app-reviewlist',
  templateUrl: './reviewlist.component.html',
  styleUrls: ['./reviewlist.component.css']
})
export class ReviewlistComponent implements OnInit {

  name: String;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private reviewService: ReviewService ) { }

  reviews: Review[];

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      var name = params.get('name')!;
      this.reviewService.getSandwich(name).subscribe(
      data => {
        this.reviews = data;
      },
      );


    })
  }
}