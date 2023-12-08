import {Directive, ElementRef, Input, Renderer2} from '@angular/core';

@Directive({
  selector: '[appRestaurant]',
  standalone: true
})
export class RestaurantDirective {

  @Input("appRestaurant") set note (note: string) {

    if(parseInt(note)<1){
      this._renderer.setStyle(this._elementRef.nativeElement, 'color', 'red');


    }

    else if (parseInt(note)>2){
      this._renderer.setStyle(this._elementRef.nativeElement, 'color', 'yellow');
    }

  }

  constructor(private _elementRef:ElementRef, private _renderer:Renderer2) { }

}
