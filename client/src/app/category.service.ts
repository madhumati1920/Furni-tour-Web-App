import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private baseUrl = 'http://localhost:8080/category';

  constructor(private http: HttpClient) { }

  getCategoryList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  
  createCategory(category: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, category);
  }

}





