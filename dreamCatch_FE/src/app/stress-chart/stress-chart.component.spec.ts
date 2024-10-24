import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StressChartComponent } from './stress-chart.component';

describe('StressChartComponent', () => {
  let component: StressChartComponent;
  let fixture: ComponentFixture<StressChartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StressChartComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StressChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
