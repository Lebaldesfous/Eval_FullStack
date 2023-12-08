import { Component } from '@angular/core';
import {AddEvaluationDto, EvaluationDto, RestaurantDto, TagDto} from "../restaurant-dto";
import {RestaurantService} from "../restaurant.service";
import {Subscription} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
import {NgClass, NgForOf, NgIf, NgSwitch, NgSwitchCase} from "@angular/common";
import {FormsModule, NgForm} from "@angular/forms";

@Component({
  selector: 'app-restaurant-single-display',
  standalone: true,
    imports: [
        NgIf,
        NgForOf,
        FormsModule,
        NgSwitch,
        NgSwitchCase,
        NgClass
    ],
  templateUrl: './restaurant-single-display.component.html',
  styleUrl: './restaurant-single-display.component.css'
})
export class RestaurantSingleDisplayComponent {

    public form:boolean=false;
    public id: number=-1;

    public isChecked: boolean[] = [
        false,
        false,
        false,
        false,
        false

    ]
    public restaurant: RestaurantDto = {
        id: 0,
        nom: "",
        adresse: "",
        moyenne: -1,
        tags: []
    }

    public note: number = 0;
    public types: TagDto[] = [];
    public evaluation: AddEvaluationDto = {
        nom: "",
        note: 0,
        commentaire: "",
        dateCreation: new Date(),
        dateModification: new Date()

    }

    public subscriptions: Subscription[] = [];
    constructor(private readonly restaurantService: RestaurantService,private routes: ActivatedRoute,private router: Router) {
    }

    ngOnInit() {
      this.id = this.routes.snapshot.params['id'];
        this.subscriptions.push(this.restaurantService.getRestaurant(this.id).subscribe((restaurant: RestaurantDto) => {
            this.restaurant = restaurant;
        }));

        this.subscriptions.push(this.restaurantService.getTypes().subscribe({
            next: t => {
                this.types = t;
            }
        }));

    }

  supprimerEvaluation(evaluation:EvaluationDto) {
    this.subscriptions.push(this.restaurantService.supprimerEvaluation(this.id,evaluation.id).subscribe({
      next: () => {
        this.ngOnInit();
      }
    }));


  }

   addEvaluation(formAddEvalution:NgForm) {
        if(formAddEvalution.valid){

            this.evaluation.nom=formAddEvalution.value.nom;
            this.evaluation.note=formAddEvalution.value.note;
            this.evaluation.commentaire=formAddEvalution.value.commentaire;
            console.log(this.evaluation);
            this.subscriptions.push(this.restaurantService.addEvaluation(this.id,this.evaluation).subscribe({
                next: () => {
                    this.ngOnInit();
                }
            }));
        }

   }

    modifierRestaurant(formAddRestaurant: NgForm) {
        if (formAddRestaurant.valid) {
            this.restaurant.nom= formAddRestaurant.value.nom;
            this.restaurant.adresse= formAddRestaurant.value.adresse;
            //ajout des tags correspondant aux checkbox cochées
            for(let i=0;i<this.isChecked.length;i++){
                if(this.isChecked[i]){
                    if(this.restaurant.tags===undefined){
                        this.restaurant.tags=[];
                    }
                    this.restaurant.tags.push(this.types[i]);
                }
            }


            this.subscriptions.push(this.restaurantService.modifierRestaurant(this.id,this.restaurant).subscribe({
                next: () => {
                    this.router.navigate(["/restaurants"]);
                }
            }));

        }




    }
}
