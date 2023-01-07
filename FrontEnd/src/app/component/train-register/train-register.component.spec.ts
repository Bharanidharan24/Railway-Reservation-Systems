import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainRegisterComponent } from './train-register.component';

describe('TrainRegisterComponent', () => {
  let component: TrainRegisterComponent;
  let fixture: ComponentFixture<TrainRegisterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrainRegisterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TrainRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
