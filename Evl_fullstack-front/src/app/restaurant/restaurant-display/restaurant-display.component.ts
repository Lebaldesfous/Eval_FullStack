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

    //pour chaque restaurant, on calcule la moyenne des notes
    for(let i=0;i<this.restaurants.length;i++){
      let moyenne=0;
      const evaluations=this.restaurants[i].evaluations;
      if(evaluations!==undefined){
        for(let j=0;j<evaluations.length;j++){
          moyenne+=evaluations[j].note;
        }
        moyenne/=evaluations.length;
        if(isNaN(moyenne)){
          this.restaurants[i].moyenne=-1  ;
        }else{
          this.restaurants[i].moyenne=moyenne;
        }

      }

    }
  }

}
