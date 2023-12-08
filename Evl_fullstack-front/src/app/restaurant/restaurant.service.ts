import { Injectable } from '@angular/core';
import {RestaurantDto, TagDto} from "./restaurant-dto";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {


  constructor(private httpclient:HttpClient) { }

  public getRestaurants():Observable<RestaurantDto[]>{
    return this.httpclient.get<RestaurantDto[]>('http://localhost:8080/restaurants')

  }

  public getTypes():Observable<TagDto[]>{
    return this.httpclient.get<TagDto[]>('http://localhost:8080/tags')
  }

  public addRestaurant(restaurant:RestaurantDto):Observable<RestaurantDto>{
    return this.httpclient.post<RestaurantDto>('http://localhost:8080/restaurants',restaurant)
  }

    public getRestaurant(id:number):Observable<RestaurantDto>{
        return this.httpclient.get<RestaurantDto>('http://localhost:8080/restaurants/'+id)
    }

    public supprimerEvaluation(id:number,idEvaluation:number):Observable<RestaurantDto>{
        return this.httpclient.delete<RestaurantDto>('http://localhost:8080/restaurants/'+id+'/evaluations/'+idEvaluation)
    }
}
