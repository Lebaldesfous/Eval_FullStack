import { Component } from '@angular/core';
import {RouterOutlet} from "@angular/router";
import {NavbarComponent} from "../../navbar/navbar.component";
import {RestaurantDisplayComponent} from "../restaurant-display/restaurant-display.component";
import {RestaurantDto} from "../restaurant-dto";
import {RestaurantService} from "../restaurant.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-restaurant-head',
  standalone: true,
  imports: [
    RouterOutlet,
    NavbarComponent,
    RestaurantDisplayComponent
  ],
  templateUrl: './restaurant-head.component.html',
  styleUrl: './restaurant-head.component.css'
})
export class RestaurantHeadComponent {

  public restaurants: RestaurantDto[]=[];
  private subscriptions: Subscription[] = [];

  constructor(private readonly restaurantService: RestaurantService) {
  }

  ngOnInit() {
    this.subscriptions.push(this.restaurantService.getRestaurants().subscribe((restaurants: RestaurantDto[]) => {
      this.restaurants = restaurants;
    }));
  }

  ngOnDestroy() {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }

}
