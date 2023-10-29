import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListoreviewsComponent } from './listoreviews.component';

describe('ListoreviewsComponent', () => {
  let component: ListoreviewsComponent;
  let fixture: ComponentFixture<ListoreviewsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListoreviewsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListoreviewsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
