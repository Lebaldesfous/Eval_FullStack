import {Component, Input} from '@angular/core';
import {RestaurantDto} from "../restaurant-dto";
import {NgForOf} from "@angular/common";
import {RestaurantDirective} from "../restaurant.directive";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-restaurant-display',
  standalone: true,
  imports: [
    NgForOf,
    RestaurantDirective,
    RouterLink
  ],
  templateUrl: './restaurant-display.component.html',
  styleUrl: './restaurant-display.component.css'
})
export class RestaurantDisplayComponent {

  public restaurants: RestaurantDto[]=[];

  @Input("restaurants") set restaurant(restaurants: RestaurantDto[]) {
    this.restaurants = restaurants;
  }

}
