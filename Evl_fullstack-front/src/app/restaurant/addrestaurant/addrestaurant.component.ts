import { Component } from '@angular/core';
import {RestaurantService} from "../restaurant.service";
import {Subscription} from "rxjs";
import {FormsModule, NgForm} from "@angular/forms";
import {Router} from "@angular/router";
import {JsonPipe, NgForOf} from "@angular/common";
import {AddRestaurantDto, RestaurantDto, TagDto} from "../restaurant-dto";

@Component({
  selector: 'app-addrestaurant',
  standalone: true,
  imports: [
    FormsModule,
    NgForOf,
    JsonPipe
  ],
  templateUrl: './addrestaurant.component.html',
  styleUrl: './addrestaurant.component.css'
})
export class AddrestaurantComponent {

  public restaurant:AddRestaurantDto = {
    nom: "",
    adresse: "",
    tags:[]

  }

  public isChecked: boolean[] = [
      false,
    false,
    false,
    false,
    false

  ]



  public types: TagDto[] = []
  private subscriptions: Subscription[] = [];

  constructor(private readonly restaurantService: RestaurantService, private router: Router) {
  }

  ngOnInit(): void {
    this.subscriptions.push(this.restaurantService.getTypes().subscribe({
      next: t => {
        this.types = t;
      }
    }));
  }

  addLivre(formAddRestaurant: NgForm) {
    if (formAddRestaurant.valid) {
      this.restaurant.nom= formAddRestaurant.value.nom;
      this.restaurant.adresse= formAddRestaurant.value.adresse;
      //ajout des tags correspondant aux checkbox cochées
        for(let i=0;i<this.isChecked.length;i++){
            if(this.isChecked[i]){
            this.restaurant.tags.push(this.types[i]);
            }
        }



       this.subscriptions.push(this.restaurantService.addRestaurant(this.restaurant).subscribe({
         next: () => {
           this.router.navigate(["/restaurants"]);
         }
       }));


   }


    }

  ngOnDestroy(): void {
    this.subscriptions.forEach(s => s.unsubscribe());
  }
}
