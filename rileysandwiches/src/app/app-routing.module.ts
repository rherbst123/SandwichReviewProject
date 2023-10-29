import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddshopsandComponent } from './addshopsand/addshopsand.component';
import { ListoreviewsComponent } from './listoreviews/listoreviews.component';
import { ReviewlistComponent } from './reviewlist/reviewlist.component';
import { SandwichlistComponent } from './sandwichlist/sandwichlist.component';
import { ShoplistComponent } from './shoplist/shoplist.component';
import { UserlistComponent } from './userlist/userlist.component';


const routes: Routes = [
  {
    path: '',
    redirectTo: '/shoplist',
    pathMatch: 'full'
  },
  {
    path: 'shoplist',
    component: ShoplistComponent
  },
  {
    path: 'sandwiches/:shop',
    component: SandwichlistComponent
  },
  {
    path: 'reviews/:name',
    component: ReviewlistComponent
  },
  {
    path: 'addshopsand',
    component: AddshopsandComponent
  },
  {
    path: 'userlist',
    component: UserlistComponent
  },
  {
    path: 'listoreviews',
    component: ListoreviewsComponent
  },

  {
    //if its unknown go here if you go to something and you have no idea where to go go to student list
    path: '**',
    redirectTo: '/shoplist',
    pathMatch: 'full'
  }



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
