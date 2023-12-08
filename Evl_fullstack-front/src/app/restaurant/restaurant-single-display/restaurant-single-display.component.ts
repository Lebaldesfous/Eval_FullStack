import { Component } from '@angular/core';
import {EvaluationDto, RestaurantDto} from "../restaurant-dto";
import {RestaurantService} from "../restaurant.service";
import {Subscription} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-restaurant-single-display',
  standalone: true,
  imports: [
    NgIf
  ],
  templateUrl: './restaurant-single-display.component.html',
  styleUrl: './restaurant-single-display.component.css'
})
export class RestaurantSingleDisplayComponent {

    public id: number=-1;
    public restaurant: RestaurantDto = {
        id: 0,
        nom: "",
        adresse: "",
        moyenne: -1,
        tags: []
    }

    public subscriptions: Subscription[] = [];
    constructor(private readonly restaurantService: RestaurantService,private routes: ActivatedRoute,private router: Router) {
    }

    ngOnInit() {
      this.id = this.routes.snapshot.params['id'];
        this.subscriptions.push(this.restaurantService.getRestaurant(this.id).subscribe((restaurant: RestaurantDto) => {
            this.restaurant = restaurant;
        }));
    }

  supprimerEvaluation(evaluation:EvaluationDto) {
    this.subscriptions.push(this.restaurantService.supprimerEvaluation(this.id,evaluation.id).subscribe({
      next: () => {
        this.ngOnInit();
      }
    }));


  }
}
