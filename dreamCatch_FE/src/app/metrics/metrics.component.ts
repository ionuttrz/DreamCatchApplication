import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Metrics } from '../metrics-model/metrics';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MetricsService } from '../metrics-service/metrics.service';
import { HttpClient } from '@angular/common/http';
import { NrOfDaysService } from '../no-days-service/nr-of-days.service';

@Component({
  selector: 'app-metrics',
  templateUrl: './metrics.component.html',
  styleUrls: ['./metrics.component.css']
})
export class MetricsComponent {
  selectedDate: string = '';
  selectedDuration: number = 1;
  selectedStress: number = 1;
  selectedEnergy: number = 1;
  selectedTag: string = 'neutral';

  showDurationChart:boolean = false;
  showEnergyChart:boolean = false;
  showStressChart:boolean = false;

  showWeekly:boolean = true;
  showMonthly:boolean = false;

  nrOfDays: number;

  buttonDuration(){
    this.showDurationChart=true;

    this.showEnergyChart= false;
    this.showStressChart = false;
  }

  buttonEnergy(){
    this.showEnergyChart=true;

    this.showDurationChart=false;
    this.showStressChart = false;
  }

  buttonStress(){
    this.showStressChart=true;

    this.showDurationChart=false;
    this.showEnergyChart= false;
  }

  onStrategyChange(event:any){
    const selectedStrategy = event.target.value;
    if (selectedStrategy === 'Week') {
      this.showWeekly= true;
      this.showMonthly = false;
      this.nrOfDaysService.setNrOfDays(6);
    } else if (selectedStrategy === 'Month') {
      this.showWeekly= false;
      this.showMonthly = true;
      this.nrOfDaysService.setNrOfDays(29);
    }

  }

  

  metrics: Metrics = new Metrics();
  form!: FormGroup;
  loading = false;
  submitted = false;
  
  constructor(private formBuilder: FormBuilder,
              private router:Router,
              private metricsService: MetricsService,
              private http: HttpClient, 
              private nrOfDaysService:NrOfDaysService
              ){}

  ngOnInit() {
    this.form = this.formBuilder.group({
      emailUser: ['', Validators.required],
      date: ['', Validators.required],
      lvlDuration: ['', [Validators.required, Validators.min(0), Validators.max(5)]],
      lvlEnergy: ['', [Validators.required, Validators.min(0), Validators.max(5)]],
      lvlStress: ['', [Validators.required, Validators.min(0), Validators.max(5)]],
      tag: ['', Validators.required]
    });
    this.nrOfDays = this.nrOfDaysService.getNrOfDays();
  }

  onSubmit() {
    this.submitted = true;

    console.log(this.metrics.emailUser);
    console.log(this.metrics.date);
    console.log(this.metrics.lvlDuration);
    console.log(this.metrics.lvlEnergy);
    console.log(this.metrics.lvlStress);
    console.log(this.metrics.tag);
    this.loading = true;
    this.metricsService.addMetrics(this.metrics).subscribe({
      next: data => {
        console.log(data);
        console.log("yes");
        alert("New Metrics Added");
      },
      error: err => {
        console.log(err);
      }
    });
  }
}

