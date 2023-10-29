import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { Users } from '../users';
import { UsersService } from '../users.service';

@Component({
  selector: 'app-userlist',
  templateUrl: './userlist.component.html',
  styleUrls: ['./userlist.component.css']
})
export class UserlistComponent implements OnInit {

  constructor(private userService: UsersService,
    private router: Router, 
              private titleService: Title,
              private route: ActivatedRoute) { }

  user: Users[];

  ngOnInit(): void {
    this.userService.getAll().subscribe(
      data => {
        this.user = data;
      });



  }

}
