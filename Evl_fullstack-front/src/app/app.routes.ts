import { Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {RestaurantHeadComponent} from "./restaurant/restaurant-head/restaurant-head.component";
import {AddrestaurantComponent} from "./restaurant/addrestaurant/addrestaurant.component";
import {
    RestaurantSingleDisplayComponent
} from "./restaurant/restaurant-single-display/restaurant-single-display.component";

export const routes: Routes = [{
  path:'home',component : HomeComponent},
  {path:'restaurants',component:RestaurantHeadComponent},
  {path:'restaurants/add',component:AddrestaurantComponent},
    {path:'restaurants/:id',component:RestaurantSingleDisplayComponent},
  {path:'**',redirectTo:'home',pathMatch:'full'},
  {path:'',redirectTo:'home',pathMatch:'full'}];
