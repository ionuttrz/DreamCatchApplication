import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Metrics } from '../metrics-model/metrics';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MetricsService {
  private baseUrl = "http://localhost:8081/metrics/addEntry";
  constructor(private httpClient: HttpClient) { }

  public addMetrics(metrics: Metrics): Observable<Metrics> {
    console.log(metrics);
    console.log(localStorage.getItem('accessToken'));
    const httpOptions = {
      headers: new HttpHeaders({
        'content-type': 'application/json',
        'authorization': `Bearer ${localStorage.getItem('accessToken')}`
      })
    };
    console.log(httpOptions);
    const url = `${this.baseUrl}`;
    return this.httpClient.post<Metrics>(`${this.baseUrl}`, metrics, httpOptions);
  }
}
