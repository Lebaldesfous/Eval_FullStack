import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestaurantSingleDisplayComponent } from './restaurant-single-display.component';

describe('RestaurantSingleDisplayComponent', () => {
  let component: RestaurantSingleDisplayComponent;
  let fixture: ComponentFixture<RestaurantSingleDisplayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RestaurantSingleDisplayComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RestaurantSingleDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
