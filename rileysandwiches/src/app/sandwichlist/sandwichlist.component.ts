import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';

import { ActivatedRoute, Router } from '@angular/router';
import { Sandwich } from '../sandwich';
import { SandwichService } from '../sandwich.service';
import { Review } from '../review';
import { ReviewService } from '../review.service';




@Component({
  selector: 'app-sandwichlist',
  templateUrl: './sandwichlist.component.html',
  styleUrls: ['./sandwichlist.component.css']
})
export class SandwichlistComponent implements OnInit {

 shop: String;



review: Review = new Review();
sandwiches: Sandwich[];

  constructor(private route: ActivatedRoute,
              private router: Router,
              private sandwichService: SandwichService,
              private reviewService: ReviewService) { }

 

  ngOnInit(): void {
    this.route.paramMap.subscribe(params =>{
      //! is non null insertion
      var shop = params.get('shop')!;
          this.shop=shop;

      this.sandwichService.getByShop(shop).subscribe
      (data => {
        this.sandwiches = data;
      },
      error => {
        if (error.status == '404'){
          console.error("Review doesnt exist");
        }else{
          console.error("Unknown error");
          console.error(error);
        }
        //in either case router user to list
        this.router.navigateByUrl('/shoplist')
    });
    })
  }
}