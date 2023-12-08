import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestaurantHeadComponent } from './restaurant-head.component';

describe('RestaurantHeadComponent', () => {
  let component: RestaurantHeadComponent;
  let fixture: ComponentFixture<RestaurantHeadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RestaurantHeadComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RestaurantHeadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
