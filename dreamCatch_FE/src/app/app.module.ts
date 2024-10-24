import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule  } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { SigninComponent } from './signin/signin.component';
import { LogoutComponent } from './logout/logout.component';
import { Routes } from '@angular/router';
import { AuthInterceptor } from './AuthInterceptor';
import { EnergyChartComponent } from './energy-chart/energy-chart.component';
import { DurationChartComponent } from './duration-chart/duration-chart.component';
import { StressChartComponent } from './stress-chart/stress-chart.component';
import { NgChartsModule } from 'ng2-charts';
import { MetricsComponent } from './metrics/metrics.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SigninComponent,
    LogoutComponent,
    EnergyChartComponent,
    DurationChartComponent,
    StressChartComponent,
    MetricsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule, 
    NgChartsModule, 
    ReactiveFormsModule 
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
