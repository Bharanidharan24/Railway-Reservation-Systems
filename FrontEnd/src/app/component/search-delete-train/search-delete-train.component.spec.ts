import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchDeleteTrainComponent } from './search-delete-train.component';

describe('SerachDeleteTrainComponent', () => {
  let component: SearchDeleteTrainComponent;
  let fixture: ComponentFixture<SearchDeleteTrainComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchDeleteTrainComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchDeleteTrainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
