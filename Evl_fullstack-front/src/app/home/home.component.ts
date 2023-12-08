import { Component } from '@angular/core';
import {NavbarComponent} from "../navbar/navbar.component";
import {RestaurantDisplayComponent} from "../restaurant/restaurant-display/restaurant-display.component";
import {RouterOutlet} from "@angular/router";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    NavbarComponent,
    RestaurantDisplayComponent,
    RouterOutlet
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {


}
