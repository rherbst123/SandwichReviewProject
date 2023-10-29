import { Component, OnInit } from '@angular/core';

import { Title } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { Sandwich } from '../sandwich';
import { SandwichService } from '../sandwich.service';
import { RouterLink } from '@angular/router';


@Component({
  selector: 'app-shoplist',
  templateUrl: './shoplist.component.html',
  styleUrls: ['./shoplist.component.css']
})
export class ShoplistComponent implements OnInit {

  //sandwiches: Sandwich[];


  constructor(private sandwichService: SandwichService, 
              private router: Router, 
              private titleService: Title,
              private route: ActivatedRoute) { }

  //List of Restaurants(Shops) from sandwich
  sandwiches: Sandwich[];

  ngOnInit(): void {

    this.sandwichService.getAllSandwiches().subscribe(
      data => {
        this.sandwiches = data;
      });



  }

}
