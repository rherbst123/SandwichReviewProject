import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Sandwich } from '../sandwich';

import { SandwichService } from '../sandwich.service';

import { Router } from '@angular/router';
@Component({
  selector: 'app-addshopsand',
  templateUrl: './addshopsand.component.html',
  styleUrls: ['./addshopsand.component.css']
})
export class AddshopsandComponent implements OnInit {

  sandwich: Sandwich = new Sandwich();

  constructor(private router: Router, private sandwichService: SandwichService, private titleService: Title) { }

  shopAlreadyExists = false;

  onSubmit(): void {
    console.log(this.sandwich);
    this.sandwichService.addSandwich(this.sandwich).subscribe(
      data => {
        console.log(data);
        //bug out
        this.router.navigateByUrl("/addshopsand");
     }, error => {
      if(error.status == '302') {
        console.error("Review already Exists!!");
        this.shopAlreadyExists = true;
      } else {
        //bug out
        this.router.navigateByUrl("/addshopsand");
      }
     });

  }

  ngOnInit(): void {
    this.titleService.setTitle("Add shop and sandwich")
  }

}
