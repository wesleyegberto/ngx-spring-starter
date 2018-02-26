import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import 'rxjs/add/operator/map';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Spring Boot with Angular Works!';
  message = '';
  
  constructor(private http: HttpClient) {
    this.http.get(`/api/hello`)
      .subscribe((model: any) => this.message = model.message);
  }
}
