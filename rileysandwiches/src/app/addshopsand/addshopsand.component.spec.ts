import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddshopsandComponent } from './addshopsand.component';

describe('AddshopsandComponent', () => {
  let component: AddshopsandComponent;
  let fixture: ComponentFixture<AddshopsandComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddshopsandComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddshopsandComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
