import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SigninComponent } from './signin/signin.component';
import { StressChartComponent } from './stress-chart/stress-chart.component';
import { EnergyChartComponent } from './energy-chart/energy-chart.component';
import { DurationChartComponent } from './duration-chart/duration-chart.component';
import { MetricsComponent } from './metrics/metrics.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent }, 
  { path: 'signin', component: SigninComponent },
  { path: 'stress-chart', component: StressChartComponent},
  { path: 'energy-chart', component: EnergyChartComponent},
  { path: 'duration-chart', component: DurationChartComponent},
  { path: 'metrics', component: MetricsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
