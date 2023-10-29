import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SandwichlistComponent } from './sandwichlist.component';

describe('SandwichlistComponent', () => {
  let component: SandwichlistComponent;
  let fixture: ComponentFixture<SandwichlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SandwichlistComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SandwichlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
