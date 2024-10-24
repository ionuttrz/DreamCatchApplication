import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DurationChartComponent } from './duration-chart.component';

describe('DurationChartComponent', () => {
  let component: DurationChartComponent;
  let fixture: ComponentFixture<DurationChartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DurationChartComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DurationChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
