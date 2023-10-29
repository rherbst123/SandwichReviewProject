import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ShoplistComponent } from './shoplist/shoplist.component';
import { SandwichService } from './sandwich.service';
import { ReviewService } from './review.service';

import { SandwichlistComponent } from './sandwichlist/sandwichlist.component';
import { ReviewlistComponent } from './reviewlist/reviewlist.component';
import { AddshopsandComponent } from './addshopsand/addshopsand.component';
import { FormsModule } from '@angular/forms';
import { UserlistComponent } from './userlist/userlist.component';
import { ListoreviewsComponent } from './listoreviews/listoreviews.component';


@NgModule({
  declarations: [
    AppComponent,
    ShoplistComponent,
    SandwichlistComponent,
    ReviewlistComponent,
    AddshopsandComponent,
    UserlistComponent,
    ListoreviewsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [SandwichService , ReviewService],
  bootstrap: [AppComponent]
})
export class AppModule { }
