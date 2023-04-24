import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HajoComponent } from './hajo.component';

describe('HajoComponent', () => {
  let component: HajoComponent;
  let fixture: ComponentFixture<HajoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HajoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HajoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
